/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms;

import org.kephis.cms.utilities.UtilityClass;
import org.kephis.cms.file.controllers.ConfigMapper;
import java.io.File;
import org.kephis.cms.utilities.MemoryWarningSystem;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Random;
import org.kephis.cms.file.controllers.FileXML2DBConverter;
import static org.kephis.cms.file.controllers.FileXML2DBConverter.prepareProcessPhyoByDate;
import org.kephis.cms.webservices.CMSWebService;

/**
 *
 * @author bobby
 */
public class CMS {

    /**
     * @param args the command line arguments
     */
    private static final ConfigMapper configMapper = new ConfigMapper();

    public static void main(String[] args) {
        MemoryWarningSystem.setPercentageUsageThreshold(0.9);
        MemoryWarningSystem mws = new MemoryWarningSystem();
        mws.addListener(new MemoryWarningSystem.Listener() {
            @Override
            public void memoryUsageLow(long usedMemory, long maxMemory) {
                double percentageUsed = ((double) usedMemory) / maxMemory;
                System.out.println("Memory usage low!!! percentageUsed = " + percentageUsed);
                System.exit(0);
            }
        });
        Task task2 = new Task();
        CMSWebService sqs = new CMSWebService();
        try {
            sqs.server();
            task2.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static class Task {

        int progress = 0;
        int disable = 0;

        public Void execute() {

            Random random = new Random();

            while (true) {
                // get start date
                //if less than today process files from today to start day in a inner loop
                //if finished processing files to start date check files for today
                UtilityClass ut = new UtilityClass();
                new FileXML2DBConverter();
                Calendar start = new GregorianCalendar();
                start.setTime(ut.getDatefromString(configMapper.getStartProcessingDate()));
                Calendar end = new GregorianCalendar();
                end.setTime(ut.getCurrentDate());
                int counter = 1;
                while (!start.after(end)) {
                    Date targetDay = start.getTime();
                    // System.out.println(" Processing day " + targetDay);
                    java.util.List<java.io.File> phytoFilesToProcess = prepareProcessPhyoByDate(ut.getStringfDate(targetDay), new File(configMapper.getePhytoTempFolder()));
                    // System.err.println("Processing files"+phytoFilesToProcess.size());
                    if (counter == 7) {
                        java.util.List<java.io.File> todayPhyToFilesToProcess = prepareProcessPhyoByDate(ut.getCurrentDateStr(), new File(configMapper.getePhytoTempFolder()));
                        for (Iterator<File> it = todayPhyToFilesToProcess.iterator(); it.hasNext();) {

                            File file = it.next();
                            //     System.err.println("Processing files "+file.getName());
                            if (FileXML2DBConverter.processsPhyto(file)) {
                                System.err.println("Successfully processed phyto"+file.toString());
                            } else {
                                System.err.println("Error processing the phyto " + file.toString());

                            }
                        }
                        counter = 0;
                    }
                    if ((phytoFilesToProcess == null) || (phytoFilesToProcess.size() == 0)) {
                        start.add(Calendar.DAY_OF_MONTH, 1);
                        counter++;
                        continue;
                    }
                    if (phytoFilesToProcess.size() > 0) {
                        if (phytoFilesToProcess.size() > 90) {
                            //manage progress to max files 
                            for (Iterator<File> it = phytoFilesToProcess.iterator(); it.hasNext();) {
                                File file = it.next();
                                try {
                                    Thread.sleep(random.nextInt(380));
                                } catch (InterruptedException ignore) {
                                }
                                FileXML2DBConverter.processsPhyto(file);
                            }

                        } else {
                            for (Iterator<File> it = phytoFilesToProcess.iterator(); it.hasNext();) {
                                File file = it.next();
                                FileXML2DBConverter.processsPhyto(file);
                            }

                        }
                        start.add(Calendar.DAY_OF_MONTH, 1);
                        counter++;
                        continue;
                    }
                    start.add(Calendar.DAY_OF_MONTH, 1);
                    counter++;

                }
            }

        }
    }

}

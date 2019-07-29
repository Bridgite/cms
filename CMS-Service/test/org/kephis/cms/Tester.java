package org.kephis.cms;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.kephis.cms.file.controllers.ECertFileReader;
import org.kephis.cms.file.controllers.ConfigMapper;
import org.kephis.cms.file.controllers.FileXML2DBConverter;
import org.kephis.cms.utilities.UtilityClass;

/**
 * public class Tester {
 *
 * public static void main(String[] args) { try { /** SimpleDateFormat sdf = new
 * SimpleDateFormat("yyyy-MM-dd"); File[] files; ECertFileReader filter = new
 * ECertFileReader("2014-08-19", "2014-08-20", "");
 *
 *
 * File folder = new File("/home/kim/ecs_xml_v1_phyto_certs");
 * System.out.println(""+filter.getFilesNoInRange(folder, "2014-08-20")); if
 * (folder.listFiles(filter) == null) {
 *
 * files = new File[0]; } else { files = folder.listFiles(filter); for (File f :
 * files) { System.out.println(f.getName() + " " + sdf.format(new
 * Date(f.lastModified()))); } } }
 *
 *
 * final File newEphyto = new File("/cms/tmp/convertedePhyto.xml"); File fi =
 * new File("/home/kim/cms_xml_v1_phyto_certs/kephis_cft_790329.xml"); String
 * sr=fi.getParent(); System.out.println(sr.substring(sr.length() -19,
 * sr.length() - 9)); ECertSignXmlFile signEphyto= new ECertSignXmlFile();
 * signEphyto.getSignedXmlFile(newEphyto,"/cms/2014/10/08/unsigned/kephis_cft_790331.xml");
 * // System.out.println(ECertSignXmlFile.getSignedXmlFile(fi)); } catch
 * (Exception ex) { Logger.getLogger(Tester.class.getName()).log(Level.SEVERE,
 * null, ex); } }
    *
 */

public class Tester {

    public static void main(String[] args) {

        // ConfigMapper configMapper = new ConfigMapper(); ECertFileReader filter;
        //   filter = new ECertFileReader("2014-08-30", "2014-08-30", configMapper.getCMSRootFolder());
        //  System.out.println("2014-08-20" + " count " + filter.getFilesNoInRange(new File(configMapper.getCMSRootFolder()), "2014-08-30")); 
        UtilityClass util = new UtilityClass();
        ConfigMapper configMapper = new ConfigMapper();
        System.err.println("time" + util.getCurrentTime());
        UtilityClass ut = new UtilityClass();
        new FileXML2DBConverter();
        Calendar start = new GregorianCalendar();
        System.out.println("Time:"+start);
        start.setTime(ut.getDatefromString(configMapper.getStartProcessingDate()));
        System.out.println("Time:"+start);
        Calendar end = new GregorianCalendar();
        end.setTime(ut.getCurrentDate());
        int counter = 1;
            System.out.println("Time:"+!start.after(end));
            
             Date targetDay = start.getTime();
             System.out.println("targetDay:"+start.getTime());
       // while (!start.after(end)) 
        
    
    /**
     * try { FileXML2DBConverter.FileXML2DBConverter(); } catch (Exception e) {
     * }
     *
     *
     *
     * EntityManagerFactory emf =
     * Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
     * ECertificateJpaController ecertCntrl = new
     * ECertificateJpaController(emf); String[] result; result =
     * ecertCntrl.findECertificateEntitiesByDate(0,"2011-04-01", "2011-12-12");
     *
     * for (String string : result) { System.out.println(string) ; }
     *
     * // ConfigMapper cm = new ConfigMapper(); //String unsignedEPhytoFolder =
     * ConfigMapper.getCMSRootFolder(); // System.out.println("file" +
     * unsignedEPhytoFolder); /** ConfigMapper configMapper = new
     * ConfigMapper(); ECertFileReader filter;
     *
     * File ecsFolder = new File(ConfigMapper.getOptionalECSFolder()); filter =
     * new ECertFileReader("2014-08-30", "2014-08-30", ecsFolder.getPath());
     * System.out.println("2014-08-20" + " count " +
     * filter.getFilesNoInRange(ecsFolder, "2014-08-30")); File file[] =
     * ecsFolder.listFiles(filter); for (int i = 0; i < file.length; i++) {
     * System.out.println(file[i]); // File dayphytoFile = new
     * File(ConfigMapper.getCMSRootFolder() + File.separator + year +
     * File.separator + date.substring(5, 7) + File.separator +
     * date.substring(8, 10) + File.separator + "unsigned" + File.separator +
     * file[i]);
     *
     * }
     * }
     *
     *
     * }
     *
     *
     * }
     * *
     */
    }}
package org.kephis.cms.file.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 * *
 *
 * @author kim
 *
 * The class phrases the xml class and filters files based on date
 */
public class ECertFileReader implements FilenameFilter {

    private static String FileContents = "";
    private final File fFile;
    String dateStart;
    String dateEnd;
    SimpleDateFormat sdf;

    public ECertFileReader(String aFileName) {
        this.fFile = new File(aFileName);
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public ECertFileReader() {
        fFile = new File("tmp");
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public ECertFileReader(String dateStart, String dateEnd, String aFileName) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.fFile = new File(aFileName);
    }

    public String getFileContents() {
        return FileContents;
    }

    public void setFileContents(String FileContents) {
        FileContents = FileContents;
    }

    public String getFileContents(String fFile) {
        ECertFileReader parser = new ECertFileReader(fFile);
        FileContents = convertXMLFileToString(fFile);
        return FileContents;
    }

  

    public String convertXMLFileToString(String fileName) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            InputStream inputStream = new FileInputStream(new File(fileName));
            Document doc = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
            StringWriter stw = new StringWriter();
            Transformer serializer = TransformerFactory.newInstance().newTransformer();
            serializer.transform(new DOMSource(doc), new StreamResult(stw));
            return stw.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } 
    }

    @Override
    public boolean accept(File dir, String name) {
        Date d = new Date(new File(dir, name).lastModified());
        String current = sdf.format(d);
        return ((dateStart.compareTo(current) <= 0)
                && (dateEnd.compareTo(current) >= 0));
    }

    public int getFilesNoInRange(File dir, String date) {
        Integer yearofdate = Integer.parseInt(date.substring(0, 4));
        Integer monthofdate = Integer.parseInt(date.substring(5, 7));
        Integer dayofdate = Integer.parseInt(date.substring(8, 10));
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, yearofdate);
        calendar.set(Calendar.MONTH, monthofdate - 1); // 11 = december
        calendar.set(Calendar.DATE, dayofdate); // new years eve 
        int numDays = calendar.getActualMaximum(Calendar.DATE);
        ECertFileReader filter = new ECertFileReader(yearofdate + "-" + monthofdate + "-" + dayofdate, date, "");
        if (dir.listFiles(filter) == null) {
            return 0;
        }
        if (dir.listFiles(filter).length > 0) {
            return dir.listFiles(filter).length;
        }
        filter = new ECertFileReader(yearofdate + "-" + (monthofdate - 1) + "-" + numDays, date, "");
        if (dir.listFiles(filter).length > 0) {
            return dir.listFiles(filter).length;
        }
        filter = new ECertFileReader(yearofdate + "-" + (monthofdate - 1) + "-" + numDays, yearofdate + "-" + monthofdate + "-" + dayofdate+1, "");
        if (dir.listFiles(filter).length > 0) {
            return dir.listFiles(filter).length;
        }
        filter = new ECertFileReader((yearofdate - 1) + "-12" + "-31", date, "");
        if (dir.listFiles(filter).length > 0) {
            return dir.listFiles(filter).length;
        }

        return 0;
    }

    private String getDateBeforeString(String date) {

        date = formateDate(date);
        int yearofdate = Integer.parseInt(date.substring(0, 4));
        int monthofdate = Integer.parseInt(date.substring(5, 7));
        int dayofdate = Integer.parseInt(date.substring(8, 10));
        System.out.println(" d" + date.substring(5, 7));
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.YEAR, yearofdate);
        cal.set(Calendar.MONTH, monthofdate - 1);
        cal.set(Calendar.DATE, dayofdate - 1);

        return formateDate(cal.getTime().toString());

    }

    public static String formateDate(String dateString) {
        Date date;
        String formattedDate = "";
        try {
            date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateString);
            formattedDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
        } catch (ParseException e) {
        }

        return formattedDate;
    }

}

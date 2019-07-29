package org.kephis.cms.utilities;

import org.kephis.cms.file.controllers.ConfigMapper;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.IncludedSPSTradeLineItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kim
 */
public class UtilityClass {

    public UtilityClass() {
        new ConfigMapper();
    }

    public String getCurrentDateStr() {
        Date curdate = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        return sdf1.format(curdate);
    }

    public Date getCurrentDate() {
        Date curdate = new Date();
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            return sdf1.parse(sdf1.format(curdate));
        } catch (ParseException ex) {
            Logger.getLogger(UtilityClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curdate;
    }

    public Date getCurrentTime() {
        Date curdate = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.UK);
            sdf.setTimeZone(TimeZone.getTimeZone("Africa/Nairobi"));
            //System.out.println(sdf.format(new Date()));
            return sdf.parse(sdf.format(curdate));
        } catch (ParseException ex) {
            Logger.getLogger(UtilityClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curdate;
    }

    public Date getDatefromString(String date) {
        Calendar Date = new GregorianCalendar();
        Date.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
        Date.set(Calendar.MONTH, Integer.parseInt(date.substring(5, 7)));
        Date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(8, 10)));
        return Date.getTime();
    }

    public String getStringfDate(Date date) {

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);

    }

    public static <T> void removeDuplicate(List<T> list) {
        Set<T> set = new HashSet<T>();
        List<T> newList = new ArrayList<T>();
        for (Iterator<T> iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add((T) element)) {
                newList.add((T) element);
            }
        }
        list.clear();
        list.addAll(newList);
    }

}

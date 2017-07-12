package com.sevenwest.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by srilatha on 10/07/2017.
 */

public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.SSS";

    /**
     *Converts from one String Date format to another String Date format
     */
    public static String parseStringDateToStringDate(String strDate,String toFormat) {
        String retStringDate = null;
        try {
            SimpleDateFormat format1 = new SimpleDateFormat(DATE_FORMAT);
            SimpleDateFormat format2 = new SimpleDateFormat(toFormat);
            Date date = format1.parse(strDate);
            retStringDate = format2.format(date);
        } catch (ParseException pExp) {
            pExp.printStackTrace();
        }
        return retStringDate;
    }

}

package com.youngtse.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title: DateUtil
 * @Date 2023/5/12 0:20
 * @Author Youngtse
 */
public class DateUtil {
    public static final String YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static String getNowWithDefault() {
        Calendar calendar = Calendar.getInstance();
        return format(calendar.getTime(), YYYYMMDD_HHMMSS);
    }
}

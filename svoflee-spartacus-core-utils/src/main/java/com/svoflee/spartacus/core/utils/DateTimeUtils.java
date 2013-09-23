/*
 * Copyright (c) http://www.svoflee.com All rights reserved.
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************      
 */

package com.svoflee.spartacus.core.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateUtils;

import com.svoflee.spartacus.core.constants.GlobalConstants.TsUnit;
import com.svoflee.spartacus.core.constants.GlobalConstants.Version;
import com.svoflee.spartacus.core.log.Logger;
import com.svoflee.spartacus.core.utils.exception.EUtils;

/**
 * DateTimeUtils 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public final class DateTimeUtils {

    private static final Logger log = Logger.getLogger(DateTimeUtils.class);

    public final static String[] DATE_FORMATS = new String[] { DateTimeUtils.YYYY_MM_DD, DateTimeUtils.YYYYMMDD,
            DateTimeUtils.YYYY_MM_DD_HH_MM, DateTimeUtils.YYYYMMDDHHMMSS, DateTimeUtils.HOUR_AND_MIN,
            DateTimeUtils.YYYYMMDD, DateTimeUtils.HOUR_MIN, DateTimeUtils.HOUR_TWENTY_FOUR_MIN,
            DateTimeUtils.YYYY_MM_DD_HH_MM_SS, DateTimeUtils.YYYY_MM };

    public final static String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public final static String YYYY_MM = "yyyy-MM";

    public final static String MM_DD = "MM-dd";

    public final static String YYYYMMDD = "yyyyMMdd";

    public final static String YYYY = "yyyy";

    public final static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public final static String YYYYMMDDHHMMSS_SSS = "yyyyMMddHHmmss_SSS";

    public final static String HOUR_MIN = "HHmm";

    public final static String HOUR_AND_MIN = "HH:mm";

    public final static String HOUR_TWENTY_FOUR_MIN = "HH:mm";

    public static String getDateString(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        else {
            SimpleDateFormat des = new SimpleDateFormat(formatStr);
            String result = des.format(date);
            return result;
        }
    }

    /**
     * yyyy-MM
     * 
     * @param date
     * @return yyyy-MM
     */
    public static String getDateString_YYYY_MM(Date date) {
        return getDateString(date, YYYY_MM);

    }

    public static String getDateString_YYYY_MM_DD(Date date) {
        return getDateString(date, YYYY_MM_DD);
    }

    public static String getDateString_YYYY_MM_DD_HH_MM(Date date) {
        return getDateString(date, YYYY_MM_DD_HH_MM);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     * @return
     */
    public static String getDateString_YYYY_MM_DD_HH_MM_SS(Date date) {
        return getDateString(date, YYYY_MM_DD_HH_MM_SS);
    }

    public static String getDateString_HH_MM(Date date) {
        return getDateString(date, HOUR_AND_MIN);
    }

    public static String getDateString_MM_DD(Date date) {
        return getDateString(date, MM_DD);

    }

    /**
     * yyyyMMddHHmmss
     * 
     * @return
     */
    public static String getNowString_YYYYMMDDHHMMSS() {
        return getDateString(new Date(), YYYYMMDDHHMMSS);

    }

    public static String getNowString_YYYYMMDDHHMMSS_SSS() {
        return getDateString(new Date(), YYYYMMDDHHMMSS_SSS);

    }

    /**
     * YYYY_MM_DD_HH_MM
     * 
     * @return yyyy-MM-dd HH:mm
     */
    public static String getNowString_YYYY_MM_DD_HH_MM() {
        return getDateString(new Date(), YYYY_MM_DD_HH_MM);

    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * 
     * @return yyyy-MM-dd HH:mm:ss String
     */
    public static String getNowString_YYYY_MM_DD_HH_MM_SS() {
        return getDateString(new Date(), YYYY_MM_DD_HH_MM_SS);

    }

    /**
     * yyyy-MM-dd
     * 
     * @return yyyy-MM-dd
     */
    public static String getNowString_YYYY_MM_DD() {
        return getDateString(new Date(), YYYY_MM_DD);

    }

    /**
     * yyyy-MM
     * 
     * @return yyyy-MM
     */
    public static String getNowString_YYYY_MM() {
        return getDateString(new Date(), YYYY_MM);

    }

    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 如果能够正确Format，则返回format的值，否则，返回null
     * 
     * @param dateString
     * @param dateFormat
     * @return
     */
    public static Date formatDate(String dateString, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date dt = null;
        try {
            dt = format.parse(dateString);
        }
        catch (ParseException e) {
            // if (log.isErrorEnabled()) {
            // log.error("{}-{}", dateString + " to " + dateFormat, e.getMessage());
            // }
        }
        return dt;

    }

    // /**
    // * YYYY_MM_DD_HH_MM_SS
    // *
    // * @return
    // */
    // public static String getNowTimeWithSecond() {
    // return getDateString(new Date(), YYYY_MM_DD_HH_MM_SS);
    //
    // }

    public static Date formatDate_YYYY_MM_DD_HH_MM(String dateString) {
        return formatDate(dateString, YYYY_MM_DD_HH_MM);

        // SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM);
        // Date dt = null;
        // try {
        // dt = format.parse(dateString);
        // } catch (ParseException e) {
        // log.error("{}", e.getMessage());
        // }
        // return dt;

    }

    public static Date formatDate_YYYY_MM_DD_HH_MM_SS(String dateString) {
        return formatDate(dateString, YYYY_MM_DD_HH_MM_SS);
        //
        // SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        // Date dt = null;
        // try {
        // dt = format.parse(dateString);
        // } catch (ParseException e) {
        // log.error("{}", e.getMessage());
        // }
        // return dt;

    }

    /**
     * yyyy-MM-dd
     * 
     * @param dateString
     * @return
     */
    public static Date formatDate_YYYY_MM_DD(String dateString) {
        return formatDate(dateString, YYYY_MM_DD);

    }

    public static Timestamp formatTimestamp(String dateString, String dateFormat) {
        Date dt = formatDate(dateString, dateFormat);
        if (dt != null) {
            return new Timestamp(dt.getTime());

        }
        return null;
    }

    public static Timestamp formatTimestamp_YYYY_MM_DD_HH_MM(String dateString) {
        return formatTimestamp(dateString, YYYY_MM_DD_HH_MM);

    }

    public static Date getDayLastYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }

    public static String getMorrow() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            return new SimpleDateFormat(YYYY_MM_DD).format(calendar.getTime());
        }
        catch (Exception e) {
            return null;
        }
    }

    public static Date getTomorrowDate() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, 1);
            return calendar.getTime();
        }
        catch (Exception e) {
            return null;
        }
    }

    public static Date getYesterdayDate() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -1);
            return calendar.getTime();
        }
        catch (Exception e) {
            return null;
        }
    }

    // public static Date getLogicDate(Date lDate, int nDay) {
    // try {
    // Calendar calendar = Calendar.getInstance();
    // calendar.setTime(lDate);
    // calendar.add(Calendar.DATE, nDay);
    // return calendar.getTime();
    // } catch (Exception e) {
    // return null;
    // }
    // }

    public static String getBeforeYesterDay() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -2);
            return new SimpleDateFormat(YYYY_MM_DD).format(calendar.getTime());
        }
        catch (Exception e) {
            return null;
        }
    }

    public static int getDayOfWeek(int sunFirstWeek) {
        if ((sunFirstWeek > 7) || (sunFirstWeek < 1)) {
            return 0;
        }
        if (sunFirstWeek == 1) {
            return 7;
        }
        return sunFirstWeek - 1;
    }

    public static int getDayOfWeek() {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
        return day == 0 ? 7 : day;

    }

    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return day == 0 ? 7 : day;

    }

    public static long compareDate(Date date1, Date date2) throws ParseException {
        return date1.getTime() - date2.getTime();
    }

    // public static int compareByStandardDate(Date date1, Date date2) throws ParseException {
    // long lDate1 = formatDate_YYYY_MM_DD(getDateString_YYYY_MM_DD(date1)).getTime();
    // long lDate2 = formatDate_YYYY_MM_DD(getDateString_YYYY_MM_DD(date2)).getTime();
    // int nDay = (int) (lDate1 - lDate2) / (24 * 60 * 60 * 1000);
    // return nDay;
    // }

    public static int getTmMinDuration(Date nextTm, Date preTm) throws ParseException {
        return getTmMSDuration(nextTm, preTm) / 60 * 1000;
        //
        // long lDate1 = formatDate_YYYY_MM_DD_HH_MM_SS(getDateString_YYYY_MM_DD_HH_MM_SS(nextTm)).getTime();
        // long lDate2 = formatDate_YYYY_MM_DD_HH_MM_SS(getDateString_YYYY_MM_DD_HH_MM_SS(preTm)).getTime();
        // int nSecond = (int) (lDate1 - lDate2) / (60 * 1000);
        // return nSecond;
    }

    public static int getTmSecondDuration(Date nextTm, Date preTm) {
        return getTmMSDuration(nextTm, preTm) / 1000;
        // long lDate1 = formatDate_YYYY_MM_DD_HH_MM_SS(getDateString_YYYY_MM_DD_HH_MM_SS(nextTm)).getTime();
        // long lDate2 = formatDate_YYYY_MM_DD_HH_MM_SS(getDateString_YYYY_MM_DD_HH_MM_SS(preTm)).getTime();
        // int nSecond = (int) (lDate1 - lDate2) / (1000);
        // return nSecond;
    }

    public static int getTmMSDuration(Date nextTm, Date preTm) {
        long lDate1 = nextTm.getTime();
        long lDate2 = preTm.getTime();
        int nSecond = (int) (lDate1 - lDate2);
        return nSecond;
    }

    public static boolean isOverTime(Date curTime, Date comparedTime) throws ParseException {
        boolean result;
        if (comparedTime == null) {
            return true;
        }
        if (compareDate(curTime, comparedTime) > 0) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

    // public static int compareDate(Date[] data1, Date[] data2) {
    // StringBuffer time1 = new StringBuffer();
    // StringBuffer time2 = new StringBuffer();
    // for (Date element : data1) {
    // if (element != null) {
    // time1.append(getDateString(element, YYYYMMDDHHMMSS));
    // }
    // }
    // for (int i = 0; i < data2.length; i++) {
    // if (data1[i] != null) {
    // time1.append(getDateString(data2[i], YYYYMMDDHHMMSS));
    // }
    // }
    // return time1.toString().compareTo(time2.toString());
    // }

    // /**
    // * @param flightDate
    // * @param date
    // * @return
    // */
    // public static long compareDate(String flightDate, String date) {
    // // DATEFORMAT_DAY
    // return (formatDate_YYYY_MM_DD(flightDate).getTime() - formatDate_YYYY_MM_DD(date).getTime())
    // / (1000 * 60 * 60 * 24);
    // }

    public static Timestamp getCurOpTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    public static Date getPrevDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date increaseDays(Date baseDate, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date decreaseDays(Date baseDate, int days) {
        int deDays = 0 - days;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(baseDate);
        calendar.add(Calendar.DATE, deDays);
        return calendar.getTime();
    }

    //
    // public static String DateFormat(Date date, Date plegDate) {
    // if ((date == null) || (plegDate == null)) {
    // return "";
    // }
    // // ��ʱ��ת��ΪHHMM
    // String strDate = DateTimeUtils.getFlightTime(date);
    //
    // /*
    // * long a = SystemUtils.formatDate(SystemUtils.getDateString(date)).getTime(); long b =
    // * SystemUtils.formatDate(SystemUtils.getDateString(plegDate)).getTime ();
    // *
    // * Timestamp time1 = Timestamp.valueOf("2006-7-5 13:52:56"); Timestamp time2 =
    // * Timestamp.valueOf("2006-7-4 13:52:56"); long l1 =
    // * SystemUtils.formatDate(SystemUtils.getDateString(time1)).getTime(); long l2 =
    // * SystemUtils.formatDate(SystemUtils.getDateString(time2)).getTime();
    // *
    // * //long lResultDay = (a-b)/(l1-l2); long lResultDay = (a-b)/(24*60*60*1000);
    // */
    // int nResultDay = 0;
    // try {
    // nResultDay = DateTimeUtils.compareByStandardDate(date, plegDate);
    // } catch (ParseException e) {
    //
    // e.printStackTrace();
    // }
    // String temp = "";
    // if (nResultDay > 0) {
    // if (nResultDay < 2) {
    // temp = "+";
    // }
    // else {
    // temp = "+" + String.valueOf(nResultDay);
    // }
    // }
    // else if (nResultDay < 0) {
    // if (nResultDay > -2) {
    // temp = "-";
    // }
    // else {
    // temp = String.valueOf(nResultDay);
    // }
    // }
    // strDate = strDate + temp;
    //
    // return strDate;
    // }

    // public static String getYearString(Date date) {
    // String result = null;
    // if (date == null) {
    // result = null;
    // }
    // else {
    // SimpleDateFormat des = new SimpleDateFormat(YYYY);
    // result = des.format(date);
    // }
    // return result;
    // }

    /**
     * @param aLastExtractTime
     * @param mons
     * @return
     */
    public static Date addMonths(Date date, int mons) {
        return addMonths(date, mons);
    }

    /**
     * 按小时换算的1天时间
     */
    public static final int ONE_DAY_HOURS = 24;

    /**
     * 按小时换算的1月时间
     */
    public static final int ONE_MON_HOURS = 30 * ONE_DAY_HOURS;

    /**
     * 按小时换算的12月时间
     */
    public static final int ONE_YEAR_HOURS = 12 * ONE_MON_HOURS;

    /**
     * 按小时换算的3月时间
     */
    public static final int THREE_MON_HOURS = 3 * ONE_MON_HOURS;

    public static String convertLocalTimeToUTC(String localDatetimeString) {
        return convertLocalTimeToUTC("SH", localDatetimeString);
    }

    public static String convertLocalTimeToUTC(String cityName, String localDateTimeString) {
        String result = "";// Will hold the final converted date
        Date localDate = null;
        // String localTimezoneId = "";
        SimpleDateFormat lv_formatter;
        SimpleDateFormat lv_parser;

        String localTimezoneId = chooseTimezoneIdByCityName(cityName);

        // create a new Date object using the timezone of the specified city
        lv_parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        lv_parser.setTimeZone(TimeZone.getTimeZone(localTimezoneId));
        try {
            localDate = lv_parser.parse(localDateTimeString);
        }
        catch (ParseException e) {
            return null;
        }

        // Set output format prints "2007/10/25  18:35:07 EDT(-0400)"
        lv_formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z'('Z')'");
        lv_formatter.setTimeZone(TimeZone.getTimeZone(localTimezoneId));

        // System.out.println("convertLocalTimeToUTC: " + p_city + ": " + " The Date in the local time zone "
        // + lv_formatter.format(localDate));

        // Convert the date from the local timezone to UTC timezone
        lv_formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        result = lv_formatter.format(localDate);
        // System.out.println("convertLocalTimeToUTC: " + cityName + ": " + " The Date in the UTC time zone " + result);

        return result;
    }

    /**
     * @see convertUTCtoLocalTime(String cityName, String utcDateTimeString)
     * @param utcDateTime
     *            Utc格式的时间
     * @return
     */
    public static Date convertUTCtoLocalTime(Date utcDateTime) {
        String utcDateTimeString = DateTimeUtils.getDateString(utcDateTime, "yyyy-MM-dd HH:mm:ss z'('Z')'");
        return convertUTCtoLocalTime("SH", utcDateTimeString);
    }

    /**
     * @see convertUTCtoLocalTime(String cityName, String utcDateTimeString)
     * @param utcDateTimeString
     * @return
     */
    public static Date convertUTCtoLocalTime(String utcDateTimeString) {
        return convertUTCtoLocalTime("SH", utcDateTimeString);
    }

    /**
     * 将UTC的时间转换成本地时间，本地之间由 @param cityName 参数指定
     * 
     * @param cityName
     * @param utcDateTimeString
     * @return
     */
    public static Date convertUTCtoLocalTime(String cityName, String utcDateTimeString) {
        Date result = null;
        SimpleDateFormat lv_parser;

        lv_parser = new SimpleDateFormat(DateTimeUtils.YYYY_MM_DD_HH_MM_SS);
        lv_parser.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            result = lv_parser.parse(utcDateTimeString);
        }
        catch (ParseException e) {
        }

        return result;
    }

    /**
     * 通过城市名缩写，返回Timezone的ID
     * 
     * @param cityName
     * @return
     */
    public static String chooseTimezoneIdByCityName(String cityName) {
        String localTimezoneId = "";

        // Temp for testing(mapping of cities and timezones will eventually be in a properties file
        if (cityName.equals("LON")) {
            localTimezoneId = "Europe/London";
        }
        else if (cityName.equals("NBI")) {
            localTimezoneId = "EAT";
        }
        else if (cityName.equals("BRS")) {
            localTimezoneId = "Europe/Brussels";
        }
        else if (cityName.equals("MNT")) {
            localTimezoneId = "America/Montreal";
        }
        else if (cityName.equals("LAS")) {
            localTimezoneId = "PST";
        }
        else if (cityName.equals("SH")) {
            localTimezoneId = "Asia/Shanghai";
        }
        return localTimezoneId;
    }

    public static Date convertUTCtoLocalTime(String cityName, Date date) throws Exception {
        SimpleDateFormat lv_formatter;

        String localTimezoneId = chooseTimezoneIdByCityName(cityName);
        lv_formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z'('Z')'");

        lv_formatter.setTimeZone(TimeZone.getTimeZone(localTimezoneId));
        String lv_dateFormateInLocalTimeZone = lv_formatter.format(date);
        Date result = formatDate_YYYY_MM_DD_HH_MM_SS(lv_dateFormateInLocalTimeZone);

        return result;
    }

    /**
     * 通过+1天的方式，对Utc的时间进行本地化，应该是+8小时,
     * 但是mongdodb get出来的对象，不是16:00的形式 +8小时存在问 题
     * 
     * @param utcSourceDate
     * @return
     */
    public static Date getSimpleCnLocalDate(Date utcSourceDate) {
        // XXX： +8个小时，没有调整到下一天的00:00，这个要检查一下mongodbDriver的处理细节，
        // Date aLocalDate = DateTimeUtils.addHours(utcSourceDate, 8);
        Date aLocalDate = DateUtils.addDays(utcSourceDate, 1);
        return aLocalDate;
    }

    public static Date getRangeDate(Date midDate, int unitRange, TsUnit aTsUnit, int addOrSub) {
        Date result = null;
        if (aTsUnit == TsUnit.YEARLY) {
            result = DateUtils.addYears(midDate, unitRange * addOrSub);
        }
        else if (aTsUnit == TsUnit.DAILY) {
            result = DateUtils.addDays(midDate, unitRange * addOrSub);
        }
        else if (aTsUnit == TsUnit.MONTHLY) {
            result = DateUtils.addMonths(midDate, unitRange * addOrSub);
        }
        else {
            EUtils.throwNotSupportedException(Version.V1_0_0);
        }
        return result;
    }

    /**
     * * 判断一个字符串是否为支持的日期格式
     * 
     * @param dateString 需要判断的日期格式的字符串
     * @param formatedDate 如果字符串能够被格式化，则该参数赋值为被时间格式化的日期对象
     * @param dateFormats 需要判断的日期格式
     * @return
     */
    public static String stringSuitableDataFormat(String dateString, Date formatedDate, String... dateFormats) {
        for (String dateFormat : dateFormats) {
            formatedDate = formatDate(dateString, dateFormat);
            if (formatedDate != null) {
                return dateFormat;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // System.out.println(DateTimeUtils.canConvertToDate("003-01-01"));
        U.p(DateTimeUtils.convertUTCtoLocalTime("2009-12-31 16:00:00.0Z"));

        // long epoch = new java.text.SimpleDateFormat ("MM/dd/yyyy HH:mm:ss").parse("01/01/1970 01:00:00").getTime();

    }
}

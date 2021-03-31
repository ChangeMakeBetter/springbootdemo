/*
 * 2011-03-04 caili
 *   对*Format增加同步
 */
package com.yang.springbootdemo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class Converter {
  private static final char[] bcdLookup = {
    '0',
    '1',
    '2',
    '3',
    '4',
    '5',
    '6',
    '7',
    '8',
    '9',
    'a',
    'b',
    'c',
    'd',
    'e',
    'f' };

  private static SimpleDateFormat sdf_yyyyMMddHHmmSSsss_NoSeparator = new SimpleDateFormat("yyyyMMddHHmmssSSS");
  private static SimpleDateFormat sdf_yyMMddHHmmSSsss_NoSeparator = new SimpleDateFormat("yyMMddHHmmssSSS");
  private static SimpleDateFormat sdf_yyMMddHHmmSS_NoSeparator = new SimpleDateFormat("yyMMddHHmmss");
  private static SimpleDateFormat sdf_yMdHms_NoSeparator = new SimpleDateFormat("yyyyMMddHHmmss");
  private static SimpleDateFormat sdf_MdHms_NoSeparator = new SimpleDateFormat("MMddHHmmss");
  private static SimpleDateFormat sdf_yMd_NoSeparator = new SimpleDateFormat("yyyyMMdd");
  private static SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
  private static SimpleDateFormat sdf_yyyyMM = new SimpleDateFormat("yyyyMM");
  private static SimpleDateFormat sdf_yyMMdd = new SimpleDateFormat("yyMMdd");
  private static SimpleDateFormat sdf_yyMdHm = new SimpleDateFormat("yy-MM-dd HH:mm");
  private static SimpleDateFormat sdf_MdHm = new SimpleDateFormat("MM-dd HH:mm");
  private static SimpleDateFormat sdf_yyMd = new SimpleDateFormat("yy-MM-dd");
  private static SimpleDateFormat sdf_Md = new SimpleDateFormat("MM-dd");
  private static SimpleDateFormat sdf_yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static SimpleDateFormat sdf_yMdHmsS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  private static SimpleDateFormat sdf_Hm = new SimpleDateFormat("HH:mm");
  private static SimpleDateFormat sdf_Hm_NoSeparator = new SimpleDateFormat("HHmm");
  private static SimpleDateFormat sdf_Hms = new SimpleDateFormat("HH:mm:ss");
  private static SimpleDateFormat sdf_Hms_NoSeparator = new SimpleDateFormat("HHmmss");
  private static SimpleDateFormat sdf_yMdHmsE = new SimpleDateFormat("yyyy-MM-dd EEE HH:mm:ss");
  private static SimpleDateFormat sdf_E = new SimpleDateFormat("EEE");
  private static SimpleDateFormat sdf_yMd = new SimpleDateFormat("yyyy-MM-dd");
  private static SimpleDateFormat sdf_yMdHm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  private static SimpleDateFormat sdf_yMd_Point = new SimpleDateFormat("yyyy.MM.dd");
  private static SimpleDateFormat sdf_yMdHms_Point = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
  private static SimpleDateFormat sdf_yM = new SimpleDateFormat("yyyy-MM");
  private static SimpleDateFormat sdf_dMyyyy = new SimpleDateFormat("d/M/yyyy");
  private static SimpleDateFormat sdf_Mdyyyy = new SimpleDateFormat("MM/dd/yyyy");
  private static SimpleDateFormat sdf_yyyyMd = new SimpleDateFormat("yyyy/MM/dd");

  private static SimpleDateFormat sdf_yMdTHmsSZ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

  private static final DecimalFormat df_price = new DecimalFormat("0.00", MyDecimalFormatSymbols.getInstance());
  private static final DecimalFormat df_price4 = new DecimalFormat("0.00##", MyDecimalFormatSymbols.getInstance());
  public static final DecimalFormat df_money = new DecimalFormat("0.00", MyDecimalFormatSymbols.getInstance());
  public static final DecimalFormat df_quantity = new DecimalFormat("0.###", MyDecimalFormatSymbols.getInstance());
  public static final DecimalFormat df_quantity4 = new DecimalFormat("0.####", MyDecimalFormatSymbols.getInstance());
  public static final DecimalFormat df_quantity5 = new DecimalFormat("0.#####", MyDecimalFormatSymbols.getInstance());
  private static final DecimalFormat df_percent = new DecimalFormat("0.###", MyDecimalFormatSymbols.getInstance());
  private static final DecimalFormat df_count = new DecimalFormat("0", MyDecimalFormatSymbols.getInstance());

  public static final DecimalFormat df_money_group = new DecimalFormat("#,##0.00",
    MyDecimalFormatSymbols.getInstance());

  public static final DecimalFormat df_qty_group = new DecimalFormat("#,##0.##", MyDecimalFormatSymbols.getInstance());

  private static final DecimalFormat df_sign_quantity = new DecimalFormat("+0.###;-0.###",
    MyDecimalFormatSymbols.getInstance());
  private static final DecimalFormat df_sign_quantity4 = new DecimalFormat("+0.####;-0.####",
    MyDecimalFormatSymbols.getInstance());
  private static final DecimalFormat df_sign_quantity5 = new DecimalFormat("+0.#####;-0.#####",
    MyDecimalFormatSymbols.getInstance());

  public static String toQtySignString(BigDecimal n) {
    synchronized (df_sign_quantity) {
      return n == null ? null : df_sign_quantity.format(n);
    }
  }

  public static String toQty4SignString(BigDecimal n) {
    synchronized (df_sign_quantity4) {
      return n == null ? null : df_sign_quantity4.format(n);
    }
  }

  public static String toQty5SignString(BigDecimal n) {
    synchronized (df_sign_quantity5) {
      return n == null ? null : df_sign_quantity5.format(n);
    }
  }

  public static boolean equals(String a, String b) {
    if (a == null) {
      return b == null;
    }

    return a.equals(b);
  }

  public static boolean equals(Date a, Date b) {
    if (a == null) {
      return b == null;
    } else if (b == null) {
      return false;
    } else {
      return a.getTime() == b.getTime();
    }
  }

  public static boolean equals(BigDecimal a, BigDecimal b) {
    if (a == null) {
      return b == null;
    }

    if (b == null) {
      return a == null;
    }

    return a.compareTo(b) == 0;
  }

  public static boolean equalsByScale(BigDecimal a, BigDecimal b, int scale, RoundingMode roundingMode) {
    if (a == null) {
      return b == null;
    }

    a = a.setScale(scale, roundingMode);
    b = b == null ? null : b.setScale(scale, roundingMode);

    if (b == null) {
      return a == null;
    }

    return a.compareTo(b) == 0;
  }

  public static boolean equals(Integer a, Integer b) {
    if (a == null) {
      return b == null;
    }
    return a.equals(b);
  }

  public static boolean equals(int a, int b) {
    return a == b;
  }

  public static boolean equals(long a, long b) {
    return a == b;
  }

  public static boolean equals(boolean a, boolean b) {
    return a == b;
  }

  /**
   * yyyy-MM-dd HH:mm:ss
   */
  public static String toString(Date date) {
    synchronized (sdf_yMdHms) {
      return date == null ? null : sdf_yMdHms.format(date);
    }
  }

  public static String toString(Date date, String dateformat) {
    return toString(date, new SimpleDateFormat(dateformat));
  }

  public static String toString(Date date, SimpleDateFormat sdf) {
    if (date == null) {
      return null;
    }
    return sdf.format(date);
  }

  /**
   * HH:mm
   */
  public static Date parse_Hm(String date) {
    synchronized (sdf_Hm) {
      try {
        return sdf_Hm.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * HHmm
   */
  public static Date parse_Hm_NoSeparator(String s) {
    synchronized (sdf_Hm_NoSeparator) {
      try {
        return s == null ? null : sdf_Hm_NoSeparator.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static Date parse_yM(String date) {
    synchronized (sdf_yM) {
      try {
        return sdf_yM.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static Date parse_dMyyyy(String date) {
    synchronized (sdf_dMyyyy) {
      try {
        return sdf_dMyyyy.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static Date parse_Mdyyyy(String date) {
    synchronized (sdf_Mdyyyy) {
      try {
        return sdf_Mdyyyy.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static Date parse_sdf_yyyyMd(String date) {
    synchronized (sdf_yyyyMd) {
      try {
        return sdf_yyyyMd.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static String toString_yyyyMd(Date date) {
    synchronized (sdf_yyyyMd) {
      return date == null ? null : sdf_yyyyMd.format(date);
    }
  }

  /**
   * yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
   */
  public static Date parse_yMdTHmsSZ(String date) {
    synchronized (sdf_yMdTHmsSZ) {
      try {
        return sdf_yMdTHmsSZ.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * HH:mm:ss
   */
  public static String toString_Hms(Date date) {
    synchronized (sdf_Hms) {
      return date == null ? null : sdf_Hms.format(date);
    }
  }

  public static Date parse_Hms(String s) {
    synchronized (sdf_Hms) {
      try {
        return s == null ? null : sdf_Hms.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * HH:mm:ss
   */
  public static String toString_Hms_NoSeparator(Date date) {
    synchronized (sdf_Hms_NoSeparator) {
      return date == null ? null : sdf_Hms_NoSeparator.format(date);
    }
  }

  public static Date parse_Hms_NoSeparator(String s) {
    synchronized (sdf_Hms_NoSeparator) {
      try {
        return s == null ? null : sdf_Hms_NoSeparator.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyyMMdd
   */
  public static String toString_yyyyMMdd(Date date) {
    synchronized (sdf_yyyyMMdd) {
      return date == null ? null : sdf_yyyyMMdd.format(date);
    }
  }

  /**
   * yyyyMMdd
   */
  public static Date parse_yyyyMMdd(String s) {
    synchronized (sdf_yyyyMMdd) {
      try {
        return s == null ? null : sdf_yyyyMMdd.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyyMM
   */
  public static String toString_yyyyMM(Date date) {
    synchronized (sdf_yyyyMM) {
      return date == null ? null : sdf_yyyyMM.format(date);
    }
  }

  /**
   * yyMMddHHmmss
   */
  public static String toString_yyMMddHHmmSS_NoSeparator(Date date) {
    synchronized (sdf_yyMMddHHmmSS_NoSeparator) {
      return date == null ? null : sdf_yyMMddHHmmSS_NoSeparator.format(date);
    }
  }

  /**
   * yyyyMMddHHmmss
   */
  public static Date parse_yMdHms_NoSeparator(String s) {
    synchronized (sdf_yMdHms_NoSeparator) {
      try {
        return s == null ? null : sdf_yMdHms_NoSeparator.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyyMMddHHmmss
   */
  public static String toString_yMdHms_NoSeparator(Date date) {
    synchronized (sdf_yMdHms_NoSeparator) {
      return date == null ? null : sdf_yMdHms_NoSeparator.format(date);
    }
  }

  /**
   * yyyyMMddHHmmss
   */
  public static Date parse_MdHms_NoSeparator(String s) {
    synchronized (sdf_MdHms_NoSeparator) {
      try {
        return s == null ? null : sdf_MdHms_NoSeparator.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyyMMddHHmmss
   */
  public static String toString_MdHms_NoSeparator(Date date) {
    synchronized (sdf_MdHms_NoSeparator) {
      return date == null ? null : sdf_MdHms_NoSeparator.format(date);
    }
  }

  /**
   * yyyyMMddHHmmssSSS
   */
  public static String toString_yyyyMMddHHmmSSsss_NoSeparator(Date date) {
    synchronized (sdf_yyyyMMddHHmmSSsss_NoSeparator) {
      return date == null ? null : sdf_yyyyMMddHHmmSSsss_NoSeparator.format(date);
    }
  }

  /**
   * yyyyMMddHHmmss
   */
  public static String toString_yyMMddHHmmSSsss_NoSeparator(Date date) {
    synchronized (sdf_yyMMddHHmmSSsss_NoSeparator) {
      return date == null ? null : sdf_yyMMddHHmmSSsss_NoSeparator.format(date);
    }
  }

  /**
   * yyMMdd
   */
  public static String toString_yyMMdd(Date date) {
    synchronized (sdf_yyMMdd) {
      return date == null ? null : sdf_yyMMdd.format(date);
    }
  }

  public static Date parse_yyMMdd(String s) {
    synchronized (sdf_yyMMdd) {
      try {
        return s == null ? null : sdf_yyMMdd.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyy-MM-dd HH:mm:ss.SSS
   */
  public static String toString_yMdHmsS(Date date) {
    synchronized (sdf_yMdHmsS) {
      return date == null ? null : sdf_yMdHmsS.format(date);
    }
  }

  public static Date parse_yMdHmsS(String date) {
    synchronized (sdf_yMdHmsS) {
      try {
        return sdf_yMdHmsS.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyy-MM-dd HH:mm
   */
  public static String toString_yMdHm(Date date) {
    synchronized (sdf_yMdHm) {
      return date == null ? null : sdf_yMdHm.format(date);
    }
  }

  /**
   * yyyy-MM-dd HH:mm
   */
  public static Date parse_yMdHm(String date) {
    synchronized (sdf_yMdHm) {
      try {
        return sdf_yMdHm.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yy-MM-dd HH:mm
   */
  public static String toString_yyMdHm(Date date) {
    synchronized (sdf_yyMdHm) {
      return date == null ? null : sdf_yyMdHm.format(date);
    }
  }

  /**
   * yy-MM-dd HH:mm
   */
  public static Date parse_yyMdHm(String date) {
    synchronized (sdf_yyMdHm) {
      try {
        return sdf_yyMdHm.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * MM-dd HH:mm
   */
  public static String toString_MdHm(Date date) {
    synchronized (sdf_MdHm) {
      return date == null ? null : sdf_MdHm.format(date);
    }
  }

  /**
   * MM-dd HH:mm
   */
  public static Date parse_MdHm(String date) {
    synchronized (sdf_MdHm) {
      try {
        return sdf_MdHm.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yy-MM-dd
   */
  public static String toString_yyMd(Date date) {
    synchronized (sdf_yyMd) {
      return date == null ? null : sdf_yyMd.format(date);
    }
  }

  /**
   * yy-MM-dd
   */
  public static Date parse_yyMd(String date) {
    synchronized (sdf_yyMd) {
      try {
        return sdf_yyMd.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyy-MM-dd
   */
  public static String toString_yMd(Date date) {
    synchronized (sdf_yMd) {
      return date == null ? null : sdf_yMd.format(date);
    }
  }

  /**
   * MM-dd
   */
  public static Date parse_Md(String date) {
    synchronized (sdf_Md) {
      try {
        return sdf_Md.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * MM-dd
   */
  public static String toString_Md(Date date) {
    synchronized (sdf_Md) {
      return date == null ? null : sdf_Md.format(date);
    }
  }

  /**
   * yyyy.MM.dd
   */
  public static String toString_yMd_Point(Date date) {
    synchronized (sdf_yMd_Point) {
      return date == null ? null : sdf_yMd_Point.format(date);
    }
  }

  /**
   * yyyy.MM.dd HH:mm:ss
   */
  public static String toString_yMdHms_Point(Date date) {
    synchronized (sdf_yMdHms_Point) {
      return date == null ? null : sdf_yMdHms_Point.format(date);
    }
  }

  public static String toString_sdf_yM(Date date) {
    synchronized (sdf_yM) {
      return date == null ? null : sdf_yM.format(date);
    }
  }

  public static String toString_sdf_dMyyyy(Date date) {
    synchronized (sdf_dMyyyy) {
      return date == null ? null : sdf_dMyyyy.format(date);
    }
  }

  public static String toString_sdf_Mdyyyy(Date date) {
    synchronized (sdf_Mdyyyy) {
      return date == null ? null : sdf_Mdyyyy.format(date);
    }
  }

  /**
   * yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
   */
  public static String toString_yMdTHmsSZ(Date date) {
    synchronized (sdf_yMdTHmsSZ) {
      return date == null ? null : sdf_yMdTHmsSZ.format(date);
    }
  }

  /**
   * yyyyMMdd
   */
  public static String toString_yMd_NoSeparator(Date date) {
    synchronized (sdf_yMd_NoSeparator) {
      return date == null ? null : sdf_yMd_NoSeparator.format(date);
    }
  }

  /**
   * yyyy-MM-dd
   */
  public static Date parse_yMd(String date) {
    synchronized (sdf_yMd) {
      try {
        return sdf_yMd.parse(date);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * HH:mm
   */
  public static String toString_Hm(Date date) {
    synchronized (sdf_Hm) {
      return date == null ? null : sdf_Hm.format(date);
    }
  }

  /**
   * yyyy-MM-dd EEE HH:mm:ss
   */
  public static String toString_yMdHmsE(Date date) {
    synchronized (sdf_yMdHmsE) {
      return date == null ? null : sdf_yMdHmsE.format(date);
    }
  }

  public static String toString_EEE(Date date) {
    synchronized (sdf_E) {
      return date == null ? null : sdf_E.format(date);
    }
  }

  public static String toString(String s) {
    return s;
  }

  public static String toString(Integer n) {
    return n == null ? null : n.toString();
  }

  public static String toString(Long n) {
    return n == null ? null : n.toString();
  }

  public static String toString(long n) {
    return Long.toString(n);
  }

  public static String toStringInt(BigDecimal n) {
    return n == null ? null : Integer.valueOf(n.intValue()).toString();
  }

  public static String toStringLong(BigDecimal n) {
    return n == null ? null : Long.valueOf(n.longValue()).toString();
  }

  public static String toPriceString(BigDecimal n) {
    synchronized (df_price) {
      return n == null ? null : df_price.format(n);
    }
  }

  /**
   * 4位精度的价格：0.00##
   */
  public static String toPrice4String(BigDecimal n) {
    synchronized (df_price4) {
      return n == null ? null : df_price4.format(n);
    }
  }

  public static String toMoneyString(BigDecimal n) {
    synchronized (df_money) {
      return n == null ? null : df_money.format(n);
    }
  }

  public static String toGroupMoneyString(BigDecimal n) {
    synchronized (df_money_group) {
      return n == null ? null : df_money_group.format(n);
    }
  }

  public static String toGroupQtyString(BigDecimal n) {
    synchronized (df_qty_group) {
      return n == null ? null : df_qty_group.format(n);
    }
  }

  public static String toQtyString(BigDecimal n) {
    synchronized (df_quantity) {
      return n == null ? null : df_quantity.format(n);
    }
  }

  public static String toQty4String(BigDecimal n) {
    synchronized (df_quantity4) {
      return n == null ? null : df_quantity4.format(n);
    }
  }

  public static String toQty5String(BigDecimal n) {
    synchronized (df_quantity5) {
      return n == null ? null : df_quantity5.format(n);
    }
  }

  public static String toPercentString(BigDecimal n) {
    synchronized (df_percent) {
      return n == null ? null : df_percent.format(n);
    }
  }

  public static String toCountString(BigDecimal n) {
    synchronized (df_count) {
      return n == null ? null : df_count.format(n);
    }
  }

  public static String toString(Boolean b) {
    return b == null ? null : b.toString();
  }

  public static String toString(boolean b) {
    return Boolean.toString(b);
  }

  public static String toString(int n) {
    return Integer.toString(n);
  }

  public static Date toDateSSS(Date date) {
    String str = null;
    synchronized (sdf_yyMMddHHmmSS_NoSeparator) {
      try {
        str = Converter.toString(date, sdf_yyMMddHHmmSS_NoSeparator);
      } catch (Exception e) {

      }
    }

    synchronized (sdf_yyMMddHHmmSSsss_NoSeparator) {
      try {
        return str == null ? null : sdf_yyMMddHHmmSSsss_NoSeparator.parse(str + "999");
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static Date toDate(java.sql.Timestamp t) {
    return toDate(t, null);
  }

  public static Date toDate(java.sql.Timestamp t, Date defaultValue) {
    if (t == null) {
      return defaultValue;
    }
    return new Date(t.getTime());
  }

  public static java.sql.Timestamp toTimestamp(Date d) {
    if (d == null) {
      return null;
    }
    return new java.sql.Timestamp(d.getTime());
  }

  /**
   * yyyy-MM-dd HH:mm:ss
   */
  public static Date toDate(String s) {
    synchronized (sdf_yMdHms) {
      try {
        return s == null ? null : sdf_yMdHms.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static Date date(String s, Date defaultValue, String dateformat) throws Exception {
    if (s == null) {
      return defaultValue;
    }
    s = s.trim();
    if (s.length() == 0) {
      return defaultValue;
    }
    try {
      return new SimpleDateFormat(dateformat).parse(s);
    } catch (Exception e) {
      throw new Exception(s + "不是合法的日期");
    }
  }

  public static Date date(String s, Date defaultValue, String... dateformats) throws Exception {
    for (String dateformat : dateformats) {
      try {
        return date(s, defaultValue, dateformat);
      } catch (Exception e) {
      }
    }
    throw new Exception(s + "不是合法的日期");
  }

  /**
   * yyyy-MM-dd
   */
  public static Date toDate_sdf_yMd(String s) {
    synchronized (sdf_yMd) {
      try {
        return s == null ? null : sdf_yMd.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyy.MM.dd HH:mm:ss
   */
  public static Date toDate_sdf_yMdHms_Point(String s) {
    synchronized (sdf_yMdHms_Point) {
      try {
        return s == null ? null : sdf_yMdHms_Point.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  /**
   * yyyy.MM.dd
   */
  public static Date toDate_sdf_yMd_Point(String s) {
    synchronized (sdf_yMd_Point) {
      try {
        return s == null ? null : sdf_yMd_Point.parse(s);
      } catch (Exception e) {
        return null;
      }
    }
  }

  public static Integer toInteger(String s) {
    try {
      return s == null ? null : new Integer(s);
    } catch (Exception e) {
      return null;
    }
  }

  public static Integer integer(String s, Integer blankValue) throws Exception {
    if (s == null) {
      return blankValue;
    }
    s = s.trim();
    if (s.length() == 0) {
      return blankValue;
    }
    try {
      return new Integer(s);
    } catch (Exception e) {
      throw new Exception(s + "不是一个合法的整数");
    }
  }

  public static BigDecimal toBigDecimal(String s) {
    try {
      return s == null ? null : new BigDecimal(s);
    } catch (Exception e) {
      return null;
    }
  }

  public static BigDecimal toBigDecimal(String s, BigDecimal defaultValue) {
    try {
      return s == null ? defaultValue : new BigDecimal(s);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static BigDecimal bigDecimal(String s, int scale, BigDecimal blankValue) throws Exception {
    blankValue = blankValue == null ? null : blankValue.setScale(scale, RoundingMode.HALF_UP);
    if (s == null) {
      return blankValue;
    }
    s = s.trim();
    if (s.length() == 0) {
      return blankValue;
    }
    try {
      return new BigDecimal(s).setScale(scale, RoundingMode.HALF_UP);
    } catch (Exception e) {
      throw new Exception(s + "不是合法的数值");
    }
  }

  public static BigDecimal toGroupMoneyBigDeciaml(String s) throws Exception {
    try {
      if (s == null) {
        return null;
      }
      s = s.replaceAll(",", "");
      return new BigDecimal(s);
    } catch (Exception e) {
      throw new Exception(s + "不是合法的数值");
    }
  }

  public static Boolean toBoolean(String s) {
    try {
      return s == null ? null : new Boolean(s);
    } catch (Exception e) {
      return null;
    }
  }

  public static int toInt(String s) {
    try {
      return s == null ? 0 : Integer.parseInt(s);
    } catch (Exception e) {
      return 0;
    }
  }

  public static int toInt(String s, int defaultValue) {
    try {
      return Integer.parseInt(s);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static long toLong(String s, long defaultValue) {
    try {
      return Long.parseLong(s);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static boolean toBool(String s) {
    try {
      return s == null ? false : Boolean.parseBoolean(s);
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean unBoxBoolean(Boolean b) {
    return b != null && b.booleanValue();
  }

  public static int unBoxInteger(Integer b, int defaultValue) {
    return b == null ? defaultValue : b.intValue();
  }

  public static BigDecimal negate(BigDecimal d) {
    return d == null ? null : d.negate();
  }

  public static String native2ascii(String str) {
    String tmp;
    StringBuffer sb = new StringBuffer(1000);
    char c;
    int i, j;
    sb.setLength(0);
    for (i = 0; i < str.length(); i++) {
      c = str.charAt(i);
      if (c > 255) {
        sb.append("\\u");
        j = (c >>> 8);
        tmp = Integer.toHexString(j);
        if (tmp.length() == 1) {
          sb.append("0");
        }
        sb.append(tmp);
        j = (c & 0xFF);
        tmp = Integer.toHexString(j);
        if (tmp.length() == 1) {
          sb.append("0");
        }
        sb.append(tmp);
      } else {
        sb.append(c);
      }
    }
    return (new String(sb));
  }

  public static int bytesToInt(byte[] b) {
    if (b.length == 4) {
      return b[0] << 24 | (b[1] & 0xff) << 16 | (b[2] & 0xff) << 8 | (b[3] & 0xff);
    } else if (b.length == 2) {
      return 0x00 << 24 | 0x00 << 16 | (b[0] & 0xff) << 8 | (b[1] & 0xff);
    }

    return 0;
  }

  public static final String byteToHexStr(byte bcd) {
    StringBuffer s = new StringBuffer(2);
    s.append(bcdLookup[(bcd >>> 4) & 0x0f]);
    s.append(bcdLookup[bcd & 0x0f]);
    return s.toString();
  }

  public static final String bytesToHexStr(byte[] bcd) {
    StringBuffer s = new StringBuffer(bcd.length * 2);
    for (int i = 0; i < bcd.length; i++) {
      s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
      s.append(bcdLookup[bcd[i] & 0x0f]);
    }
    return s.toString();
  }

  public static final byte[] hexStrToBytes(String s) {
    byte[] bytes;
    bytes = new byte[s.length() / 2];
    for (int i = 0; i < bytes.length; i++) {
      bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
    }
    return bytes;
  }

  /**
   * 若字符串超过最大长度maxLength，则截取；然后拼接\0;；传入null，空，空白将会被直接转为空串，最终得到 '\0'
   *
   * @param string
   * @param maxLength 字符串最大长度
   * @return
   */
  public static byte[] toBytes(String string, int maxLength) {
    try {
      return toBytes(string, maxLength, true);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static byte[] toBytes(String string) {
    try {
      return toBytes(string, string.length(), true);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static byte[] toBytes(String string, int maxLength, boolean appendZero) throws UnsupportedEncodingException {
    string = StringUtils.trimToEmpty(string);
    try {
      return (string.substring(0, Math.min(maxLength, string.length())) + (appendZero ? "\0" : "")).getBytes("utf-8");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String toString(File file) throws IOException {
    return toString(new FileReader(file));
  }

  public static String toString(File file, String encoding) throws IOException {
    return toString(new InputStreamReader(new FileInputStream(file), encoding));
  }

  public static String toString(Reader reader) throws IOException {
    try {
      StringBuffer sb = new StringBuffer();
      char[] cbuf = new char[2048];
      for (int cread = reader.read(cbuf); cread != -1; cread = reader.read(cbuf)) {
        sb.append(cbuf, 0, cread);
      }
      return sb.toString();
    } finally {
      try {
        reader.close();
      } catch (Exception e) {
      }
    }
  }

  public static String indent(String s, int n) {
    StringBuffer sb = new StringBuffer(n);
    for (int i = 0; i < n; ++i) {
      sb.append(" ");
    }
    return sb.toString() + s.replace("\n", "\n" + sb.toString());
  }

  public static String toString(Set<String> set) {
    StringBuffer sb = new StringBuffer();
    String deli = "";
    sb.append("(");
    for (String s : set) {
      sb.append(deli);
      sb.append(s);
      deli = ",";
    }
    sb.append(")");
    return sb.toString();
  }

  /**
   * 截断s, 返回的字符串的GBK内码字节数为length, 并保证最后是一个完整的字符.
   *
   * @param s
   * @param length
   * @return
   * @throws UnsupportedEncodingException
   */
  public static String truncateGBK(String s, int length) {
    if (s == null) {
      return s;
    }
    Charset charsetName = Charset.forName("GBK");
    byte[] b = s.getBytes(charsetName);
    if (b.length <= length) {
      return s;
    }

    int newLen = 0;
    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; ++i) {
      byte[] cb = String.valueOf(c[i]).getBytes(charsetName);
      newLen += cb.length;
      if (newLen > length) {
        newLen -= cb.length;
        break;
      }
    }

    return new String(b, 0, newLen, charsetName);
  }

  public static String firstCharToUpperCase(String s) {
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }

  public static String firstCharToLowerCase(String s) {
    return s.substring(0, 1).toLowerCase() + s.substring(1);
  }

  public static Object getBeanProperty(Object bean, String propertyName) throws Exception {
    Method method = null;
    try {
      method = bean.getClass().getMethod("get" + Converter.firstCharToUpperCase(propertyName));
    } catch (NoSuchMethodException e) {
      method = bean.getClass().getMethod("is" + Converter.firstCharToUpperCase(propertyName));
    }
    return method.invoke(bean);
  }

  public static void setBeanProperty(Object bean, String propertyName, Object value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), value.getClass());
    m.invoke(bean, value);
  }

  public static void setBeanPropertyInt(Object bean, String propertyName, int value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), int.class);
    m.invoke(bean, Integer.valueOf(value));
  }

  public static void setBeanPropertyLong(Object bean, String propertyName, long value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), long.class);
    m.invoke(bean, Long.valueOf(value));
  }

  public static void setBeanPropertyFloat(Object bean, String propertyName, float value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), float.class);
    m.invoke(bean, Float.valueOf(value));
  }

  public static void setBeanPropertyDouble(Object bean, String propertyName, double value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), double.class);
    m.invoke(bean, Double.valueOf(value));
  }

  public static void setBeanPropertyBoolean(Object bean, String propertyName, boolean value) throws Exception {
    Method m = bean.getClass().getMethod("set" + Converter.firstCharToUpperCase(propertyName), boolean.class);
    m.invoke(bean, Boolean.valueOf(value));
  }

  /**
   * 返回bean中定义的属性, 不包括父类的属性
   */
  public static Field[] getBeanProperties(Object bean, Class<?> cls) {
    Field[] fields = cls.getDeclaredFields();
    List<Field> properties = new ArrayList<Field>(fields.length);
    for (Field field : fields) {
      try {
        Method m = cls.getMethod("get" + Converter.firstCharToUpperCase(field.getName()));
        if (Modifier.isPublic(m.getModifiers())) {
          properties.add(field);
        }
      } catch (NoSuchMethodException e) {
        try {
          Method m = cls.getMethod("is" + Converter.firstCharToUpperCase(field.getName()));
          if (Modifier.isPublic(m.getModifiers())) {
            properties.add(field);
          }
        } catch (NoSuchMethodException e1) {
        }
      }
    }
    return properties.toArray(new Field[] {});
  }

  public static Field[] getBeanClassProperties(Class<?> cls) {
    Field[] fields = cls.getDeclaredFields();
    List<Field> properties = new ArrayList<Field>(fields.length);
    for (Field field : fields) {
      Method method = null;
      try {
        method = cls.getMethod("get" + Converter.firstCharToUpperCase(field.getName()));
      } catch (NoSuchMethodException e) {
        try {
          method = cls.getMethod("is" + Converter.firstCharToUpperCase(field.getName()));
        } catch (NoSuchMethodException e1) {
        }
      }
      if (method != null && Modifier.isPublic(method.getModifiers())) {
        properties.add(field);
      }
    }
    return properties.toArray(new Field[] {});
  }

  /**
   * 取得beanClass中名称为propertyName的字段，beanClass中不存在则到父类中查找。
   *
   * @param stopClass 当为null时会一直查找到最顶层
   */
  public static Field getBeanClassProperty(Class<?> beanClass, Class<?> stopSuperClass, String propertyName) {
    Field[] fields = getBeanClassProperties(beanClass);
    for (Field f : fields) {
      if (f.getName().equals(propertyName)) {
        return f;
      }
    }
    Class<?> beanSuperClass = beanClass.getSuperclass();
    if (beanSuperClass != stopSuperClass) {
      if (beanSuperClass == null) {
        throw new IllegalArgumentException("Stop class is not super class of bean class");
      }
      return getBeanClassProperty(beanSuperClass, stopSuperClass, propertyName);
    }
    return null;
  }

  /**
   * 取得和baseName在同一目录中的资源.
   *
   * @param name
   * @return
   * @throws IOException
   */
  public static URL[] getResources(String baseName) throws IOException {
    String jarFileProtocol = "jar:file:/", diskFileProtocol = "file:/";
    ArrayList<URL> resources = new ArrayList<URL>();
    String url = Converter.class.getResource(baseName).toString();

    if (url.startsWith(jarFileProtocol)) {
      String jar = url.substring(jarFileProtocol.length());
      int i = jar.indexOf("!");
      String jarName = jar.substring(0, i);
      int j = jar.lastIndexOf('/');
      String path = jar.substring(i + 2, j);

      ZipFile zip = new ZipFile(jarName);
      @SuppressWarnings("unchecked")
      Enumeration<ZipEntry> es = (Enumeration<ZipEntry>) zip.entries();
      while (es.hasMoreElements()) {
        ZipEntry e = es.nextElement();
        String name = e.getName();
        i = name.lastIndexOf('/');
        if (i < 0) {
          continue;
        }
        String epath = name.substring(0, i);
        if (path.equals(epath)) {
          resources.add(new URL(jarFileProtocol + jarName + "!/" + name));
        }
      }

    } else if (url.startsWith(diskFileProtocol)) {
      File dir = new File(url.substring(diskFileProtocol.length())).getParentFile();
      for (File file : dir.listFiles()) {
        resources.add(new URL(diskFileProtocol + file.getAbsolutePath().replace('\\', '/')));
      }
    }
    return resources.toArray(new URL[] {});
  }

  /**
   * 设置obj的clazz类中fieldName的值
   *
   * @param obj
   * @param clazz
   */
  public static void inject(Object obj, Class<?> clazz, String fieldName, Object value) throws Exception {
    Field f = null;
    f = clazz.getDeclaredField(fieldName);
    f.setAccessible(true);
    f.set(obj, value);
  }

  public static List<String> breakText(String text, String deli) {
    List<String> list = new ArrayList<String>();
    StringTokenizer st = new StringTokenizer(text, deli);
    while (st.hasMoreTokens()) {
      String s = st.nextToken();
      list.add(s);
    }
    return list;
  }

  public static BigDecimal fenToYuan(long fen) {
    return new BigDecimal(fen).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
  }

  public static long yuanToFen(BigDecimal yuan) {
    return yuan.multiply(new BigDecimal(100)).longValue();
  }

  public static int find0(byte[] b) {
    int i = 0;
    while (i < b.length && b[i] != 0) {
      ++i;
    }
    return i;
  }

  /**
   * 如果传入的字符串为null，则返回""；否则返回字符串本身
   */
  public static String nullEscape(String str) {
    return str == null ? "" : str;
  }

  public static String toString(char[] chars) {
    if (chars == null || chars.length == 0) {
      return null;
    }

    int indexOf0 = find0(chars);
    if (indexOf0 <= 0 || indexOf0 > chars.length - 1) {
      return new String(chars);
    } else {
      char[] cc = new char[indexOf0];
      for (int i = 0; i < indexOf0; i++) {
        cc[i] = chars[i];
      }
      return new String(cc);
    }

  }

  /**
   * find 第一个'\0'的位置。
   *
   * @param chars
   * @return
   */
  public static int find0(char[] chars) {
    char c = '\0';
    int i = 0;
    while (i < chars.length && chars[i] != c) {
      ++i;
    }
    return i;

  }

  /**
   * find 第一个'\0'的位置。
   *
   * @param bytes
   * @return
   */
  public static String toString(byte[] bytes) {
    final String s = new String(bytes);
    return s.substring(0, find0(bytes));
  }

  /**
   * 不修改d的日期部分，<br> 将d的时间部分改为23:59:59 999
   *
   * @param d
   * @return
   */
  public static Date toDate_end(Date d) {
    if (d == null) {
      return null;
    } else {
      Calendar c = Calendar.getInstance();
      c.setTime(d);
      c.set(Calendar.HOUR_OF_DAY, 23);
      c.set(Calendar.MINUTE, 59);
      c.set(Calendar.SECOND, 59);
      c.set(Calendar.MILLISECOND, 999);
      return c.getTime();
    }
  }

  /**
   * 不修改d的日期部分，<br> 将d的时间部分改为00:00:00 000
   *
   * @param d
   * @return
   */
  public static Date toDate_begin(Date d) {
    if (d == null) {
      return null;
    } else {
      Calendar c = Calendar.getInstance();
      c.setTime(d);
      c.set(Calendar.HOUR_OF_DAY, 0);
      c.set(Calendar.MINUTE, 0);
      c.set(Calendar.SECOND, 0);
      c.set(Calendar.MILLISECOND, 0);
      return c.getTime();
    }
  }

  private static final String[] Words = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
  private static final String[] Units = { "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万" };

  /**
   * 转大写中文金额
   *
   * @param moneyStr
   * @return
   */
  public static String toChinese(BigDecimal amount) {
    return toChinese(Converter.toMoneyString(amount));
  }

  private static String toChinese(String moneyStr) {
    if (moneyStr == null) {
      return "";
    }
    BigDecimal amt = new BigDecimal(moneyStr);
    BigDecimal Money = amt.abs();
    StringBuffer sb = new StringBuffer();
    if (amt.compareTo(BigDecimal.ZERO) < 0) {
      sb.append("负");
    }
    BigDecimal iMoney, fMoney, Jiao, Fen, Zero = new BigDecimal(0), Ten = new BigDecimal(10);
    int i;
    int[] Digits = new int[13];

    Money = Money.setScale(2, BigDecimal.ROUND_HALF_UP);
    iMoney = Money.setScale(0, BigDecimal.ROUND_DOWN);
    fMoney = Money.subtract(iMoney).multiply(new BigDecimal(100));
    Jiao = fMoney.divide(Ten, 0, BigDecimal.ROUND_DOWN);
    Fen = fMoney.subtract(Jiao.multiply(Ten));
    if (iMoney.compareTo(new BigDecimal(10000000000000.00)) >= 0) {
      return "超出表示范围";
    }
    i = 0;
    while (iMoney.compareTo(Zero) != 0) {
      Digits[i] = iMoney.subtract(iMoney.divide(Ten, 0, BigDecimal.ROUND_DOWN).multiply(Ten)).intValue();
      iMoney = iMoney.divide(Ten, 0, BigDecimal.ROUND_DOWN);
      ++i;
    }
    --i;
    int nz = 0;
    while (i >= 0) {
      if (Digits[i] != 0) {
        sb.append(Words[Digits[i]] + Units[i]);
        nz = i;
      } else {
        if (i % 4 != 0) {
          if (Digits[i - 1] != 0) {
            sb.append(Words[Digits[i]]);
          }
        } else {
          if (i == 0 || nz != 8) {
            sb.append(Units[i]);
          }
        }
      }
      --i;
    }
    if (Jiao.intValue() != 0) {
      sb.append(Words[Jiao.intValue()] + "角");
    } else if ((Fen.intValue() != 0) && (sb.length() > 0)) {
      sb.append("零");
    }
    if (Fen.intValue() != 0) {
      sb.append(Words[Fen.intValue()] + "分");
    }
    if (sb.length() == 0) {
      sb.append("零元零角零分");
    }
    if (Jiao.intValue() == 0 && Fen.intValue() == 0) {
      sb.append("整");
    }
    return sb.toString();
  }

  /**
   * 返回纯数字的字符串数值+number，并保留高位的0
   *
   * @param s 纯数字的字符串,调用者自己控制
   * @return
   */
  public static String stringAddNumber(String s, int number) {
    StringBuilder prefix = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if ('0' == s.charAt(i)) {
        prefix.append("0");
      } else {
        break;
      }
    }
    String result = prefix.append(Long.parseLong(s) + number).toString();
    int startIndex = result.length() - s.length();
    return result.substring(startIndex);
  }

  /**
   * 取两个BigDecimal中较小值
   *
   * @param a
   * @param b
   * @return
   */
  public static BigDecimal getLowerValue(BigDecimal a, BigDecimal b) {
    if (a != null && b != null) {
      return a.compareTo(b) > 0 ? b : a;
    } else if (a == null && b != null) {
      return b;
    } else if (a != null && b == null) {
      return a;
    } else {
      return null;
    }
  }

  /**
   * 取两个BigDecimal中较大值
   *
   * @param a
   * @param b
   * @return
   */
  public static BigDecimal getHigherValue(BigDecimal a, BigDecimal b) {
    if (a != null && b != null) {
      return a.compareTo(b) > 0 ? a : b;
    } else if (a == null && b != null) {
      return b;
    } else if (a != null && b == null) {
      return a;
    } else {
      return null;
    }
  }

  public static <T> T mergeDefaultValue(T value, T defaultValue) {
    if (value == null) {
      return defaultValue;
    }
    return value;
  }

  /**
   * 某类是否在给定的类列表中
   *
   * @param source
   * @param target
   * @return
   */
  public static boolean isGivenClass(Class<?> source, Class<?>... target) {
    for (Class<?> aClass : target) {
      if (ObjectUtils.equals(source, aClass)) {
        return true;
      }
    }
    return false;
  }

  public static String byteToString(byte[] bytes) throws UnsupportedEncodingException {
    return new String(bytes, 0, Converter.find0(bytes), "GBK");
  }
}
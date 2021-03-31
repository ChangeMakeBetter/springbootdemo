package com.yang.springbootdemo.util;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MyDecimalFormatSymbols {
  private static DecimalFormatSymbols decimalFormatSymbols;

  public synchronized static DecimalFormatSymbols getInstance() {
    if (decimalFormatSymbols == null) {
      decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
      decimalFormatSymbols.setDecimalSeparator('.');
      decimalFormatSymbols.setGroupingSeparator(',');
      decimalFormatSymbols.setMonetaryDecimalSeparator('.');
    }

    return decimalFormatSymbols;
  }

  public static void main(String[] args) {
    DecimalFormatSymbols f = new DecimalFormatSymbols(Locale.getDefault());
    System.out.println("ZeroDigit=" + f.getZeroDigit());
    System.out.println("getGroupingSeparator=" + f.getGroupingSeparator());
    System.out.println("getDecimalSeparator=" + f.getDecimalSeparator());
    System.out.println("getPerMill=" + f.getPerMill());
    System.out.println("getPercent=" + f.getPercent());
    System.out.println("getDigit=" + f.getDigit());
    System.out.println("getPatternSeparator=" + f.getPatternSeparator());
    System.out.println("getInfinity=" + f.getInfinity());
    System.out.println("getNaN=" + f.getNaN());
    System.out.println("getMinusSign=" + f.getMinusSign());
    System.out.println("getCurrencySymbol=" + f.getCurrencySymbol());
    System.out.println("getInternationalCurrencySymbol=" + f.getInternationalCurrencySymbol());
    System.out.println("getMonetaryDecimalSeparator=" + f.getMonetaryDecimalSeparator());
    System.out.println("getExponentSeparator=" + f.getExponentSeparator());
    System.out.println("getCurrencySymbol=" + f.getCurrencySymbol());
    System.out.println("getCurrency=" + f.getCurrency());
  }
}

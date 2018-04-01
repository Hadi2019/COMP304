package com.leicasimile.comp304.comp304_001_assignment4;

import android.text.format.DateFormat;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {
    public static String convertDate(String dateInMilliseconds,String dateFormat) {
        return DateFormat.format(dateFormat, Long.parseLong(dateInMilliseconds)).toString();
    }

    public static String getCurrency(double amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormat.format(amount);
    }

    public static String getPartialCardNo(String cardNo) {
        return String.format("***%s", cardNo.substring(cardNo.length() - 4, cardNo.length()));
    }
}

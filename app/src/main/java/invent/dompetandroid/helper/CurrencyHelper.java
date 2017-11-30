package invent.dompetandroid.helper;

import java.text.DecimalFormat;

public class CurrencyHelper {

    public static String format(int price){
        String symbol = "Rp ";
        return symbol + priceToString((double) price);
    }

    public static String format(String price){
        String symbol = "Rp ";
        Double dPrice = Double.parseDouble(price);
        return symbol + priceToString((double) dPrice);
    }

    public static String priceWithDecimal (Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00");
        return formatter.format(price);
    }

    public static String priceWithoutDecimal (Double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.##");
        return formatter.format(price);
    }

    public static String priceToString(Double price) {
        String toShow = priceWithoutDecimal(price);
        if (toShow.indexOf(".") > 0) {
            return priceWithDecimal(price);
        } else {
            return priceWithoutDecimal(price);
        }
    }
}

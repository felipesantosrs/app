package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class Utils {
		
	private Utils() {

	}

	public static LocalDate convertStringtoLocalDate(String date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			return LocalDate.parse(date, formatter);
		} catch (Exception e) {
			return null;
		}
	}

	public static Double convertStringToDouble(String number) {
		return new Double(number);
	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); 
	}
	
	public static Month convertToMonth(String m){
		if (isNumeric(m)) {
			return Month.of(Integer.valueOf(m));
		}else{
			return null;
		}
		
	}
	
	public static String format(double x) {  
	    DecimalFormat df = new DecimalFormat("#00.00",new DecimalFormatSymbols (Locale.CANADA));  
	    return df.format(x);
	}
	
	public static byte[] convertStringBuilderToByteArray(StringBuilder br){
		return br.toString().getBytes();
	}
}

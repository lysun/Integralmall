package com.doublev2v.integralmall.util;

import java.text.DecimalFormat;

public class DoubleSerializer {
	
	public static String format(double num) {
		DecimalFormat df = new DecimalFormat("#.00");  
		return df.format(num);
	}
}
 
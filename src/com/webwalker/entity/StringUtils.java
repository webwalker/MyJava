package com.webwalker.entity;

public class StringUtils {
	public static String gbk2ISO(String s) {
		if (s != null) {
			try {
				return new String(s.getBytes("GBK"), "ISO8859_1");
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}

	public static String isoTOGBK(String s) {


		if (s != null) {
			try {

				return new String(s.getBytes("ISO8859_1"), "GBK");

			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		return "";
	}
}

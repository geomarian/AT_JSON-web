package com.gipl.lms.utils;

public class StringUtils {

	public static boolean isNullOrEmpty(String input) {
		if(input!=null) {
			if(input.trim()!="") {
				return false;
			}
		}

		return true;
	}

}

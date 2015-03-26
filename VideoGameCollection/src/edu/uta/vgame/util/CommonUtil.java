package edu.uta.vgame.util;

import java.math.BigDecimal;
import java.util.Date;

public class CommonUtil {

	public static Boolean stringEmptyCheck(String str) {
		if (str.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public static Boolean dateEmptyCheck(Date date) {
		if (date.getDate() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean bigDecimalEmptyCheck(BigDecimal bigDecimal) {
		if (bigDecimal.toString().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean longNullCheck(Integer num) {
		if (num == null) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean intEmptyCheck(Integer num) {
		if (num == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean longNullCheck(Long num) {
		if (num == null) {
			return true;
		} else {
			return false;
		}
	}

}

package com.victori.toolbox.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.victori.toolbox.utils.TextFile;

/**
 * @author Pedro Victori
 *
 */

public class TextTools {
	public static String firstLetterToUpperCase(String value) {
		value = value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
		return value;
	}
	
	public static boolean containsOnlyLetters(String test){ //see regex
		Pattern pattern = Pattern.compile("^[a-zA-ZñáéíóúÁÉÍÓÚ]+$");
		Matcher matcher = pattern.matcher(test);
		return matcher.matches();
	}
}

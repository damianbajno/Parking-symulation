package pl.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class MassageTextUtils {

	public static String getValueBetweenTwoStrings(String text,
			String befourString, String afterString) {
		Pattern pattern = Pattern
				.compile(befourString + "(\\w*)" + afterString);
		Matcher matcher = pattern.matcher(text);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

	public static String makeFirstLetterUpper(String word){
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(String.valueOf(word.charAt(0)).toUpperCase());
		stringBuilder.append(word.substring(1));
		return stringBuilder.toString();
	}
	
	public static boolean isNumeric(String str) {
		return str.matches("\\d+");
	}

	public static boolean isText(String str) {
		return str.matches("[a-zA-Z]+\\s*[a-zA-Z]*");
	}
	
	public static void showMessage(){
		JOptionPane.showMessageDialog(null, "Wartość powinna składać się tylko z liczb");
	}

	public static boolean isTextIfNotShowMessage(String str) {
		System.out.println(str);
		if (str.trim().matches("[a-zA-Z]+\\s*[-]*[a-zA-Z]*"))
			return true;
		else {
			JOptionPane.showMessageDialog(null, "Wartość nie jest tekstem");
			return false;
		}
	}
	
}

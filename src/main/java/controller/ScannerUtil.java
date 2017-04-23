package controller;

import java.util.Scanner;

import view.View;

public class ScannerUtil {
	
	public String getRequiredField(Scanner sc, String regex, View view) {
		
		String result;

		while (!(sc.hasNext() && (result = sc.next()).matches(regex))) {
			view.error();
		}
		return result;

	}
}

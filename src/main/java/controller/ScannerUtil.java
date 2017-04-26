package controller;

import java.util.Scanner;

import view.View;

public class ScannerUtil {

	private Scanner sc;
	private View view;

	public ScannerUtil(Scanner sc, View view) {
		this.sc = sc;
		this.view = view;
	}

	public String getStringValueFromScanner(String regex) {

		String result;

		while (!(sc.hasNext() && (result = sc.next()).matches(regex))) {
			view.printErrorMessage();
		}
		return result;

	}

}

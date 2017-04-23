package controller;

import java.util.Scanner;

import view.View;

public class Controller {
	
	private View view;
	
	public Controller(View view) {
		this.view = view;
	}
	
	public void processUser() {
		Scanner sc = new Scanner(System.in);
		ScannerUtil scannerUtil = new ScannerUtil();
		String regex = "dog";
		System.out.println(scannerUtil.getRequiredField(sc, regex, view));	
	}
}

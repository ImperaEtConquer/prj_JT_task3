package controller;

import java.util.Scanner;

import model.Note;
import view.View;

public class Controller {
	
	private View view;
	private Note model;
	
	public Controller(Note model, View view) {
		this.view = view;
		this.model = model;
	}
	
	public void processUser() {
		Scanner sc = new Scanner(System.in);
		ScannerUtil scannerUtil = new ScannerUtil(sc, view);
		InputController inputController = new InputController(scannerUtil, model);
		inputController.addNewNote();
	}
}

package controller;

import model.Note;

public class InputController {

	private ScannerUtil scannerUtil;
	private Note model;

	public InputController(ScannerUtil scannerUtil, Note model) {
		this.scannerUtil = scannerUtil;
		this.model = model;
	}

	public void addNewNote() {
		scannerUtil.someMethod(RegEx.NAME);
	}

}

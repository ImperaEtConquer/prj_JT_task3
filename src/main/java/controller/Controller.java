package controller;

import java.util.Scanner;

import model.Notebook;
import view.View;

public class Controller {

	private View view;
	private Notebook notebook;

	public Controller(Notebook notebook, View view) {
		this.view = view;
		this.notebook = notebook;
	}

	public void processUser() throws Exception {
		Scanner sc = new Scanner(System.in);
		InputController inputController = new InputController(sc, notebook, view);

		while (true)
			inputController.addNewNote();
	}

}
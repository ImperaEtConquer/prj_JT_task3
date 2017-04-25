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
	
	public void processUser() throws Exception {
		Scanner sc = new Scanner(System.in);
		InputController inputController = new InputController(sc, model, view);
		inputController.addNewNote();
		System.out.println(model.toString());
	}
}

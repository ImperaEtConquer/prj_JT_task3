package controller;

import java.util.Scanner;

import model.Note;
import view.View;

public class Controller {
	
	private View view;
	private Note note;
	
	public Controller(Note note, View view) {
		this.view = view;
		this.note = note;
	}
	
	public void processUser() throws Exception {
		Scanner sc = new Scanner(System.in);
		InputController inputController = new InputController(sc, note, view);
		inputController.addNewNote();
		System.out.println(note.toString());
	}
}

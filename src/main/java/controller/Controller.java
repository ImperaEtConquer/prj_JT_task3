package controller;

import java.util.Scanner;

import model.Note;
import model.Notebook;
import view.Messages;
import view.View;

public class Controller {

	private View view;
	private Notebook notebook;

	public Controller(Notebook notebook, View view) {
		this.view = view;
		this.notebook = notebook;
	}

	public void processUser() {
		Scanner sc = new Scanner(System.in);
		InputController inputController = new InputController(sc, notebook, view);

		while (true) {
			try {
				inputController.addNewNote();
			} catch (Exception e) {
				boolean isFinished = false;
				Note currentNote = null;
				while (!isFinished) {
					view.printErrorMessage(Messages.ALREADY_EXISTS);
					currentNote = inputController.editNickName();
					isFinished = !(notebook.isNickNameAlreadyExist(currentNote.getNickname()));
				}
				notebook.addNoteToNoteBook(currentNote);
			}
			
			notebook.getAllNotes().forEach((k,v) -> {
				view.printMessage(v.toString());
			});
		}

	}

}
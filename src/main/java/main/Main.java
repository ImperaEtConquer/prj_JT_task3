package main;

import controller.Controller;
import model.Note;
import view.View;

public class Main {
	public static void main(String[] args) {
		Note model = new Note();
		View view = new View();
		Controller controller = new Controller(model, view);
		controller.processUser();
	}
}

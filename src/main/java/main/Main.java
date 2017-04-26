package main;

import controller.Controller;
import model.Notebook;
import view.View;

public class Main {
	public static void main(String[] args) throws Exception {
		Notebook notebook = new Notebook();
		View view = new View();
		Controller controller = new Controller(notebook, view);
		controller.processUser();
	}
}

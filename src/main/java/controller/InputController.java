package controller;

import java.time.LocalDateTime;
import java.util.Scanner;

import model.Groups;
import model.Note;
import model.Notebook;
import view.GlobalConstants;
import view.Messages;
import view.View;

public class InputController {

	private ScannerUtil scannerUtil;
	private Notebook notebook;
	private View view;

	private String firstname;
	private String lastname;
	private String middlename;
	private String nickname;

	private Groups group;
	private String phone;

	private String email;
	private String skype;

	private String lastEdited;

	private Note note;

	public InputController(Scanner sc, Notebook notebook, View view) {
		this.scannerUtil = new ScannerUtil(sc, view);
		this.view = view;
		this.notebook = notebook;
	}

	public void addNewNote() throws Exception {
		note = new Note();
		
		view.printInputMessage(Messages.FIRSTNAME);
		firstname = scannerUtil.getStringValueFromScanner(RegEx.NAME);

		view.printInputMessage(Messages.LASTNAME);
		lastname = scannerUtil.getStringValueFromScanner(RegEx.NAME);

		view.printInputMessage(Messages.MIDDLE_NAME);
		middlename = scannerUtil.getStringValueFromScanner(RegEx.NAME);

		view.printInputMessage(Messages.NICK_NAME);
		nickname = scannerUtil.getStringValueFromScanner(RegEx.NICK);

		group = getGroup();

		view.printInputMessage(Messages.PHONE);
		phone = scannerUtil.getStringValueFromScanner(RegEx.PHONE_NUMBER);

		view.printInputMessage(Messages.EMAIL);
		email = scannerUtil.getStringValueFromScanner(RegEx.EMAIL);

		view.printInputMessage(Messages.SKYPE);
		skype = scannerUtil.getStringValueFromScanner(RegEx.SKYPE);

		lastEdited = LocalDateTime.now().toString();

		confirm();
	}

	public void confirm() throws Exception {
		note.setFirstname(firstname);
		note.setLastname(lastname);
		note.setMiddlename(middlename);
		note.setNickname(nickname);
		note.setGroup(group);
		note.setPhone(phone);
		note.setEmail(email);
		note.setSkype(skype);
		note.setLastEdited(lastEdited);
		addToNoteBook(note);
		view.printMessage(Messages.SUCCESS);

	}

	public Note editNickName() {
		view.printInputMessage(Messages.NICK_NAME);
		nickname = scannerUtil.getStringValueFromScanner(RegEx.NICK);
		note.setNickname(nickname);
		return note;
	}

	private void addToNoteBook(Note note) throws Exception {
		notebook.addNoteToNoteBook(note);
	}

	private Groups getGroup() {
		StringBuilder sb = new StringBuilder();
		for (Groups group : Groups.values()) {
			sb.append(group.toString()).append(GlobalConstants.VERTICAL_BAR);
		}
		sb.deleteCharAt(sb.length() - 1);

		view.printInputMessage(Messages.GROUP);
		view.printMessage(sb.toString());
		String userChoice = scannerUtil.getStringValueFromScanner(sb.toString());

		if (userChoice.equals(Groups.FAMILY.toString())) {
			return Groups.FAMILY;
		}
		if (userChoice.equals(Groups.FRIENDS.toString())) {
			return Groups.FRIENDS;
		} else {
			return Groups.WORK;
		}
	}

}

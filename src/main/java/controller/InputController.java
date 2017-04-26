package controller;

import java.time.LocalDateTime;
import java.util.Scanner;

import model.Groups;
import model.Note;
import view.GlobalConstants;
import view.Messages;
import view.View;

public class InputController {

	private ScannerUtil scannerUtil;
	private Note note;
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

	public InputController(Scanner sc, Note note, View view) {
		this.scannerUtil = new ScannerUtil(sc, view);
		this.view = view;
		this.note = note;
	}

	public void addNewNote() throws Exception {
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

	private void confirm() {
		note.setFirstname(firstname);
		note.setLastname(lastname);
		note.setMiddlename(middlename);
		try {
			note.setNickname(nickname);
		} catch (Exception e) {
			view.printErrorMessage();
			editNickName(nickname);
		}
		note.setGroup(group);
		note.setPhone(phone);
		note.setEmail(email);
		note.setSkype(skype);
		note.setLastEdited(lastEdited);
	}
	
	private void editNickName(String nickname) {
		view.printInputMessage(Messages.NICK_NAME);
		nickname = scannerUtil.getStringValueFromScanner(RegEx.NICK);
		confirm();
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

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
	private Note model;
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

	public InputController(Scanner sc, Note model, View view) {
		this.scannerUtil = new ScannerUtil(sc, view);
		this.view = view;
		this.model = model;
	}

	public void addNewNote() throws Exception {
		view.printInputMessage(Messages.FIRSTNAME);
		firstname = scannerUtil.someMethod(RegEx.NAME);
		
		view.printInputMessage(Messages.LASTNAME);
		lastname = scannerUtil.someMethod(RegEx.NAME);
		
		view.printInputMessage(Messages.MIDDLE_NAME);
		middlename = scannerUtil.someMethod(RegEx.NAME);
		
		view.printInputMessage(Messages.NICK_NAME);
		nickname = scannerUtil.someMethod(RegEx.NICK);
		
		group = getGroup();
		
		view.printInputMessage(Messages.PHONE);
		phone = scannerUtil.someMethod(RegEx.PHONE_NUMBER);
		
		view.printInputMessage(Messages.EMAIL);
		email = scannerUtil.someMethod(RegEx.EMAIL);
		
		view.printInputMessage(Messages.SKYPE);
		skype = scannerUtil.someMethod(RegEx.SKYPE);
		
		lastEdited = LocalDateTime.now().toString();
		
		confirm();
	}
	
	private void confirm() {
		model.setFirstname(firstname);
		model.setLastname(lastname);
		model.setMiddlename(middlename);
		model.setNickname(nickname);
		model.setGroup(group);
		model.setPhone(phone);
		model.setEmail(email);
		model.setSkype(skype);
		model.setLastEdited(lastEdited);
	}
	
	private Groups getGroup() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (Groups group : Groups.values()) {
			sb.append(group.toString()).append(GlobalConstants.VERTICAL_BAR);
		}
		sb.deleteCharAt(sb.length()-1);
		
		view.printInputMessage(sb.toString());
		
		String userChoice = scannerUtil.someMethod(sb.toString());
		if (userChoice.equals(Groups.FAMILY.toString())) {
			return Groups.FAMILY;
		}
		if (userChoice.equals(Groups.FRIENDS.toString())) {
			return Groups.FRIENDS;
		}
		if (userChoice.equals(Groups.WORK.toString())) {
			return Groups.WORK;
		}
		else {
			throw new Exception();
		}
	}

}

package controller;

public interface RegEx {
	String NAME = "[A-Z]{1}[a-z]+";
	String NICK = ".{3,15}";
	String COMMENTARY = ".{1,60}";
	String PHONE_NUMBER = "^([0-9]){10}$";
	String EMAIL = "(.)+[@]{1}[a-z]+[.]{1}[a-z]+";
	String SKYPE = "[a-zA-Z]+[.]?";
	String INDEX = "[0-9]{3,5}";
}

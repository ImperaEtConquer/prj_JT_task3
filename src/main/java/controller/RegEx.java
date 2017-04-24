package controller;

public interface RegEx {
	String NAME = "[A-Z]{1}[a-z]+";
	String NICK = ".{3,15}";
	String COMMENTARY = ".{1,60}";
	String PHONE_NUMBER = "";
	String MOBILE_PHONE_NUMBER = "";
	String EMAIL = "(.)+[@]{1}[a-z]+[.]{1}[a-z]+";
	String SKYPE = "[a-zA-Z]+[.]?";
	String INDEX = "[0-9]{3,5}";

}

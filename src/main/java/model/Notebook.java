package model;

import java.util.HashMap;

import exceptions.AlreadyExistException;

public class Notebook {
	private HashMap<String, Note> notes;
	private boolean isNickNameAlreadyExist;

	public Notebook() {
		this.notes = new HashMap<String, Note>();
	}

	public void addNoteToNoteBook(Note note) {
		if (isNickNameAlreadyExist(note.getNickname())) {
			throw new AlreadyExistException();
		}
		notes.put(note.getLastname(), note);
	}

	public HashMap<String, Note> getAllNotes() {
		return notes;
	}

	public boolean isNickNameAlreadyExist(String nickname) {
		isNickNameAlreadyExist = false;
		notes.forEach((k, v) -> {
			if (v.getNickname().equals(nickname)) {
				isNickNameAlreadyExist = true;
			}
		});
		return isNickNameAlreadyExist;
	}

}

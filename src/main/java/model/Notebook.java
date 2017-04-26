package model;

import java.util.HashMap;

public class Notebook {
	private HashMap<String, Note> notes;
	
	public Notebook() {
		this.notes = new HashMap<String, Note>();
	}
	
	public void createNewNote() {
		
	}
	
	public void addNoteToNoteBook(Note note) {
		notes.put(note.getLastname(), note);
	}
	
	public HashMap<String, Note> getAllNotes() {
		return notes;
	}
	
}

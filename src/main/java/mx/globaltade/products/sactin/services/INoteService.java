package mx.globaltade.products.sactin.services;

import mx.globaltade.products.sactin.models.Note;

import java.util.List;

public interface INoteService {

    public Note createNote(Note newNote);
    public Note updateNote(Note note);
    public List<Note> getNotes();
    public List<Note> getNotesByProfile(String profileKey);
    public Note getNote(String noteKey);
    public boolean deleteNote(String noteKey);

}

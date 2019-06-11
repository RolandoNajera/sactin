package mx.globaltade.products.sactin.dao;

import mx.globaltade.products.sactin.models.Note;

import java.util.List;

public interface INoteDao {

    List<Note> getNotes();
    List<Note> getNotesByProfile(Long profileId);
    Note createNote(Note note);
    Note updateNote(Note note);
    Note getNote(Long id);
    boolean deleteNote(Long id);

}

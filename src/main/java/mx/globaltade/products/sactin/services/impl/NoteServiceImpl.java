package mx.globaltade.products.sactin.services.impl;

import mx.globaltade.products.sactin.models.Note;
import mx.globaltade.products.sactin.services.INoteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements INoteService {

    @Override
    public Note createNote(Note newNote) {
        newNote.setKey(Math.random() + "");
        return newNote;
    }

    @Override
    public Note updateNote(Note note) {
        note.getKey();
        return note;
    }

    @Override
    public List<Note> getNotes() {
        return populateNotes();
    }

    @Override
    public List<Note> getNotesByProfile(String profileKey) {
        return populateNotes();
    }

    @Override
    public Note getNote(String noteKey) {
        return new Note(Math.random() + "","2019/08/23 12:40:00","2019/08/25 12:40:00","235.50", "Comentario 1");
    }

    @Override
    public boolean deleteNote(String noteKey) {
        return false;
    }

    private List<Note> populateNotes() {
        List<Note> notes = new ArrayList<Note>();
        notes.add(new Note(Math.random() + "","2019/08/23 12:40:00","2019/08/25 12:40:00","235.50", "Comentario 1"));
        notes.add(new Note(Math.random() + "","2019/10/21 12:40:00","2019/08/22 12:40:00","450.50", "Comentario 2"));
        notes.add(new Note(Math.random() + "","2019/09/12 12:40:00","2019/08/15 12:40:00","135.50", "Comentario 3"));
        return notes;
    }

}

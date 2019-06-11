package mx.globaltade.products.sactin.services.impl;

import mx.globaltade.products.sactin.dao.INoteDao;
import mx.globaltade.products.sactin.models.Note;
import mx.globaltade.products.sactin.models.Profile;
import mx.globaltade.products.sactin.services.INoteService;
import mx.globaltade.products.sactin.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements INoteService {

    @Autowired
    private INoteDao noteDao;

    @Override
    public Note createNote(Note newNote) {
        return noteDao.createNote(newNote);
    }

    @Override
    public Note updateNote(Note note) {
        return noteDao.updateNote(note);
    }

    @Override
    public List<Note> getNotes() {
        return noteDao.getNotes();
    }

    @Override
    public List<Note> getNotesByProfile(Long profileKey) {
        return noteDao.getNotesByProfile(profileKey);
    }

    @Override
    public Note getNote(Long noteKey) {
        return noteDao.getNote(noteKey);
    }

    @Override
    public boolean deleteNote(Long noteKey) {
        return noteDao.deleteNote(noteKey);
    }


}

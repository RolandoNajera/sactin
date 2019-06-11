package mx.globaltade.products.sactin.dao.impl;

import mx.globaltade.products.sactin.dao.INoteDao;
import mx.globaltade.products.sactin.models.Note;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class NoteDaoImpl implements INoteDao {

    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Note> getNotes() {
        return em.createQuery("from Note").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Note> getNotesByProfile(Long profileId) {
        return em.createQuery("select n from Note n where n.profile.id = :profileId")
                .setParameter("profileId", profileId)
                .getResultList();
    }

    @Transactional
    @Override
    public Note createNote(Note note) {
        em.persist(note);
        return note;
    }

    @Transactional
    @Override
    public Note updateNote(Note note) {
        em.merge(note);
        return note;
    }

    @Transactional(readOnly = true)
    @Override
    public Note getNote(Long id) {
        return em.find(Note.class, id);
    }

    @Transactional
    @Override
    public boolean deleteNote(Long id) {
        em.remove(em.find(Note.class, id));
        return true;
    }
}

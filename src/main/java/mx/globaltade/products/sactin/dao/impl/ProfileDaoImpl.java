package mx.globaltade.products.sactin.dao.impl;

import mx.globaltade.products.sactin.dao.IProfileDao;
import mx.globaltade.products.sactin.models.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProfileDaoImpl implements IProfileDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Profile> getAll() {
        return em.createQuery("from Profile").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Profile getProfile(Long id) {
        return em.find(Profile.class, id);
    }

    @Transactional
    @Override
    public Profile createProfile(Profile profile) {
        em.persist(profile);
        return profile;
    }

    @Transactional
    @Override
    public Profile updateProfile(Profile profile) {
        em.merge(profile);
        return profile;
    }

    @Transactional
    @Override
    public boolean deleteProfile(Long id) {
        em.remove(em.find(Profile.class, id));
        return true;
    }
}

package mx.globaltade.products.sactin.services.impl;

import mx.globaltade.products.sactin.dao.IProfileDao;
import mx.globaltade.products.sactin.models.Profile;
import mx.globaltade.products.sactin.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("profileService")
public class ProfileServiceImpl implements IProfileService {

    @Autowired
    private IProfileDao profileDao;

    @Override
    public Profile createProfile(Profile newProfile) {
        return profileDao.createProfile(newProfile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profile;
    }

    @Override
    public List<Profile> getProfiles() {
        return profileDao.getAll();
    }

    @Override
    public Profile getProfile(String profileKey) {

        return profileDao.getProfile(profileKey);
    }

    @Override
    public boolean deleteProfile(String profileKey) {
        return true;
    }

}
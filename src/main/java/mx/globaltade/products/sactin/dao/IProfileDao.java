package mx.globaltade.products.sactin.dao;

import mx.globaltade.products.sactin.models.Profile;

import java.util.List;

public interface IProfileDao {

    List<Profile> getAll();
    List<Profile> searchProfiles(String param);
    Profile getProfile(Long key);
    Profile createProfile(Profile profile);
    Profile updateProfile(Profile profile);
    boolean deleteProfile(Long key);
}

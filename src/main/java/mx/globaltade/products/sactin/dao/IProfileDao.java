package mx.globaltade.products.sactin.dao;

import mx.globaltade.products.sactin.models.Profile;

import java.util.List;

public interface IProfileDao {

    List<Profile> getAll();
    Profile getProfile(String key);
    Profile createProfile(Profile profile);
    Profile updateProfile(Profile profile);
    boolean deleteProfile(String key);
}

package mx.globaltade.products.sactin.services;

import mx.globaltade.products.sactin.models.Profile;

import java.util.List;

public interface IProfileService {

    public Profile createProfile(Profile newProfile);
    public Profile updateProfile(Profile profile);
    public List<Profile> getProfiles();
    public Profile getProfile(Long profileKey);
    public boolean deleteProfile(Long profileKey);

}

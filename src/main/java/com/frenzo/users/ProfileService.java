package com.frenzo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepo profileRepo;

    public List<Profile> getProfiles() {
        List<Profile> profiles = profileRepo.findAll();
        if (!profiles.isEmpty()) {
            return profiles;
        } else {
            throw new NotFoundException("No profiles found");
        }
    }

    public Profile addProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    public void deleteProfile(int id) {
        profileRepo.deleteById(id);
    }

    public Profile getProfileById(int id) {
        Optional<Profile> profile = profileRepo.findById(id);
        if (profile.isPresent()) {
            return profile.get();
        } else {
            throw new NotFoundException("Profile not found with ID: " + id);
        }
    }

    public Profile updateProfile(int id, Profile updatedProfile) {
        return profileRepo.findById(id).map(existingProfile -> {
            updatedProfile.setId(existingProfile.getId());
            return profileRepo.save(updatedProfile);
        }).orElseThrow(() -> new RuntimeException("Profile not found with ID: " + id));
    }
}
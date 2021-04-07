package com.groupchat.server.service;

import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.model.Profile;
import com.groupchat.server.repo.ProfileRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    ParentServerTemplate parentServerTemplate;

    @Autowired
    ConnectionScheduler connectionScheduler;

    public Profile createProfile(@RequestBody CreateProfileRequest createProfileRequest) throws NotFoundException {
        //TODO Anunta connectionScheduler de event.
        //TODO Creaza un profil in serverul parinte
        //TODO Salveaza profilul primit in fisierul tau
        connectionScheduler.updateLastEvent();
        Profile profile = parentServerTemplate.createProfile(createProfileRequest);
        profileRepo.saveProfile(profile);
        return profile;
    }

    public List<Profile> getProfiles() {

        //TODO Anunta connectionScheduler de event.
        //TODO Ia toate profilele din serverul parinte.
        connectionScheduler.updateLastEvent();
        return parentServerTemplate.getProfiles();
    }

    public Profile getProfile() throws NotFoundException {
        //TODO Anunta connectionScheduler de event.
        //TODO Ia-ti profilul din fisier.
        connectionScheduler.updateLastEvent();
        return profileRepo.getProfile();

    }

}

package com.groupchat.server.service;

import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.model.Profile;
import com.groupchat.server.repo.ProfileRepo;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpClientErrorException;

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
        connectionScheduler.updateLastEvent();                                                  //TODO Anunta connectionScheduler de event.
        Profile profile = parentServerTemplate.createProfile(createProfileRequest);             //TODO Creaza un profil in serverul parinte
        profileRepo.saveProfile(profile);                                                       //TODO Salveaza profilul primit in fisierul tau
        return profile;
    }

    public List<Profile> getProfiles() {
        connectionScheduler.updateLastEvent();                      //TODO Anunta connectionScheduler de event.
        return parentServerTemplate.getProfiles();                  //TODO Ia toate profilele din serverul parinte.
    }

    public Profile getProfile() throws HttpClientErrorException.NotFound {
        connectionScheduler.updateLastEvent();          //TODO Anunta connectionScheduler de event.
        return profileRepo.getProfile();                //TODO Ia-ti profilul din fisier.

    }

}

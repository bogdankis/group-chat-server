package com.groupchat.server.service;

import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.model.Profile;
import com.groupchat.server.repo.ProfileRepo;
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

    public Profile createProfile(@RequestBody CreateProfileRequest createProfileRequest) {
        //TODO Anunta connectionScheduler de event.
        //TODO Creaza un profil in serverul parinte
        //TODO Salveaza profilul primit in fisierul tau
    }

    public List<Profile> getProfiles() {
        //TODO Anunta connectionScheduler de event.
        //TODO Ia toate profilele din serverul parinte.
    }

    public Profile getProfile() {
        //TODO Anunta connectionScheduler de event.
        //TODO Ia-ti profilul din fisier.

    }

}

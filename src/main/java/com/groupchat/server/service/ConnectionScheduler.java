package com.groupchat.server.service;

import com.groupchat.server.model.Profile;
import com.groupchat.server.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
@EnableScheduling
public class ConnectionScheduler {

    @Autowired
    ParentServerTemplate parentServerTemplate;

    @Autowired
    ProfileRepo profileRepo;

    private LocalDateTime lastEvent = LocalDateTime.now();

    //TODO Se aplica anotarea @Scheduled pe aceasta metoda pentru a fi chemata la fiecare 5 minute
    @Scheduled(fixedRate = 300000) //TODO 5min = 300000ms
    public void checkForOffline() {
        Profile profile = profileRepo.getProfile();                                                 //TODO Ia profilul.
        if (profile != null) {
            if (lastEvent.isAfter(LocalDateTime.now().plus(1, ChronoUnit.MINUTES))) {  //TODO Daca profilul exista, a trecut mai mult de 1 minut de cand s-a trigeruit un event si profilul apare ca online
                updateLastEvent();
                parentServerTemplate.disconnect(profile.getId());                                  //TODO anunta serverul parinte folosind disconnect
                profile.setOnline(false);                                                          //TODO seteeaza profilul ca offline
                profileRepo.saveProfile(profile);                                                  //TODO se salveaza in fisier
            }
        }
    }

    public void updateLastEvent() {
        lastEvent = LocalDateTime.now();           //TODO Se reseteaza lastEvent cu timpul de acum.
    }
}
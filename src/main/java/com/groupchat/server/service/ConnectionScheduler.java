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

    //TODO Aplica o anotare pe aceasta metoda pentru a fi chemata la fiecare 5 minute
    @Scheduled(fixedRate = 300000) //5min = 300000ms
    public void checkForOffline() {
        Profile profile = profileRepo.getProfile();
        if (profile != null) {
            if (lastEvent.isAfter(LocalDateTime.now().plus(1, ChronoUnit.MINUTES))) {
                updateLastEvent();
                parentServerTemplate.disconnect(profile.getId());
                profile.setOnline(false);
                profileRepo.saveProfile(profile);
            }
        }
    }

        /*
         TODO Ia profilul.
          Daca profilul exista, a trecut mai mult de 1 minut de cand s-a trigeruit un event si profilul apare ca online
          anunta serverul parinte folosind disconnect, seteeaza profilul ca offline, si salveaza-l in fisier
         */

    public void updateLastEvent() {
        //TODO Reseteaza lastEvent cu timpul de acum.
        lastEvent = LocalDateTime.now();
    }
}
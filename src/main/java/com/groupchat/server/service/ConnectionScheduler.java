package com.groupchat.server.service;

import com.groupchat.server.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

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
        profileRepo.getProfile();
        if(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(5)){

        }

        /*
         TODO Ia profilul.
          Daca profilul exista, a trecut mai mult de 1 minut de cand s-a trigeruit un event si profilul apare ca online
          anunta serverul parinte folosind disconnect, seteeaza profilul ca offline, si salveaza-l in fisier
         */
    }

    public void updateLastEvent() {
        //TODO Reseteaza lastEvent cu timpul de acum.
    }
}
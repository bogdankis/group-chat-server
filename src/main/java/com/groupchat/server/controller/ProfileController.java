package com.groupchat.server.controller;


import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.model.Profile;
import com.groupchat.server.service.ProfileService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping()
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileRequest createProfileRequest) throws NotFoundException { //TODO creaza profil
        return ResponseEntity.ok(profileService.createProfile(createProfileRequest));


    }

    // TODO Mapeaza metoda la GET, cu path-ul /all
    @GetMapping("/all")
    public ResponseEntity<?> getProfiles() {
        return ResponseEntity.ok(profileService.getProfiles()); //TODO aduce toate profilele

    }

    @GetMapping()
    public ResponseEntity<?> getProfile() throws HttpClientErrorException {
        //TODO Daca profilul este null, intoarce ca si status NotFound.
//        if (profileService.getProfile() == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(profileService.getProfile());
//        }
        try {
            return ResponseEntity.ok(profileService.getProfile());

        } catch (HttpClientErrorException.NotFound | NotFoundException notFound) {
            return ResponseEntity.status(404).body("Profile Not Found");

        }
    }
}

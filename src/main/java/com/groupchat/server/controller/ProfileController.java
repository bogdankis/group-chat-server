package com.groupchat.server.controller;


import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.model.Profile;
import com.groupchat.server.service.ProfileService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    // TODO Mapeaza metoda la POST, cu path-ul /
    @PostMapping()
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileRequest createProfileRequest) throws NotFoundException {
        //TODO
        return ResponseEntity.ok(profileService.createProfile(createProfileRequest));

    }

    // TODO Mapeaza metoda la GET, cu path-ul /all
    @GetMapping("/all")
    public ResponseEntity<?> getProfiles() {
        //TODO
        return ResponseEntity.ok(profileService.getProfiles());

    }

    // TODO Mapeaza metoda la GET, cu path-ul /
    @GetMapping()
    public ResponseEntity<?> getProfile() throws NotFoundException {
        //TODO
        //TODO Daca profilul este null, intoarce ca si status NotFound.
        if (profileService.getProfile() == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(profileService.getProfile());
        }
    }
}

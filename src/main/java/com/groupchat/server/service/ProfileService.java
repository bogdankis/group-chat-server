package com.groupchat.server.service;

import com.groupchat.server.dto.CreateProfileRequest;
import com.groupchat.server.model.Profile;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProfileService {
    Profile createProfile(@RequestBody CreateProfileRequest createProfileRequest) throws NotFoundException;

    List<Profile> getProfiles();

    Profile getProfile() throws NotFoundException;
}

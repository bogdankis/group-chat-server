package com.groupchat.server.repo;

import com.groupchat.server.model.Profile;

public interface ProfileRepo {

    Profile getProfile();

    void saveProfile(Profile profile);
}

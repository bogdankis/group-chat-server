package com.groupchat.server.repo;

import com.groupchat.server.model.Profile;
import com.groupchat.server.service.ParentServerTemplate;
import com.groupchat.server.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.ServerSocket;

@Repository
public class ProfileRepoImpl implements ProfileRepo {

    @Autowired
    ParentServerTemplate parentServerTemplate;

    public Profile getProfile() {


        File fisier = new File("profile.txt");

        if (fisier.exists()) {
            try {
                fisier.createNewFile();
                System.out.println("Fisier creat");
                ObjectInputStream profiles = new ObjectInputStream(new FileInputStream(fisier));
                for (int i = 0; i < profiles.available()){
                    profiles.read();
                    profiles.close();


                }
            } catch (IOException e) {
                return null;
                System.out.println("Fisierul este gol");
            }
        }
        if(!getProfile().getOnline()){
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                getProfile().setOnline(true);
                saveProfile(getProfile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    // TODO Ia un fisier, cu ce nume vrei (ex: profile.txt). Apeleaza o metoda pentru a il crea daca nu exista
    // TODO Returneaza null daca fisierul este gol (sau arunca expectie)
    // TODO Citeste Profile din fisier folosind ****InputStream si ******InputStream.
    // TODO Daca nu esti online, conecteaza-te la server, seteaza profilul ca online si salveaza-l in fisier
    // TODO Inchide stream-urile
    // TODO orice eroare primesti, intoarce null (sau arunca expectie)

    }


    public void saveProfile(Profile profile) {

        File fisier = new File("profile.txt");
        if (!fisier.exists()) {
            try {
                fisier.createNewFile();
            } catch (IOException e) {
                System.out.println("Fisierul este gol");
            }
        }
        // TODO Ia un fisier, cu ce nume vrei (ex: profile.txt). Apeleaza o metoda pentru a il crea daca nu exista
        // TODO Scrie Profile in fisier folosind ****OutputStream si ******OutputStream.
        // TODO Daca nu esti online, conecteaza-te la server, seteaza profilul ca online si salveaza-l in fisier
        // TODO Inchide stream-urile
    }
}

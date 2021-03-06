package com.groupchat.server.repo;

import com.groupchat.server.model.Profile;
import com.groupchat.server.service.ParentServerTemplate;
import com.groupchat.server.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.ServerSocket;
import java.util.UUID;

@Repository
public class ProfileRepoImpl implements ProfileRepo {

    @Autowired
    ParentServerTemplate parentServerTemplate;

    public Profile getProfile() {


        File fisier = new File("profile.txt");

        if (!fisier.exists()) {
            try {
                fisier.createNewFile();
            } catch (IOException e) {
                System.out.println("Fisier necreat");
                return null;
            }
        }
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            System.out.println("Fisier creat");
            fileInputStream = new FileInputStream(fisier);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Profile profile = (Profile) objectInputStream.readObject();
            if (profile != null && !profile.getOnline()) {
                parentServerTemplate.connect(profile.getId());
                profile.setOnline(true);
                saveProfile(profile);


            }
        return  profile;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fisierul este gol");
            return null;
        } finally {

            try {
                objectInputStream.close();
                fileInputStream.close();

            }catch (NullPointerException nullPointerException){
                System.out.println("Nu exista profil");
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Verifica daca profile exista
        // Doar citim din fisier, rezultatul o sa fie un obiect
        //Profile profile


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
                System.out.println("Fisierul nu exista");
            }


        }

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(fisier);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(profile);
            if (profile != null && !profile.getOnline()) {
                parentServerTemplate.connect(profile.getId());
                profile.setOnline(true);
                saveProfile(profile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul este gol");
        } catch (IOException e) {
            System.out.println("Nu sunt profile");
        } finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("Nu s-a inchis");
            }

        }
        //Adauga un profile doar daca este conectat/on
        // Doar scriemj/adaugam in fisier, rezultatul fisierul o sa aiba un obiect

        // TODO Ia un fisier, cu ce nume vrei (ex: profile.txt). Apeleaza o metoda pentru a il crea daca nu exista
        // TODO Scrie Profile in fisier folosind ****OutputStream si ******OutputStream.
        // TODO Daca nu esti online, conecteaza-te la server, seteaza profilul ca online si salveaza-l in fisier
        // TODO Inchide stream-urile
    }
}

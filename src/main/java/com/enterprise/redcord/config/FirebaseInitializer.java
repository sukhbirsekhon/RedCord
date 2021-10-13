package com.enterprise.redcord.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseInitializer {
    @PostConstruct
    public void initializer() {
        // Use a service account
        InputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("./ServiceAccountKey.json");
            FirebaseOptions options = null;
            try {
                options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://redcord-cad62-default-rtdb.firebaseio.com")
                        .build();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

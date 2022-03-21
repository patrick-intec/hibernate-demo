package be.infernalwhale.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManagerProvider {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("patrick-source");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEMF() {
        emf.close();
    }

    public void example() {
        Path secretsFile = Paths.get("/home/moktok/secrets/secret.file");
        try {
            List<String> contents = Files.readAllLines(secretsFile);
            // <information>
            // <information>
        } catch (IOException e) {
            e.printStackTrace();
        }


        Map<String, String> properties = new HashMap<>();
        // Key <> Value
//        properties.put("javax.persistence.jdbc.user", userVariable);
//        properties.put("javax.persistence.jdbc.password", pwdVariable);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("", properties);
    }
}

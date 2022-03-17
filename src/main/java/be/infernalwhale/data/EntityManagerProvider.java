package be.infernalwhale.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("patrick-source");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEMF() {
        emf.close();
    }
}

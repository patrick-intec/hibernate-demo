package be.infernalwhale;

import be.infernalwhale.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("patrick-source");
//        EntityManager em = emf.createEntityManager();
//
//        Message msg = em.find(Message.class, 1);
//        System.out.println(msg);
    }
}

package be.infernalwhale;

import be.infernalwhale.data.EntityManagerProvider;
import be.infernalwhale.model.Message;
import be.infernalwhale.model.User;

import javax.persistence.EntityManager;

public class CascadeMain {
    public static void main(String[] args) {
        EntityManager em = EntityManagerProvider.getEntityManager();

        User newUser = new User();
        newUser.setUsername("Emrah");

        Message message = new Message();
        message.setMessage("Hello Cascading world");
        message.setUser(newUser);

        em.persist(message);
        em.persist(newUser);

        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}

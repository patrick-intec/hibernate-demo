package be.infernalwhale;

import be.infernalwhale.data.EntityManagerProvider;
import be.infernalwhale.model.Message;
import be.infernalwhale.model.User;

import javax.persistence.EntityManager;

public class RelationMain {
    public static void main(String[] args) {
        EntityManager em = EntityManagerProvider.getEntityManager();

//        User existingUser = em.find(User.class, 3);

        User existingUser = new User();
        existingUser.setId(3);
        existingUser.setUsername("Patrick");
        // Related entity with generated value id
        // id >> id == null OR id == default value of datatype >> related entity does not exist
        // id >> id != null OR id != default value of datatype >> related entity exists

        // Related entity with non-generated id <>
        // em.find >> null >> related entity does not exist
        // em.find >> entity >> related entity exists

        Message message = new Message();
        message.setMessage("Hello Again Database");
        message.setUser(existingUser);

        em.persist(existingUser);
        em.persist(message);

        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}

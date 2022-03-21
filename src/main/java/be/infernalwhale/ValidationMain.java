package be.infernalwhale;

import be.infernalwhale.data.EntityManagerProvider;
import be.infernalwhale.model.Order;

import javax.persistence.EntityManager;

public class ValidationMain { // Not working yet...
    public static void main(String[] args) {
        // Validation: What is?
        // to validate: goedkeuren, values nakijken of ze geldig zijn...

        Order order = new Order();

        EntityManager em = EntityManagerProvider.getEntityManager();
        em.persist(order);

        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}

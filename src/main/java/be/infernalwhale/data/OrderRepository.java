package be.infernalwhale.data;

import be.infernalwhale.model.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderRepository {
    // CRUD
    // Create
    // Read
    // Update
    // Delete

    public Order getOrderById(int id) { // READ
        EntityManager em = EntityManagerProvider.getEntityManager();

        return em.find(Order.class, id);
    }

    public List<Order> getAllOrders() {

        return List.of();
    }


    public Order saveNewOrder(Order order) { // CREATE
        EntityManager em = EntityManagerProvider.getEntityManager();
        em.persist(order);

        em.getTransaction().begin();
        em.getTransaction().commit();

        return order;
    }

    public Order saveExistingOrder(Order order) { // UPDATE
        // em.merge(order)
        return null;
    }

    public void deleteOrder(Order order) { // DELETE
        // em.remove(order)

    }

}

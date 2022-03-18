package be.infernalwhale;

import be.infernalwhale.data.EntityManagerProvider;
import be.infernalwhale.model.Message;
import be.infernalwhale.model.User;
import be.infernalwhale.model.UserDTO;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class JPQLMain {
    public static void main(String[] args) {
        EntityManager em = EntityManagerProvider.getEntityManager();

        // JPQL : Java Persistence Query Language
        // JPA >> ORM Specification for a library
        // Hibernate >> ORM library

        // Unsafe query... try to avoid...
        Query query = em.createQuery("SELECT m FROM Message m");

        // SQL: SELECT id, message FROM message_table
        String jpqlString = "SELECT m FROM Message m WHERE m.id IN (1, 1, 2, 3, 5, 8, 13, 21)";
        TypedQuery<Message> typedQuery = em.createQuery(jpqlString, Message.class);
        List<Message> result = typedQuery.getResultList();

//        String jpql2 = "SELECT u FROM User u WHERE u.messages IS EMPTY";
        String jpql2 = "SELECT u FROM User u WHERE size(u.messages) > 2";
        TypedQuery<User> tquery = em.createQuery(jpql2, User.class);
        List<User> users = tquery.getResultList();

        String temp = "SELECT u.id, u.username FROM User u";
        // { id: 1, username: 'Patrick', messages: [] }


        String jpql_projection = "SELECT new be.infernalwhale.model.UserDTO(u.id, u.username) FROM User u WHERE u.id = 1";
        TypedQuery<UserDTO> userQuery = em.createQuery(jpql_projection, UserDTO.class);
        // { id: 1, username: 'Patrick' }

    }

}

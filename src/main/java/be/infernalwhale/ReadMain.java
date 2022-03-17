package be.infernalwhale;

import be.infernalwhale.model.Message;
import be.infernalwhale.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("patrick-source");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1);
        em.close();

        EntityManager em2 = emf.createEntityManager();
        User user2 = em2.merge(user);
        System.out.println(user2.getMessages().size());

//        Message message = em.find(Message.class, 2);
//        System.out.println(message);


        // Connection - Statement - statement.executeQuery >> ResultSet
        // JPA >> ResultSet omzetten naar Objects (List<Objects>)
        // rs.next
        // new Message() - memory allocation - memory partitioning - constructor call
        //               >> constructor call (constructor instantiates an object - this is wrong!!!)
        // message.setId(rs.getInt("id"))  // message.id = rs.getInt("id");
        // message.setMesg(rs.getString("message")) // message.mesg = rs.getString("message");
        // return of add to list

//        System.out.println(msg);
    }
}

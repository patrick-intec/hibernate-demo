package be.infernalwhale;

import be.infernalwhale.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("patrick-source");
        EntityManager em = emf.createEntityManager();

        Message msg = em.find(Message.class, 2);
        // Connection - Statement - statement.executeQuery >> ResultSet
        // JPA >> ResultSet omzetten naar Objects (List<Objects>)
        // rs.next
        // new Message() - memory allocation - memory partitioning - constructor call
        //               >> constructor call (constructor instantiates an object - this is wrong!!!)
        // message.setId(rs.getInt("id"))  // message.id = rs.getInt("id");
        // message.setMesg(rs.getString("message")) // message.mesg = rs.getString("message");
        // return of add to list

        System.out.println(msg);
    }
}

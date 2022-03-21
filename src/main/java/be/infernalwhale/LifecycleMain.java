package be.infernalwhale;

import be.infernalwhale.data.EntityManagerProvider;
import be.infernalwhale.model.Message;

import javax.persistence.EntityManager;

public class LifecycleMain {
    public static void main(String[] args) {
        // Entity Lifecycle Events
        // Geboorte, Opgroeien, Dood >> Lifecycle van levende wezens
        // Bouw van het huis, gebruik van het huis, afbreken van het huis

        // Instantiation, Object use , Eligible for GC  >> Lifecycle van java object??
        // Entity >> A simple data class (POJO) linked to a table
        // Lifecycle van een entity-objects ..
        // Instantiation (+init properties),  Object use , persisting, Eligible for GC, Read from Database
        // Here comes the existential question of the day...
        // Are they the same object?? yes-no question

        // Opinion 1: Yes, they are the same ()                     >> Database Identity ( id1.equals(id2) )
        // Opinion 2: Hmmmmmmmmmmm, yes (objects are equal)         >> Object Equality ( .equals() )
        // Opinion 3: No... (new object >> means different objects) >> Object Identity ( == )
        //   removing

        // Lifecycle of entity-object it's actually kind of the same as a normal object but with a loop
        // 1. Instantiation (+init properties) ( Birth ) | Read from Database ( Rebirth )
        // 2. Object use
        // 3. Persisting to database || updating to the database
        // 4. Possible: Eligible for GC
        // 5. Remove object from table || Database dies

        // Persist >> Create
        // @PrePersist // @PostPersist
        // Load    >> Read
        // @PostLoad
        // Update  >> Update
        // @PreUpdate // @PostUpdate
        // Remove  >> Delete
        // @PreRemove // @PostRemove

        Message message = new Message();
        message.setMessage("Testing lifecycles");

        EntityManager em = EntityManagerProvider.getEntityManager();

        em.persist(message);

        em.getTransaction().begin();
        em.getTransaction().commit();

        // @EntityListeners >> Add Lifecycle Methods from an external class
    }
}

package be.infernalwhale;

import be.infernalwhale.model.User;

public class EqualityMain {
    public static void main(String[] args) {
        User user = new User();
        // user object with 1 or a few properties filled in.

        // How JPA/Hibernate does it
        // There is only 1 way to check identity (database identity)
        // JPA always uses the @id...


        // Custom ways
        // just like the equals method
        // we can define custom ways to verify possible equality

        // 1. get the entity using your custom property
        //    JPQL >> SELECT u FROM User u WHERE u.username LIKE <username>
        // 2. Depending on result of query...
        //    No Results >> no equality
        //    Single/multiple result(s) >> check using for instance equals() method
        //    to avoid confusing >> use another method name (not equality)

        // Paralysis through analysis
    }
}

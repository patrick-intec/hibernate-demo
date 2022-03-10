package be.infernalwhale;

import be.infernalwhale.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // JPA - Java Persistence API
        // Persistence - Continued Existence - (aka save data to database)
        // API - Application Programming Interface... A bundle of rules on how to use a system/part of a system
        // A set of interfaces - Specification (JDBC) <> Implementation (mysql-driver)
        // RuntimeException >> "No suitable driver found"

        // JPA - Hibernate
        // ORM-libraries >> Object Relational(DB) Mapping
        // Classes <> Tables

        // Connection Application <> DB
        // Mapping    Order class <> order_table table
        // Mapping    Product class <> order_product table

        // EMF <> Connection

        // EntityManager >> Managed Entities >>> WTF is an entity??
        // Entity >> Data-Class + Mapping Information

        // Column       <> Property
        // Record/Row   <> Instance/Object
        // Table        <> Data-Class

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("patrick-source");
        EntityManager em = emf.createEntityManager();

        Message msg = new Message();
        msg.setId(2);
        msg.setMessage("Hello Database");

        em.persist(msg);

        em.getTransaction().begin();
        em.getTransaction().commit();

        // hbm2ddl - Hibernate Model To Data Definition Language
    }
}

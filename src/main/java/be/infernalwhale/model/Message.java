package be.infernalwhale.model;

import javax.persistence.*;

@Entity
@Table(name = "message_table") // We're mapping the class Message to the table 'message_table'
public class Message {
    @Id
    @GeneratedValue
    private int id;
    // msg.id = <value>   (NOT: msg.setId(<value>)   )

    //    @Column(columnDefinition = "varchar(75)")
    //    @Column(length = 75)
    //    @Lob // Large Object  (length = Max_Length_As_Defined_By_Database)
    @Column(name = "msg")
    private String message; // default: varchar(255) - Fine voor bijvoorbeeld sms/tweets (twitter)

    // Relationships in Java: add a property
    // Relationships in DB  : add a Foreign Key

    // OneToOne, OneToMany, ManyToOne, ManyToMany
    // examples: OneToMany  - 1 teacher many students (primary school students)
    // In Java : Teacher class with property of type Collection<Student>
    // In DB   : PK of one side use as FK on many side
    // examples: ManyToOne  - Many students 1 teacher
    // In Java : Student class with property of type Teacher
    // In DB   : PK of one side use as FK on many side

    // examples: ManyToMany - Many Employees work on Many Projects
    // In Java : Employee class with property of type Collection<Project>
    //           Project class with property of type Collection<Employee>
    // In DB   : an Intermediate table

    // Employee 1 : Nazif (1)
    // Employee 2 : Ali   (2)

    // Employee-Project  >> Intermediate table : this table represents the relationship
    // 1 A
    // 1 B
    // 2 B

    // Project 1 : Fix Car    (A)
    // Project 2 : Fix Window (B)

    // examples: OneToOne   - 1 Person has 1 id-card
    // In Java : Person with property of type IDCard
    //           IDCard with property of type Person
    // In DB   : PK of one side use as FK on other side
    //           We can choose what side 'owns'/'manages' the relationship. E.g. if we put the ID-card-FK in the Person table
    //           The Person table OWNS the relationship  >> Unidirectional Relationship
    //           We can also have 2 FK's...              >> BiDirectional Relationship

    // Class Message with Property of type User  (OneToOne / ManyToOne)
    @ManyToOne
    private User user;

    // Constructor Requirements - Entity must have a no-argument constructor
    public Message() {}

    public Message(String mesg) {
        this.message = mesg;
    }

    public int getId() {
        return id;
    }

    public Message setId(int id) {
        System.out.println("Setting value of id property in Message object");
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        System.out.println("Setting value of message property in Message object");
        this.message = message;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Message setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }
}

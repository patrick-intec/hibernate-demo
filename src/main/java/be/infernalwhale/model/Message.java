package be.infernalwhale.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    private int id;
    private String message;

    public int getId() {
        return id;
    }

    public Message setId(int id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}

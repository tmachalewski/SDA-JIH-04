package pl.sda;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Actor {

    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID id;

    private String name;

    public Actor() {
    }

    public Actor(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Actor(String name) {
        this.name = name;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

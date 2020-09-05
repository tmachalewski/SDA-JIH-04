package pl.sda;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actor {

    @Id
    @GeneratedValue
    @Column(length = 16)
    private UUID id;

    private String name;

    @ManyToMany
    private List<Movie> movies;

    public Actor(String name) {
        this.name = name;
    }


}

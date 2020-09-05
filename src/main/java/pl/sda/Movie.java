package pl.sda;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@ToString(exclude = "actors")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @EmbeddedId
    private MovieId movieId;

    private String title;

    private int yearOfProduction;

    @OneToOne(mappedBy="movie")
    private Studio studio;

    @ManyToMany
    private List<Actor> actors;

}

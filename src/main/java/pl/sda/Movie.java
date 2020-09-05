package pl.sda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @EmbeddedId
    private MovieId movieId;

    private String title;

    @OneToOne(mappedBy="movie")
    private Studio studio;

    @ManyToMany
    private List<Actor> actors;

}

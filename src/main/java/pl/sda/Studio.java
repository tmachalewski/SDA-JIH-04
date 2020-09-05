package pl.sda;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Data
@Getter
@Setter
@ToString(exclude = "movie")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Studio {

    @Id
    @GeneratedValue
    private int id;

    private String location;

    @OneToOne
    private Movie movie;
}

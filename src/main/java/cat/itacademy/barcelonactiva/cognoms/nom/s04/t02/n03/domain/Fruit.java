package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode
@Entity
@Document(collection="fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private String id;
    @Column
    @Getter
    @Setter
    private String name;
    @Column
    @Getter
    @Setter
    private int quantity;

    public Fruit() {

    }

}

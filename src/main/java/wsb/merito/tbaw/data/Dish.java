package wsb.merito.tbaw.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Dish {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private double price;
    private List<String> ingredients;
    private String category;
    private boolean isVegetarian;

}

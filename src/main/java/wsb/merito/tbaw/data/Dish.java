package wsb.merito.tbaw.data;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbaw_dish")
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
    @ManyToMany
    private List<Order> orders;
    private String category;
    private boolean isVegetarian;

}

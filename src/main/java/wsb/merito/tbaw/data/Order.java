package wsb.merito.tbaw.data;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "tbaw_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tableNumber;
    private String orderTime;
    private String status;
    @ManyToMany
    @JoinTable(
            name = "tbaw_order_dishes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishes;
    @ManyToOne
    @JoinColumn(name="chef_id")
    private Chef chef;
    private double totalAmount;

}

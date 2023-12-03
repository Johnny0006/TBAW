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
public class Order {

    @Id
    @GeneratedValue
    private int id;
    private int tableNumber;
    private String orderTime;
    private String status;
    private List<Dish> dishes;
    private double totalAmount;

}

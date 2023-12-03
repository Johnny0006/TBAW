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
public class Chef {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String specialization;
    private int experienceYears;
    private List<Order> realizedOrders;

}

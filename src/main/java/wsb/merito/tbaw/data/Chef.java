package wsb.merito.tbaw.data;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Table(name = "tbaw_chef")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialization;
    private int experienceYears;
    @OneToMany
    private List<Order> realizedOrders;

}

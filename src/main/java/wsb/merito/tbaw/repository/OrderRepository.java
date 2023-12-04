package wsb.merito.tbaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.merito.tbaw.data.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}

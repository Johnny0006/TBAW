package wsb.merito.tbaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.merito.tbaw.data.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

}

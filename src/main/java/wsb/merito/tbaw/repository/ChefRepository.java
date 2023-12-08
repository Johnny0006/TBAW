package wsb.merito.tbaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wsb.merito.tbaw.data.Chef;


@Repository
public interface ChefRepository extends JpaRepository<Chef, Integer> {
}

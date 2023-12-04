package wsb.merito.tbaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsb.merito.tbaw.data.Dish;
import wsb.merito.tbaw.repository.DishRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    private final DishRepository repository;

    @Autowired
    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Optional<Dish> find(int id) {
        return repository.findById(id);
    }

    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    @Transactional
    public void delete(Dish dish) {
        repository.delete(dish);
    }

}

package wsb.merito.tbaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wsb.merito.tbaw.data.Order;
import wsb.merito.tbaw.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Optional<Order> find(int id) {
        return repository.findById(id);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Order save(Order order) {
        return repository.save(order);
    }

    @Transactional
    public void delete(Order order) {
        repository.delete(order);
    }
}

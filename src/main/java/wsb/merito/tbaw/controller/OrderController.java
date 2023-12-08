package wsb.merito.tbaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wsb.merito.tbaw.data.Order;
import wsb.merito.tbaw.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service){
        this.service=service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable int id){
        return service.find(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Order order){
        service.save(order);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@RequestBody Order order, @PathVariable int id){
        order.setId(id);
        return service.find(id).map(value -> ResponseEntity.ok(service.save(order))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        return service.find(id).map(value -> {
                    service.delete(value);
                    return ResponseEntity.ok().<Void>build();
                }
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

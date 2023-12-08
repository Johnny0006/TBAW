package wsb.merito.tbaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wsb.merito.tbaw.data.Dish;
import wsb.merito.tbaw.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService service;

    @Autowired
    public DishController(DishService service){
        this.service=service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> get(@PathVariable int id){
        return service.find(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Dish dish){
        service.save(dish);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dish.getId()).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dish> update(@RequestBody Dish dish, @PathVariable int id){
        dish.setId(id);
        return service.find(id).map(value -> ResponseEntity.ok(service.save(dish))).orElseGet(() -> ResponseEntity.notFound().build());
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

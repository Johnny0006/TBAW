package wsb.merito.tbaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wsb.merito.tbaw.data.Chef;
import wsb.merito.tbaw.service.ChefService;

import java.util.List;

@RestController
@RequestMapping("/api/chefs")
public class ChefController {

    private final ChefService service;

    @Autowired
    public ChefController(ChefService service){
        this.service=service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chef> get(@PathVariable int id){
        return service.find(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Chef>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Chef chef){
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(chef.getId()).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chef> update(@RequestBody Chef chef, @PathVariable int id){
        return service.find(id).map(value -> ResponseEntity.ok(service.save(chef))).orElseGet(() -> ResponseEntity.notFound().build());
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

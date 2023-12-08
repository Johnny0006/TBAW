package wsb.merito.tbaw.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsb.merito.tbaw.data.Chef;
import wsb.merito.tbaw.repository.ChefRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChefService {

    private final ChefRepository repository;

    @Autowired
    public ChefService(ChefRepository repository) {
        this.repository = repository;
    }

    public Optional<Chef> find(int id) {
        return repository.findById(id);
    }

    public List<Chef> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Chef save(Chef chef) {
        return repository.save(chef);
    }

    @Transactional
    public void delete(Chef chef) {
        repository.delete(chef);
    }

}

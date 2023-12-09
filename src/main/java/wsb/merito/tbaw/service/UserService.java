package wsb.merito.tbaw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wsb.merito.tbaw.data.User;
import wsb.merito.tbaw.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;


    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> find(int id) {
        return repository.findById(id);
    }

    public Optional<User> findByUsername(String username){ return repository.findByUsername(username);}

    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}

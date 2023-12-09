package wsb.merito.tbaw;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import wsb.merito.tbaw.data.Role;
import wsb.merito.tbaw.data.User;
import wsb.merito.tbaw.service.UserService;

@Component
public class UserCreator {

    @Autowired
    private UserService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
        service.save(new User(1,"admin", passwordEncoder.encode( "admin"), Role.ADMIN));
        service.save(new User(2,"user", passwordEncoder.encode( "user"), Role.USER));
    }
}

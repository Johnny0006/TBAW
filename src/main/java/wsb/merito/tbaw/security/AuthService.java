package wsb.merito.tbaw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wsb.merito.tbaw.data.User;
import wsb.merito.tbaw.repository.UserRepository;

import java.net.http.HttpRequest;
import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UserRepository userRepository, JWTService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String signIn(User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        final String[] jwt = new String[1];
        userRepository.findByUsername(user.getUsername()).map(value -> jwt[0] = jwtService.generateToken(value))
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        return jwt[0];
    }
}

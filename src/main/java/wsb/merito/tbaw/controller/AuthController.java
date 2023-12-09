package wsb.merito.tbaw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import wsb.merito.tbaw.data.User;
import wsb.merito.tbaw.security.AuthService;

@Controller
@RequestMapping("/api/login")
public class AuthController {
    private final AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user){
        return ResponseEntity.ok(service.signIn(user));
    }
}

package pl.motoevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.motoevent.entity.User;
import pl.motoevent.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public String addUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "ok";
    }

//    @GetMapping("/login?error")
//    public String sss() {
//        return "redirect:http://www.google.pl";
//    }


}
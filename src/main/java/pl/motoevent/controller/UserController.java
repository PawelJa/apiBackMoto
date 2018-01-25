package pl.motoevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.motoevent.entity.User;
import pl.motoevent.repository.UserRepository;
import pl.motoevent.security.UserPrincipal;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userRepository.save(user);
        return "ok";
    }

    @GetMapping("/all")
    public List <User> getListOfUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/")
    public User getUserDetails (@AuthenticationPrincipal UserPrincipal principal) {
        return userRepository.findByUsername(principal.getUsername());
    }



}

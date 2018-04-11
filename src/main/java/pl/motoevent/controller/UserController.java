package pl.motoevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.motoevent.entity.User;
import pl.motoevent.entity.UserDetails;
import pl.motoevent.entity.UserRole;
import pl.motoevent.repository.UserDetailsRepository;
import pl.motoevent.repository.UserRepository;
import pl.motoevent.repository.UserRoleRepository;
import pl.motoevent.security.UserPrincipal;

import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/user")
    public String addUser(@RequestBody User user) {
//        User newUser = user;
        System.out.println("/n *************** SAVING ************* /n");
        System.out.println(user);
        UserRole userRole = new UserRole();
        userRole.setRole("USER");
        user.setUserRole(userRole);
        userRoleRepository.save(userRole);
        UserDetails userDetails = new UserDetails();
//        userDetails.setEmail(user.getEmail());
        userDetailsRepository.save(userDetails);
//        String pass = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        System.out.println("/n*******/n user added /n******/n");
        return "user added";
    }

    @GetMapping("/all")
    public List <User> getListOfUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User showUserDetails(@PathVariable long id) {
        return this.userRepository.findOne(id);
    }

//    @GetMapping("/")
//    public User getUserDetails (@AuthenticationPrincipal UserPrincipal principal) {
//        return userRepository.findByUsername(principal.getUsername());
//    }



}

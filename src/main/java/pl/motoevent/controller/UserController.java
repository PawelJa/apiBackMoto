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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("")
    public String addUser(@RequestBody User user) {
        System.out.println("/n *************** SAVING ************* /n");
        user.setActive(true);
        UserRole userRole = new UserRole();
        userRole.setRole("USER");
        user.setUserRole(userRole);
        userRoleRepository.save(userRole);
        UserDetails userDetails = new UserDetails();
        userDetailsRepository.save(userDetails);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        System.out.println(user);
        System.out.println("/n*******/n user added /n******/n");
        return "user added";
    }

    @GetMapping("/all")
    public List <User> getListOfUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/details")
    public UserDetails showUserDetails(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        User user = this.userRepository.findOne(userPrincipal.getId());
        return user.getUserDetails();
    }

    @PutMapping("/details/{id}")
    public String updateUserDetails(@RequestBody UserDetails userDetails, @PathVariable long id) {
        System.out.println("GIT");
//        UserDetails userDetails1 = userDetailsRepository.findOne(id);
//        System.out.println("/**********/n" + userDetails);
//        System.out.println("/**********/n" + userDetails1);
//        userDetailsRepository.save(userDetails);
        return "user details updated";

        // TODO !!
    }


}

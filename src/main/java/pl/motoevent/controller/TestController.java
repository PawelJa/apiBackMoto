package pl.motoevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.motoevent.entity.User;
import pl.motoevent.entity.UserRole;
import pl.motoevent.repository.UserRepository;
import pl.motoevent.repository.UserRoleRepository;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test")
    public String test() {
        return "{test: ok}";
    }

    @GetMapping("/addadmin")
    @ResponseBody
    public String addUser1() {
        User user = new User();
        user.setUsername("admin1");
        user.setPassword(bCryptPasswordEncoder.encode("abc1234"));
        user.setEmail("asdasd@afsdfsd.pl");
        UserRole userRole = new UserRole();
        userRole.setRole("ADMIN");
        user.setUserRole(userRole);
        userRoleRepository.save(userRole);
        userRepository.save(user);
        return "dodano admina";
    }

    @GetMapping("/adduser")
    @ResponseBody
    public String addUser2() {
        User user = new User();
        user.setUsername("user1");
        user.setPassword(bCryptPasswordEncoder.encode("abc1234"));
        user.setEmail("asdassd@afsdfsd.pl");
        UserRole userRole = new UserRole();
        userRole.setRole("USER");
        user.setUserRole(userRole);
        userRoleRepository.save(userRole);
        userRepository.save(user);
        return "dodano usera";
    }

    @GetMapping("/addmod")
    @ResponseBody
    public String addUser3() {
        User user = new User();
        user.setUsername("mod1");
        user.setPassword(bCryptPasswordEncoder.encode("abc1234"));
        user.setEmail("asdasssd@afsdfsd.pl");
        UserRole userRole = new UserRole();
        userRole.setRole("MOD");
        user.setUserRole(userRole);
        userRoleRepository.save(userRole);
        userRepository.save(user);
        return "dodano moda";
    }
}

package pl.motoevent.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.motoevent.security.UserPrincipal;

@Controller
public class LoginController {

    @GetMapping("/checkLogin")
    public String checkLogin(@AuthenticationPrincipal UserPrincipal principal) {
        if (principal != null) {
            return "redirect:http://localhost:8080/user/menu/menu.html";
        }
        return "redirect:/user/loginPage/login.html";
    }
}

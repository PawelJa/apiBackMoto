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
            System.out.println("\n***********************\n" + principal.getUsername() + "\n"
                    + principal.getAuthorities() + "\n"
                    + "\n***************************");
            if ((principal.getAuthorities().toString()).equals("[ROLE_ADMIN]")) {
                System.out.println("\n**********\n ADMIN \n***********\n");
                return "redirect:http://localhost:8080/admin/details/details-menu.html";
            } else if ((principal.getAuthorities().toString()).equals("[ROLE_MOD]")) {
                System.out.println("\n**********\n MOD \n***********\n");

                return "redirect:http://localhost:8080/mod/details/details.menu.html";
            }
            return "redirect:http://localhost:8080/user/menu/menu.html";
        }
        return "redirect:/user/loginPage/login.html";
    }
}

package ru.degtyar.geekbrains.spring.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.degtyar.geekbrains.spring.model.User;
import ru.degtyar.geekbrains.spring.service.AuthService;
import ru.degtyar.geekbrains.spring.service.UserService;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile/profile-view")
    public String profile(Model model, Principal principal){
        final User user = authService.getUser(principal);
        if (user == null) return "redirect:/login";
        model.addAttribute("user", user);
        return "profile/profile-view";
    }

    @PostMapping("/profile/profile-save")
    public String save(Principal principal, @ModelAttribute("user") final User user, final BindingResult result){
        final User userSession = authService.getUser(principal);
        userSession.setEmail(user.getEmail());
        userService.save(userSession);
        return "redirect:/profile/profile-view";
    }
}

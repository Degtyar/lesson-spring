package ru.degtyar.geekbrains.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcome(Model uiModel, @PathVariable(value = "name") String name) {
        uiModel.addAttribute("name", name);
        return "welcome";
    }
}

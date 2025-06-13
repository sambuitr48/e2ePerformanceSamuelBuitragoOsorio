package co.cue.edu.apploginsamuelbuitrago.controller;

import co.cue.edu.apploginsamuelbuitrago.model.User;
import co.cue.edu.apploginsamuelbuitrago.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class RegisterController {

    @Autowired
    UserService userService;
    @GetMapping("/register")
    public String mostrarRegistro() {
        return "register";
    }

    @PostMapping("/register")
    public String procesarRegistro(@RequestParam String email,
                                   @RequestParam String password,
                                   Model model) {
        User nuevo = new User();
        nuevo.setEmail(email);
        nuevo.setPassword(password);
        userService.save(nuevo);
        model.addAttribute("mensaje", "Usuario registrado exitosamente.");
        return "register";
    }

}

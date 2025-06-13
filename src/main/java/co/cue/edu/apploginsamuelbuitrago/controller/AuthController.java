package co.cue.edu.apploginsamuelbuitrago.controller;

import co.cue.edu.apploginsamuelbuitrago.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // Renderiza login.html desde templates
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email,
                                @RequestParam String password,
                                Model model) {
        model.addAttribute("mensaje", "Login exitoso!");
        return "login";
    }
}

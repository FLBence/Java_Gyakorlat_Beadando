package com.example.java_gyak_bead.controller;
import com.example.java_gyak_bead.model.User;
import com.example.java_gyak_bead.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register"; // templates/register.html
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user,
                                  Model model) {

        if (repo.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Ilyen email már létezik.");
            return "register";
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("REG"); // Minden új felhasználó REG lesz

        repo.save(user);
        model.addAttribute("success", "Sikeres regisztráció!");
        return "login";
    }
}
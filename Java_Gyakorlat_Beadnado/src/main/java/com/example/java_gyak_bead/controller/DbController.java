package com.example.java_gyak_bead.controller;
import com.example.java_gyak_bead.repository.EredmenyRepository;
import com.example.java_gyak_bead.repository.GpRepository;
import com.example.java_gyak_bead.repository.PilotaRepository;
import com.example.java_gyak_bead.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DbController {

    private final PilotaRepository pilotaRepository;
    private final GpRepository gpRepository;
    private final EredmenyRepository eredmenyRepository;
    private final UserRepository userRepository;

    public DbController(PilotaRepository pilotaRepository,
                          GpRepository gpRepository,
                          EredmenyRepository eredmenyRepository, UserRepository userRepository) {
        this.pilotaRepository = pilotaRepository;
        this.gpRepository = gpRepository;
        this.eredmenyRepository = eredmenyRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/fooldal")
    public String fooldal() {
        return "fooldal";
    }


    @GetMapping("/adatbazis")
    public String adatbazis(Model model) {
        model.addAttribute("pilotak", pilotaRepository.findAll());
        model.addAttribute("gp", gpRepository.findAll());
        model.addAttribute("eredmenyek", eredmenyRepository.findAll());
        return "adatbazis";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }
}

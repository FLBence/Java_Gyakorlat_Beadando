package com.example.java_gyak_bead.Controller;
import com.example.java_gyak_bead.Repository.EredmenyRepository;
import com.example.java_gyak_bead.Repository.GpRepository;
import com.example.java_gyak_bead.Repository.PilotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DbController {

    private final PilotaRepository pilotaRepository;
    private final GpRepository gpRepository;
    private final EredmenyRepository eredmenyRepository;

    public DbController(PilotaRepository pilotaRepository,
                          GpRepository gpRepository,
                          EredmenyRepository eredmenyRepository) {
        this.pilotaRepository = pilotaRepository;
        this.gpRepository = gpRepository;
        this.eredmenyRepository = eredmenyRepository;
    }

    @GetMapping("/")
    public String index() {
        // index.html – Dimension téma, benne "cégbemutató" / F1 ismertető
        return "index";
    }

    @GetMapping("/adatbazis")
    public String adatbazis(Model model) {
        model.addAttribute("pilotak", pilotaRepository.findAll());
        model.addAttribute("gps", gpRepository.findAll());
        model.addAttribute("eredmenyek", eredmenyRepository.findAll());
        return "adatbazis";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin"; // egyszerű admin oldal – csak admin látja a SecurityConfig miatt
    }
}

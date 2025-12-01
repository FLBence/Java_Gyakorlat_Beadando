package com.example.java_gyak_bead.controller;

import com.example.java_gyak_bead.repository.PilotaRepository;
import com.example.java_gyak_bead.model.Pilota;
import com.example.java_gyak_bead.services.CRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/crud")
@CrossOrigin(origins = "*")
public class PilotaController {

    private final CRUDService service;

    public PilotaController(CRUDService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("pilotak", service.getall());
        model.addAttribute("ujPilota", new Pilota());
        return "crud";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("pilota", new Pilota());
        return "crud-add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("pilota") Pilota pilota, Model model) {
        try {
            service.save(pilota);
            return "redirect:/crud";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            return "crud-add";
        }
    }
    @GetMapping("/search")
    public String search(@RequestParam Integer id, Model model) {
        model.addAttribute("pilotak", service.getone(id).map(List::of).orElse(List.of()));
        model.addAttribute("ujPilota", new Pilota());
        return "crud";
    }

    // Szerkesztés (külön oldalra)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Pilota p = service.getone(id)
                .orElseThrow(() -> new IllegalArgumentException("Nincs ilyen pilóta: " + id));
        model.addAttribute("pilota", p);
        return "crud-edit";
    }

    @PostMapping("/edit/{id}")
    public String editSave(@PathVariable Integer id,
                           @ModelAttribute("pilota") Pilota mod) {
        service.update(id, mod);
        return "redirect:/crud";
    }

    // Törlés gomb
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/crud";
    }
}

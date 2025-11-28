package com.example.java_gyak_bead.controller;

import com.example.java_gyak_bead.repository.UzenetRepository;
import com.example.java_gyak_bead.model.Uzenet;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class KapcsolatController {

    @Autowired
    private UzenetRepository uzenetRepository;

    @GetMapping("/kapcsolat")
    public String kapcsolatForm(Model model) {
        model.addAttribute("form", new Uzenet());
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat")
    public String kuldes(
            @Valid @ModelAttribute("form") Uzenet uzenet,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "kapcsolat";
        }

        uzenet.setKuldve(LocalDateTime.now());
        uzenetRepository.save(uzenet);

        return "redirect:/uzenetek";
    }
}

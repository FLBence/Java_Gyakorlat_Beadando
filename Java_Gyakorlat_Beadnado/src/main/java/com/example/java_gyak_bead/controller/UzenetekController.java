package com.example.java_gyak_bead.controller;

import com.example.java_gyak_bead.repository.UzenetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UzenetekController {

    @Autowired
    private UzenetRepository uzenetRepository;

    @GetMapping("/uzenetek")
    public String uzenetek(Model model) {
        model.addAttribute("uzenetek", uzenetRepository.findAll());
        return "uzenetek";
    }
}

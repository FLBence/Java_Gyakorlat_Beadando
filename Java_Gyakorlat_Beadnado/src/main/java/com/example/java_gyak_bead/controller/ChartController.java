package com.example.java_gyak_bead.controller;
import com.example.java_gyak_bead.model.Pilota;
import com.example.java_gyak_bead.repository.PilotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ChartController {

    @Autowired
    private PilotaRepository pilotaRepository;

    @GetMapping("/chart")
    public String chartPage(Model model) {
        List<Pilota> pilotak = pilotaRepository.findAll();

        Map<String, Long> nationalityCount = pilotak.stream()
                .collect(Collectors.groupingBy(Pilota::getNemzet, Collectors.counting()));

        model.addAttribute("labels", nationalityCount.keySet());
        model.addAttribute("data", nationalityCount.values());

        return "chart";
    }
}


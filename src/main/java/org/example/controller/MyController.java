package org.example.controller;

import org.example.model.Petition;
import org.example.model.Signature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    private List<Petition> petitions = new ArrayList<>();

    // Pre-populate with some petitions
    public MyController() {
        petitions.add(new Petition(1, "Save Bushy Park", "Protect Bushy Park from development"));
        petitions.add(new Petition(2, "Improve Public Transport", "Request more buses in the city"));
        petitions.add(new Petition(3, "Galway Ring Road", "Build a ring road around the city to reduce congestion"));
        petitions.add(new Petition(4, "Less Tourist Shops", "More normal shops for locals in the city centre"));
        petitions.add(new Petition(5, "More Houses", "Build more affordable houses"));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("petitions", petitions);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("petition", new Petition());
        return "create";
    }

    @PostMapping("/create")
    public String createPetition(@ModelAttribute Petition petition) {
        petition.setId(petitions.size() + 1);
        petitions.add(petition);
        return "redirect:/view";
    }

    @GetMapping("/view")
    public String viewAll(Model model) {
        model.addAttribute("petitions", petitions);
        return "view";
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String searchResults(@RequestParam String keyword, Model model) {
        List<Petition> results = petitions.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
        model.addAttribute("results", results);
        return "results";
    }

    @GetMapping("/petition/{id}")
    public String viewPetition(@PathVariable int id, Model model) {
        Petition petition = petitions.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("petition", petition);
        return "petition";
    }

    @PostMapping("/petition/{id}/sign")
    public String signPetition(@PathVariable int id,
                               @RequestParam String name,
                               @RequestParam String email) {
        petitions.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .ifPresent(p -> p.getSignatures().add(new Signature(name, email)));
        return "redirect:/petition/" + id;
    }
}
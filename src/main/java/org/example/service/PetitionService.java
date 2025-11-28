package org.example.service;

import org.example.model.Petition;
import org.example.model.Signature;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionService {
    private List<Petition> petitions = new ArrayList<>();

    @PostConstruct
    public void init() {
        petitions.add(new Petition("Save the Park", "Protect our local park from development"));
        petitions.add(new Petition("Improve Public Transport", "Request more buses in the city"));
    }

    public List<Petition> getAll() {
        return petitions;
    }

    public Petition findById(int id) {
        return petitions.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void addPetition(Petition petition) {
        petition.setCreatedDate(LocalDate.now());
        petition.setClosingDate(petition.getCreatedDate().plusWeeks(2));
        petitions.add(petition);
    }

    public List<Petition> search(String keyword) {
        return petitions.stream()
                .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    public void signPetition(int id, String name, String email) {
        Petition petition = findById(id);
        if (petition != null) {
            petition.getSignatures().add(new Signature(name, email));
        }
    }
}
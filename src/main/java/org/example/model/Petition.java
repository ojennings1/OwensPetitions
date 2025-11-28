package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Petition implements Serializable {
    private static int counter = 1;

    private int id;
    private String title;
    private String description;
    private LocalDate createdDate;
    private LocalDate closingDate;
    private List<Signature> signatures = new ArrayList<>();

    public Petition() {}

    public Petition(String title, String description) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.createdDate = LocalDate.now();
        this.closingDate = createdDate.plusMonths(2);
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getCreatedDate() { return createdDate; }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getClosingDate() { return  closingDate; }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public List<Signature> getSignatures() { return signatures; }
    public void setSignatures(List<Signature> signatures) { this.signatures = signatures; }
}
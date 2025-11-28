package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Petition implements Serializable {
    private int id;
    private String title;
    private String description;
    private List<Signature> signatures = new ArrayList<>();

    public Petition() {}

    public Petition(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Signature> getSignatures() { return signatures; }
    public void setSignatures(List<Signature> signatures) { this.signatures = signatures; }
}
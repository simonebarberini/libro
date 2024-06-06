package com.example.libro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Edizione {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nomeEdizione;

    //Getters Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeEdizione() {
        return nomeEdizione;
    }
    public void setNomeEdizione(String nomeEdizione) {
        this.nomeEdizione = nomeEdizione;
    }

    
}

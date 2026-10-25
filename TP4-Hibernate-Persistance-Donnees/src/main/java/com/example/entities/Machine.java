package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "machines")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private String marque;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    public Machine() {}

    public Machine(int id, String marque, String ref, Salle salle) {
        this.id = id;
        this.marque = marque;
        this.ref = ref;
        this.salle = salle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    // Getters, setters et constructeurs
}
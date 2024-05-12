package com.icecream.icecream.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flavours")
public class Flavour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flavour_id")
    private Integer flavourId;
    @Column(name = "flavour_name")
    private String flavourName;

    public Integer getFlavourId() {
        return flavourId;
    }

    public void setFlavourId(Integer flavourId) {
        this.flavourId = flavourId;
    }

    public String getFlavourName() {
        return flavourName;
    }

    public void setFlavourName(String flavourName) {
        this.flavourName = flavourName;
    }
}

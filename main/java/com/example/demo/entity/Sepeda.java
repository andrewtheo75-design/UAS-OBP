package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Sepeda extends Kendaraan {

    private String tipe;   // Contoh: MTB, Roadbike, Lipat, Onthel

    // Konstruktor default
    public Sepeda() {
        super();
    }

    // Konstruktor lengkap
    public Sepeda(String merk, String model, int tahun, double hargaSewa, String tipe) {
        super(merk, model, tahun, hargaSewa);
        this.tipe = tipe;
    }

    // Getter & Setter
    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}

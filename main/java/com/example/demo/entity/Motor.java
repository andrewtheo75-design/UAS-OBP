package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Motor extends Kendaraan {

    private String tipeMesin;       // Contoh: DOHC, SOHC, 4-tak, 2-tak
    private int kapasitasMesin;     // Dalam CC, contoh: 150, 250, 500

    // Konstruktor default
    public Motor() {
        super();
    }

    // Konstruktor lengkap
    public Motor(String merk, String model, int tahun, double hargaSewa,
                 String tipeMesin, int kapasitasMesin) {

        super(merk, model, tahun, hargaSewa); // panggil parent
        this.tipeMesin = tipeMesin;
        this.kapasitasMesin = kapasitasMesin;
    }

    // GETTER & SETTER
    public String getTipeMesin() {
        return tipeMesin;
    }

    public void setTipeMesin(String tipeMesin) {
        this.tipeMesin = tipeMesin;
    }

    public int getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(int kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }
}

package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Penyewa extends User {

    private String alamat;

    public Penyewa() {
        super();
    }

    public Penyewa(String nama, String noHP, String alamat) {
        super(nama, noHP);
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

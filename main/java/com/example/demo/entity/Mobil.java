package com.example.demo.entity;

import jakarta.persistence.Entity;

@Entity
public class Mobil extends Kendaraan {

    private int kapasitas;     
    private String jenisBBM;   

    // Konstruktor default
    public Mobil() { //memanggil konstruktor superclass
        super(); //memanggil konstruktor superclass
    }

    // Konstruktor lengkap
    public Mobil(String merk, String model, int tahun, double hargaSewa,
                 int kapasitas, String jenisBBM) { //memanggil konstruktor superclass
        super(merk, model, tahun, hargaSewa); //memanggil konstruktor superclass
        this.kapasitas = kapasitas; //untuk mengatur kapasitas
        this.jenisBBM = jenisBBM; //untuk mengatur jenis bahan bakar
    }

    // Getter & Setter
    public int getKapasitas() { //mengembalikan kapasitas
        return kapasitas; //mengembalikan kapasitas
    }

    public void setKapasitas(int kapasitas) { //mengatur kapasitas
        this.kapasitas = kapasitas; //mengatur kapasitas
    }

    public String getJenisBBM() { //mengembalikan jenis bahan bakar
        return jenisBBM; //mengembalikan jenis bahan bakar
    }

    public void setJenisBBM(String jenisBBM) {
        this.jenisBBM = jenisBBM;
    }
}

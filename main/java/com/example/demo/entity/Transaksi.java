package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaksi;

    @ManyToOne
    @JoinColumn(name = "penyewa_id")
    private Penyewa penyewa;

    @ManyToOne
    @JoinColumn(name = "kendaraan_id")
    private Kendaraan kendaraan;

    private int lamaSewa;
    private double totalHarga;

    public Transaksi() {}

    public Transaksi(Long idTransaksi, Penyewa penyewa, Kendaraan kendaraan,
                     int lamaSewa, double totalHarga) {

        this.idTransaksi = idTransaksi;
        this.penyewa = penyewa;
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
        this.totalHarga = totalHarga;
    }

    // Getter/setter asli
    public Long getIdTransaksi() {
        return idTransaksi;
    }
    //untuk mengatur id transaksi
    public void setIdTransaksi(Long idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    //untuk mengembalikan penyewa
    public Penyewa getPenyewa() {
        return penyewa;
    }
    //untuk mengatur penyewa
    public void setPenyewa(Penyewa penyewa) {
        this.penyewa = penyewa;
    }
    //untuk mengembalikan kendaraan
    public Kendaraan getKendaraan() {
        return kendaraan;
    }
    //untuk mengatur kendaraan
    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }
    //untuk mengembalikan lama sewa
    public int getLamaSewa() {
        return lamaSewa;
    }
    //untuk mengatur lama sewa
    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }
    //untuk mengembalikan total harga
    public double getTotalHarga() {
        return totalHarga;
    }

    //untuk mengatur total harga
    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    //untuk mengembalikan id transaksi
    public Long getId() {
        return this.idTransaksi;
    }
}

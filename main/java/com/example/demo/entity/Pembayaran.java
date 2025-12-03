package com.example.demo.entity;
 
import java.time.LocalDateTime;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
 
@Entity
public class Pembayaran {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPembayaran;
   
    @ManyToOne
    @JoinColumn(name = "transaksi_id")
    private Transaksi transaksi;
   
    private double jumlahBayar;
    private String metodePembayaran;
    private String statusPembayaran;
    private LocalDateTime tanggalPembayaran;
    private String buktiPembayaran;
   
    public Pembayaran() {}
   
    public Pembayaran(Transaksi transaksi, double jumlahBayar, String metodePembayaran,
                     String statusPembayaran, LocalDateTime tanggalPembayaran) {
        this.transaksi = transaksi;
        this.jumlahBayar = jumlahBayar;
        this.metodePembayaran = metodePembayaran;
        this.statusPembayaran = statusPembayaran;
        this.tanggalPembayaran = tanggalPembayaran;
    }
   
    public void prosesPembayaran() {
        this.statusPembayaran = "PROSES";
        this.tanggalPembayaran = LocalDateTime.now();
    }
   
    public void konfirmasiPembayaran() {
        this.statusPembayaran = "SUCCESS";
    }
   
    public void batalkanPembayaran() {
        this.statusPembayaran = "FAILED";
    }
   
    // GETTER & SETTER
    public Long getIdPembayaran() { return idPembayaran; }
    public void setIdPembayaran(Long idPembayaran) { this.idPembayaran = idPembayaran; }
   
    public Transaksi getTransaksi() { return transaksi; }
    public void setTransaksi(Transaksi transaksi) { this.transaksi = transaksi; }
   
    public double getJumlahBayar() { return jumlahBayar; }
    public void setJumlahBayar(double jumlahBayar) { this.jumlahBayar = jumlahBayar; }
   
    public String getMetodePembayaran() { return metodePembayaran; }
    public void setMetodePembayaran(String metodePembayaran) { this.metodePembayaran = metodePembayaran; }
   
    public String getStatusPembayaran() { return statusPembayaran; }
    public void setStatusPembayaran(String statusPembayaran) { this.statusPembayaran = statusPembayaran; }
   
    public LocalDateTime getTanggalPembayaran() { return tanggalPembayaran; }
    public void setTanggalPembayaran(LocalDateTime tanggalPembayaran) { this.tanggalPembayaran = tanggalPembayaran; }
   
    public String getBuktiPembayaran() { return buktiPembayaran; }
    public void setBuktiPembayaran(String buktiPembayaran) { this.buktiPembayaran = buktiPembayaran; }
   
    public Long getId() { return this.idPembayaran; }
}
 

package com.example.demo.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
 
@Entity
public class Produk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @NotNull
    @Size(min = 10, max = 10)
    private String tipe;
 
    @NotNull
    @Size(min = 3, max = 50)
    private String produsen;
 
    @Size(min = 11, max = 12)
    private String ram;
 
    public Produk() {}
 
    public Produk (String ram, String tipe, String produsen) {
        this.ram = ram;
        this.tipe = tipe;
        this.produsen = produsen;
    }
 
 
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
 
    public void setRam(String ram) {
        this.ram = ram;
    }
    public String getRam() {
        return ram;
    }
 
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    public String getTipe() {
        return tipe;
    }
 
    public void setProdusen(String produsen) {
        this.produsen = produsen;
    }
    public String getProdusen() {
        return produsen;
    }
}
 
 
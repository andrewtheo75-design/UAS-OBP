package com.example.demo.entity;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Penjualan {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long saleID;
@ManyToOne
private Person person;
private int jumlah;
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
private LocalDateTime tanggal;
private Long hargaJual;

public Penjualan(Long id, Person person,
int jumlah, LocalDateTime tanggal,
Long harga)
{
this.saleID = id;
this.person = person;
this.jumlah = jumlah;
this.tanggal = tanggal;
this.hargaJual = harga;
}
public Penjualan() {}

public void setSaleID(Long saleID) {
this.saleID = saleID;
}
public Long getSaleID() {
return saleID;
}
public void setPerson(Person person) {
this.person = person;
}
public Person getPerson() {
return person;
}
public void setJumlah(int jumlah) {
this.jumlah = jumlah;
}
public int getJumlah() {
return jumlah;
}
public void setTanggal(LocalDateTime tanggal) {
this.tanggal = tanggal;
}
public LocalDateTime getTanggal() {
return tanggal;
}
public void setHargaJual(Long hargaJual) {
this.hargaJual = hargaJual;
}
public Long getHargaJual() {
return hargaJual;
}
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    // Method untuk Login (Mencari Buyer berdasarkan Kode/Username)
    Buyer findByKode(String kode);
}
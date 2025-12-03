package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Seller;
import com.example.demo.repository.SellerRepository;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository; // Ganti ke SellerRepository

    // Ganti List<Person> -> List<Seller>
    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }

    // Ganti Person -> Seller
    public Seller addSeller(Seller obj) {
        Long id = null;
        obj.setId(id);
        return sellerRepository.save(obj);
    }

    // Ganti Person -> Seller
    public Seller getSellerById(long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    // Ganti Person -> Seller
    public Seller updateSeller(long id, Seller obj) {
        obj.setId(id);
        return sellerRepository.save(obj);
    }

    public void deleteSeller(long id) {
        sellerRepository.deleteById(id);
    }

    // Ini adalah tambahan dari slide 21 untuk login 
    public Seller findSeller(String kode) {
        return sellerRepository.findByKode(kode);
    }

    
}
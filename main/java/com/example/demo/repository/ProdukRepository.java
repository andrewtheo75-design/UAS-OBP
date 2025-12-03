package com.example.demo.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.demo.entity.Produk;
 
public interface ProdukRepository extends JpaRepository<Produk, Long>{}
 
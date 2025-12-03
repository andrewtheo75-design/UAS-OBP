package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Penjualan;
public interface PenjualanRepository extends JpaRepository<Penjualan, Long>{}
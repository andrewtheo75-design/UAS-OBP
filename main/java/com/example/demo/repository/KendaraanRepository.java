package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Kendaraan;

@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, Long> {
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Penyewa;

public interface PenyewaRepository extends JpaRepository<Penyewa, Long> {
}

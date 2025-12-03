package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Transaksi;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {

}

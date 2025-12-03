package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaksi;
import com.example.demo.repository.TransaksiRepository;

@Service
public class TransaksiService {

    @Autowired
    private TransaksiRepository transaksiRepository;

    public List<Transaksi> getAllTransaksi() {
        return transaksiRepository.findAll();
    }

    public void save(Transaksi transaksi) {
        transaksiRepository.save(transaksi);
    }

    public void update(Transaksi transaksi) {
        transaksiRepository.save(transaksi);
    }

    public void delete(Long id) {
        transaksiRepository.deleteById(id);
    }

    // 🟢 Tambahan penting untuk controller GET /transaksi/{id}
    public Transaksi getById(Long id) {
        return transaksiRepository.findById(id).orElse(null);
    }
}

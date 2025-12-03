package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Kendaraan;
import com.example.demo.repository.KendaraanRepository;

@Service
public class KendaraanService {

    @Autowired
    private KendaraanRepository kendaraanRepository;

    // 🟢 Ambil semua kendaraan
    public List<Kendaraan> getAllKendaraan() {
        return kendaraanRepository.findAll();
    }

    // 🟢 Tambah kendaraan
    public void save(Kendaraan kendaraan) {
        kendaraanRepository.save(kendaraan);
    }

    // 🟢 Update kendaraan
    public void update(Kendaraan kendaraan) {
        kendaraanRepository.save(kendaraan);
    }

    // 🟢 Hapus kendaraan berdasarkan ID
    public void delete(Long id) {
        kendaraanRepository.deleteById(id);
    }
}

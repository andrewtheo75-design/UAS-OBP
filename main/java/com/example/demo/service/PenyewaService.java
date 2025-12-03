package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Penyewa;
import com.example.demo.repository.PenyewaRepository;

@Service
public class PenyewaService {

    @Autowired
    private PenyewaRepository penyewaRepository;

    // Ambil semua penyewa
    public List<Penyewa> getAllPenyewa() {
        return penyewaRepository.findAll();
    }

    // Ambil penyewa by ID
    public Penyewa getPenyewaById(Long id) {
        return penyewaRepository.findById(id).orElse(null);
    }

    // Tambah penyewa
    public void save(Penyewa penyewa) {
        penyewaRepository.save(penyewa);
    }

    // Update penyewa
    public void update(Penyewa penyewa) {
        penyewaRepository.save(penyewa);
    }

    // Hapus penyewa
    public void delete(Long id) {
        penyewaRepository.deleteById(id);
    }
}

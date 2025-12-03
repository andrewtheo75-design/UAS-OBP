package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mobil;
import com.example.demo.repository.MobilRepository;

@Service
public class MobilService {

    @Autowired
    private MobilRepository mobilRepository;

    // Ambil semua data mobil
    public List<Mobil> getAllMobil() {
        return mobilRepository.findAll();
    }

    // Ambil 1 mobil berdasarkan ID
    public Mobil getMobilById(Long id) {
        return mobilRepository.findById(id).orElse(null);
    }

    // Simpan mobil (Add)
    public void save(Mobil mobil) {
        mobilRepository.save(mobil);
    }

    // Update mobil
    public void update(Mobil mobil) {
        mobilRepository.save(mobil);
    }

    // Hapus mobil
    public void delete(Long id) {
        mobilRepository.deleteById(id);
    }
}

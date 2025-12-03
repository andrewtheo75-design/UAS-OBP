package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Motor;
import com.example.demo.repository.MotorRepository;

@Service
public class MotorService {

    @Autowired
    private MotorRepository motorRepository;

    // Ambil semua motor
    public List<Motor> getAllMotor() {
        return motorRepository.findAll();
    }

    // Ambil motor by ID
    public Motor getMotorById(Long id) {
        return motorRepository.findById(id).orElse(null);
    }

    // Tambah motor
    public void save(Motor motor) {
        motorRepository.save(motor);
    }

    // Update motor
    public void update(Motor motor) {
        motorRepository.save(motor);
    }

    // Hapus motor
    public void delete(Long id) {
        motorRepository.deleteById(id);
    }
}

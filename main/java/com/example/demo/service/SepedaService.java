package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Sepeda;
import com.example.demo.repository.SepedaRepository;

@Service
public class SepedaService {

    @Autowired
    private SepedaRepository sepedaRepository;

    public List<Sepeda> getAllSepeda() {
        return sepedaRepository.findAll();
    }

    public Sepeda getSepedaById(Long id) {
        return sepedaRepository.findById(id).orElse(null);
    }

    public void save(Sepeda sepeda) {
        sepedaRepository.save(sepeda);
    }

    public void update(Sepeda sepeda) {
        sepedaRepository.save(sepeda);
    }

    public void delete(Long id) {
        sepedaRepository.deleteById(id);
    }
}


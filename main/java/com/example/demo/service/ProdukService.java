package com.example.demo.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.entity.Produk;
import com.example.demo.repository.ProdukRepository;
 
 
@Service
public class ProdukService {
    @Autowired
    private ProdukRepository produkRepository;
 
    public List<Produk> getAllProduk() {
        return produkRepository.findAll();
    }
}
 
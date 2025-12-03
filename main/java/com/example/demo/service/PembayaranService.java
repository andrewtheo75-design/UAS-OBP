package com.example.demo.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.demo.entity.Pembayaran;
import com.example.demo.repository.PembayaranRepository;
 
@Service
public class PembayaranService {
 
    @Autowired
    private PembayaranRepository pembayaranRepository;
 
    public List<Pembayaran> getAllPembayaran() {
        return pembayaranRepository.findAll();
    }
 
    public Pembayaran getPembayaranById(Long id) {
        return pembayaranRepository.findById(id).orElse(null);
    }
 
    public List<Pembayaran> getPembayaranByTransaksi(Long transaksiId) {
        return pembayaranRepository.findByTransaksiId(transaksiId);
    }
 
    public Pembayaran save(Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
    }
 
    public Pembayaran update(Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
    }
 
    public void delete(Long id) {
        pembayaranRepository.deleteById(id);
    }
 
    public Pembayaran prosesPembayaran(Pembayaran pembayaran) {
        pembayaran.prosesPembayaran();
        return pembayaranRepository.save(pembayaran);
    }
 
    public Pembayaran konfirmasiPembayaran(Long id) {
        Pembayaran pembayaran = getPembayaranById(id);
        if (pembayaran != null) {
            pembayaran.konfirmasiPembayaran();
            return pembayaranRepository.save(pembayaran);
        }
        return null;
    }
 
    public Pembayaran batalkanPembayaran(Long id) {
        Pembayaran pembayaran = getPembayaranById(id);
        if (pembayaran != null) {
            pembayaran.batalkanPembayaran();
            return pembayaranRepository.save(pembayaran);
        }
        return null;
    }
}
 

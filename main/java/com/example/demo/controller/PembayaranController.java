package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Pembayaran;
import com.example.demo.entity.Transaksi;
import com.example.demo.service.PembayaranService;
import com.example.demo.service.TransaksiService;

@Controller
@RequestMapping("/pembayaran")
public class PembayaranController {

    @Autowired
    private PembayaranService pembayaranService;

    @Autowired
    private TransaksiService transaksiService;

    @GetMapping
    public String pembayaranPage(Model model) {
        List<Pembayaran> pembayaranList = pembayaranService.getAllPembayaran();
        List<Transaksi> transaksiList = transaksiService.getAllTransaksi();
        
        model.addAttribute("pembayaranList", pembayaranList);
        model.addAttribute("transaksiList", transaksiList);
        model.addAttribute("pembayaranRec", new Pembayaran());
        
        return "pembayaran";
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Pembayaran pembayaran = pembayaranService.getPembayaranById(id);
        List<Pembayaran> pembayaranList = pembayaranService.getAllPembayaran();
        List<Transaksi> transaksiList = transaksiService.getAllTransaksi();
        
        model.addAttribute("pembayaranList", pembayaranList);
        model.addAttribute("transaksiList", transaksiList);
        model.addAttribute("pembayaranRec", pembayaran);
        
        return "pembayaran";
    }

    @PostMapping(params = "add")
    public String addPembayaran(@ModelAttribute Pembayaran pembayaran) {
        pembayaranService.save(pembayaran);
        return "redirect:/pembayaran";
    }

    @PostMapping(params = "edit")
    public String editPembayaran(@ModelAttribute Pembayaran pembayaran) {
        pembayaranService.update(pembayaran);
        return "redirect:/pembayaran";
    }

    @PostMapping(params = "delete")
    public String deletePembayaran(@ModelAttribute Pembayaran pembayaran) {
        if (pembayaran.getId() != null) {
            pembayaranService.delete(pembayaran.getId());
        }
        return "redirect:/pembayaran";
    }

    @PostMapping("/proses/{id}")
    public String prosesPembayaran(@PathVariable("id") Long id) {
        Pembayaran pembayaran = pembayaranService.getPembayaranById(id);
        if (pembayaran != null) {
            pembayaranService.prosesPembayaran(pembayaran);
        }
        return "redirect:/pembayaran";
    }

    @PostMapping("/konfirmasi/{id}")
    public String konfirmasiPembayaran(@PathVariable("id") Long id) {
        pembayaranService.konfirmasiPembayaran(id);
        return "redirect:/pembayaran";
    }

    @PostMapping("/batal/{id}")
    public String batalkanPembayaran(@PathVariable("id") Long id) {
        pembayaranService.batalkanPembayaran(id);
        return "redirect:/pembayaran";
    }
}
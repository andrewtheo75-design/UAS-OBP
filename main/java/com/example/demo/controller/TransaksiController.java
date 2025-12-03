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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Kendaraan;
import com.example.demo.entity.Penyewa;
import com.example.demo.entity.Transaksi;
import com.example.demo.service.KendaraanService;
import com.example.demo.service.PenyewaService;
import com.example.demo.service.TransaksiService;

@Controller
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private PenyewaService penyewaService;

    @Autowired
    private KendaraanService kendaraanService;

    // 🟢 Tampilkan daftar transaksi
    @GetMapping
    public String transaksiPage(Model model) {

        List<Transaksi> transaksiList = transaksiService.getAllTransaksi();
        List<Penyewa> penyewaList = penyewaService.getAllPenyewa();
        List<Kendaraan> kendaraanList = kendaraanService.getAllKendaraan();

        model.addAttribute("transaksiList", transaksiList);
        model.addAttribute("penyewaList", penyewaList);
        model.addAttribute("kendaraanList", kendaraanList);

        model.addAttribute("transaksiRec", new Transaksi()); 

        return "transaksi";
    }

    // 🟢 🔥 FIX ERROR 404 saat klik /transaksi/{id}
    @GetMapping("/{id}")
    public String getTransaksiById(@PathVariable("id") Long id, Model model) {

        Transaksi transaksi = transaksiService.getById(id);

        List<Transaksi> transaksiList = transaksiService.getAllTransaksi();
        List<Penyewa> penyewaList = penyewaService.getAllPenyewa();
        List<Kendaraan> kendaraanList = kendaraanService.getAllKendaraan();

        model.addAttribute("transaksiList", transaksiList);
        model.addAttribute("penyewaList", penyewaList);
        model.addAttribute("kendaraanList", kendaraanList);

        // Form akan otomatis terisi data lama
        model.addAttribute("transaksiRec", transaksi);

        return "transaksi";
    }

    // 🟢 Tambah transaksi baru
    @PostMapping(params = "add")
    public String addTransaksi(@ModelAttribute Transaksi transaksi) {
        transaksiService.save(transaksi);
        return "redirect:/transaksi";
    }

    // 🟢 Edit transaksi
    @PostMapping(params = "edit")
    public String editTransaksi(@ModelAttribute Transaksi transaksi) {
        transaksiService.update(transaksi);
        return "redirect:/transaksi";
    }

    // 🟢 Hapus transaksi
    @PostMapping(params = "delete")
    public String deleteTransaksi(@RequestParam("idTransaksi") Long idTransaksi) {
        transaksiService.delete(idTransaksi);
        return "redirect:/transaksi";
    }
}

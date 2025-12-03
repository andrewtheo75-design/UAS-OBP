package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Kendaraan;
import com.example.demo.service.KendaraanService;

@Controller
@RequestMapping("/kendaraan") //untuk mengatur routing ke /kendaraan
public class KendaraanController { //controller untuk mengatur alur data kendaraan

    @Autowired //untuk menghubungkan dengan service kendaraan
    private KendaraanService kendaraanService; 

    //  Tampilkan daftar kendaraan
    @GetMapping //untuk menampilkan halaman kendaraan
    public String KendaraanPage(Model model) { //model untuk mengirim data ke view
        List<Kendaraan> kendaraanList = kendaraanService.getAllKendaraan(); //mengambil semua data kendaraan dari service
        model.addAttribute("kendaraanList", kendaraanList); //untuk mengirim data kendaraanList ke view
        model.addAttribute("kendaraanRec", new Kendaraan()); //untuk mengirim data kendaraanRec ke view
        return "kendaraan"; //untuk mengarahkan ke halaman kendaraan.html
    }

    //  Tambah kendaraan baru
    @PostMapping(params = "add") //untuk menambahkan kendaraan baru
    public String addKendaraan(@ModelAttribute Kendaraan kendaraan) {
        kendaraanService.save(kendaraan);//menyimpan data kendaraan baru melalui service
        return "redirect:/kendaraan";//mengalihkan kembali ke halaman kendaraan
    }

    // Edit kendaraan
    @PostMapping(params = "edit") //untuk mengedit data kendaraan
    public String editKendaraan(@ModelAttribute Kendaraan kendaraan) { //untuk mengambil data kendaraan dari form
        kendaraanService.update(kendaraan); //untuk mengupdate data kendaraan melalui service
        return "redirect:/kendaraan";//untuk mengalihkan kembali ke halaman kendaraan
    }

    //  Hapus kendaraan
    @PostMapping(params = "delete")//untuk menghapus data kendaraan
    public String deleteKendaraan(@RequestParam("id") Long id) { //mengambil id kendaraan dari form
        kendaraanService.delete(id);//menghapus data kendaraan melalui service
        return "redirect:/kendaraan";//mengalihkan kembali ke halaman kendaraan
    }
}

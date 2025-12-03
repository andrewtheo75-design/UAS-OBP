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

import com.example.demo.entity.Mobil;
import com.example.demo.service.MobilService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mobil") //untuk mengatur routing ke /mobil
public class MobilController { //controller untuk mengatur alur data mobil

    @Autowired //untuk menghubungkan dengan service mobil
    private MobilService mobilService; //untuk menghubungkan dengan service mobil

     // Tampilkan halaman mobil

    @GetMapping //untuk menampilkan halaman mobil
    public String showMobilPage(Model model, HttpSession session) { //model untuk mengirim data ke view

        if (session.getAttribute("Seller") != null) { //cek apakah ada session Seller
            List<Mobil> allMobil = mobilService.getAllMobil(); //mengambil semua data mobil dari service

            model.addAttribute("mobilList", allMobil); //untuk mengirim data mobilList ke view
            model.addAttribute("mobilInfo", new Mobil()); //untuk mengirim data mobilInfo ke view
            model.addAttribute("mobilRec", null); //untuk mengirim data mobilRec ke view
            model.addAttribute("logSeller", session.getAttribute("Seller")); //untuk mengirim data logSeller ke view

            return "mobil"; //untuk mengarahkan ke halaman mobil.html
        } else {
            session.setAttribute("pageMobil", "M"); //menyimpan halaman mobil yang ingin diakses
            return "redirect:/login"; //mengalihkan ke halaman login
        }
    }

    @GetMapping("/{id}") //untuk menampilkan halaman edit mobil
    public String showEditForm(@PathVariable("id") Long id, Model model, HttpSession session) { //model untuk mengirim data ke view

        if (session.getAttribute("Seller") != null) { //cek apakah ada session Seller
            Mobil mobil = mobilService.getMobilById(id); //mengambil data mobil berdasarkan id dari service

            model.addAttribute("mobilRec", mobil);  //untuk mengirim data mobilRec ke view
            model.addAttribute("mobilInfo", mobil); //untuk mengirim data mobilInfo ke view
            model.addAttribute("mobilList", mobilService.getAllMobil()); //untuk mengirim data mobilList ke view
            model.addAttribute("logSeller", session.getAttribute("Seller")); //untuk mengirim data logSeller ke view

            return "mobil"; //untuk mengarahkan ke halaman mobil.html
        } else { //jika tidak ada session Seller
            session.setAttribute("pageMobil", "M"); //menyimpan halaman mobil yang ingin diakses
            return "redirect:/login"; //mengalihkan ke halaman login
        }
    }

    @PostMapping(params = "add")
    public String addMobil(@ModelAttribute Mobil mobil, HttpSession session) { //untuk mengambil data mobil dari form
        if (session.getAttribute("Seller") == null) return "redirect:/login";

        mobilService.save(mobil);
        return "redirect:/mobil";
    }

    @PostMapping(params = "edit")
    public String editMobil(@ModelAttribute Mobil mobil, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";

        mobilService.update(mobil);
        return "redirect:/mobil";
    }

    @PostMapping(params = "delete")
public String deleteMobil(@ModelAttribute Mobil mobil, HttpSession session) {

    if (session.getAttribute("Seller") == null) return "redirect:/login";

    if (mobil.getId() != null && mobil.getId() != 0) {
        mobilService.delete(mobil.getId());
    }

    return "redirect:/mobil";
}
}

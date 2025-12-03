package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Penyewa;
import com.example.demo.service.PenyewaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/penyewa")
public class PenyewaController {

    @Autowired
    private PenyewaService penyewaService;

    // 🟢 Tampilkan halaman penyewa
    @GetMapping
    public String showPenyewaPage(Model model, HttpSession session) {

        if (session.getAttribute("Seller") != null) {
            List<Penyewa> allPenyewa = penyewaService.getAllPenyewa();
            model.addAttribute("penyewaList", allPenyewa);
            model.addAttribute("penyewaInfo", new Penyewa());
            model.addAttribute("penyewaRec", null);
            model.addAttribute("logSeller", session.getAttribute("Seller"));
            return "penyewa";
        } else {
            session.setAttribute("pagePenyewa", "P");
            return "redirect:/login";
        }
    }

    // 🟢 Tampilkan form edit
    @GetMapping("/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, HttpSession session) {

        if (session.getAttribute("Seller") != null) {
            Penyewa penyewa = penyewaService.getPenyewaById(id);
            model.addAttribute("penyewaRec", penyewa);
            model.addAttribute("penyewaInfo", penyewa);
            model.addAttribute("penyewaList", penyewaService.getAllPenyewa());
            model.addAttribute("logSeller", session.getAttribute("Seller"));
            return "penyewa";
        } else {
            session.setAttribute("pagePenyewa", "P");
            return "redirect:/login";
        }
    }

    // 🟢 Tambah penyewa
    @PostMapping(params = "add")
    public String addPenyewa(@ModelAttribute Penyewa penyewa, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        penyewaService.save(penyewa);
        return "redirect:/penyewa";
    }

    // 🟢 Edit penyewa
    @PostMapping(params = "edit")
    public String editPenyewa(@ModelAttribute Penyewa penyewa, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        penyewaService.update(penyewa);
        return "redirect:/penyewa";
    }

    // 🟢 Hapus penyewa
    @PostMapping(params = "delete")
    public String deletePenyewa(@RequestParam("id") Long id, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        penyewaService.delete(id);
        return "redirect:/penyewa";
    }
}

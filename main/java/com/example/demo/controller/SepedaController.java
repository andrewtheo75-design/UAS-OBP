package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import com.example.demo.entity.Sepeda;
import com.example.demo.service.SepedaService;

@Controller
@RequestMapping("/sepeda")
public class SepedaController {

    @Autowired
    private SepedaService sepedaService;

    @GetMapping
    public String showSepedaPage(Model model, HttpSession session) {
        if (session.getAttribute("Seller") != null) {

            List<Sepeda> allSepeda = sepedaService.getAllSepeda();
            model.addAttribute("sepedaList", allSepeda);
            model.addAttribute("sepedaInfo", new Sepeda());
            model.addAttribute("sepedaRec", null);
            model.addAttribute("logSeller", session.getAttribute("Seller"));

            return "sepeda";

        } else {
            session.setAttribute("pageSepeda", "S");
            return "redirect:/login";
        }
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable("id") Long id, 
                               Model model, HttpSession session) {

        if (session.getAttribute("Seller") != null) {

            Sepeda sepeda = sepedaService.getSepedaById(id);

            model.addAttribute("sepedaRec", sepeda);
            model.addAttribute("sepedaInfo", sepeda);
            model.addAttribute("sepedaList", sepedaService.getAllSepeda());
            model.addAttribute("logSeller", session.getAttribute("Seller"));

            return "sepeda";

        } else {
            session.setAttribute("pageSepeda", "S");
            return "redirect:/login";
        }
    }

    @PostMapping(params = "add")
    public String addSepeda(@ModelAttribute Sepeda sepeda, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        sepedaService.save(sepeda);
        return "redirect:/sepeda";
    }

    @PostMapping(params = "edit")
    public String editSepeda(@ModelAttribute Sepeda sepeda, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        sepedaService.update(sepeda);
        return "redirect:/sepeda";
    }

    @PostMapping(params = "delete")
    public String deleteSepeda(@RequestParam("id") Long id, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        sepedaService.delete(id);
        return "redirect:/sepeda";
    }
}

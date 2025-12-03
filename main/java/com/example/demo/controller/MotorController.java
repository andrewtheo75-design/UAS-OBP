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

import com.example.demo.entity.Motor;
import com.example.demo.service.MotorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/motor")
public class MotorController {

    @Autowired
    private MotorService motorService;

    @GetMapping
    public String showMotorPage(Model model, HttpSession session) {

        if (session.getAttribute("Seller") != null) {
            List<Motor> allMotors = motorService.getAllMotor();
            model.addAttribute("motorList", allMotors);
            model.addAttribute("motorInfo", new Motor());
            model.addAttribute("motorRec", null);
            model.addAttribute("logSeller", session.getAttribute("Seller"));
            return "motor";
        } else {
            // Menandai bahwa user ingin ke halaman motor
            session.setAttribute("pageMotor", "M");
            return "redirect:/login";
        }
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, HttpSession session) {

        if (session.getAttribute("Seller") != null) {
            Motor motor = motorService.getMotorById(id);
            model.addAttribute("motorRec", motor);
            model.addAttribute("motorInfo", motor);
            model.addAttribute("motorList", motorService.getAllMotor());
            model.addAttribute("logSeller", session.getAttribute("Seller"));
            return "motor";
        } else {
            session.setAttribute("pageMotor", "M");
            return "redirect:/login";
        }
    }

    @PostMapping(params = "add")
    public String addMotor(@ModelAttribute Motor motor, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        motorService.save(motor);
        return "redirect:/motor";
    }

    @PostMapping(params = "edit")
    public String editMotor(@ModelAttribute Motor motor, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        motorService.update(motor);
        return "redirect:/motor";
    }

    @PostMapping(params = "delete")
    public String deleteMotor(@RequestParam("id") Long id, HttpSession session) {
        if (session.getAttribute("Seller") == null) return "redirect:/login";
        motorService.delete(id);
        return "redirect:/motor";
    }
}

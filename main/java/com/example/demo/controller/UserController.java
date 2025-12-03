package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 🟢 Tampilkan daftar user
    @GetMapping
    public String userPage(Model model) {

        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        model.addAttribute("userRec", new User());

        return "user";   // ini user.html
    }

    // 🟢 Tambah user baru
    @PostMapping(params = "add")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user";
    }

    // 🟢 Edit user
    @PostMapping(params = "edit")
    public String editUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/user";
    }

    // 🟢 Hapus user
    @PostMapping(params = "delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/user";
    }
}

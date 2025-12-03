package com.example.demo.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
 
import com.example.demo.entity.Produk;
import com.example.demo.service.ProdukService;
 
@Controller
public class ProdukController {
    @Autowired
    private ProdukService produkService;
   
    @GetMapping("/produk")
    public String ProdukPage(Model model) {
        @SuppressWarnings("unused")
        List<Produk> produkList;
        model.addAttribute("produkList", produkService.getAllProduk());
        return "produk.html";
    }
}
 
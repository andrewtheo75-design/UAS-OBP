package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Penjualan;
import com.example.demo.entity.Person;
import com.example.demo.service.PenjualanService;
import com.example.demo.service.PersonService;


@Controller
public class PenjualanController {
@Autowired
private PenjualanService penjualanService;
@Autowired
private PersonService personService;
@GetMapping("/penjualan")
public String PenjualanPage(Model model)
{
List<Penjualan> penjualanList = penjualanService.getAllPenjualan();
List<Person> personList = personService.getAllPerson();
model.addAttribute("penjualanList", penjualanList);
model.addAttribute("penjualanInfo", new Penjualan());
model.addAttribute("personList", personList);
return "penjualan.html";
}
@GetMapping("/penjualan/{id}")
public String PenjualanGetRec(Model model, @PathVariable("id") int id)
{
List<Penjualan> penjualanList = penjualanService.getAllPenjualan();
List<Person> personList = personService.getAllPerson();
Penjualan penjualanRec = penjualanService.getPenjualanById(id);
model.addAttribute("penjualanList", penjualanList);
model.addAttribute("penjualanRec", penjualanRec);
model.addAttribute("personList", personList);
return "penjualan.html";
}
@PostMapping( value={"/penjualan/submit/", "/penjualan/submit/{id}"}, params={"add"})
public String penjualanAdd(@ModelAttribute("penjualanInfo") Penjualan penjualanInfo)
{
penjualanService.addPenjualan(penjualanInfo);
return "redirect:/penjualan";
}
@PostMapping( value="/penjualan/submit/{id}", params={"edit"})
public String penjualanEdit(@ModelAttribute("penjualanInfo") Penjualan penjualanInfo,
@PathVariable("id") int id)
{
penjualanService.updatePenjualan(id,penjualanInfo);
return "redirect:/penjualan";
}
@PostMapping( value="/penjualan/submit/{id}", params={"delete"})
public String penjualanDelete(@PathVariable("id") int id)
{
penjualanService.deletePenjualan(id);
return "redirect:/penjualan";
}
}
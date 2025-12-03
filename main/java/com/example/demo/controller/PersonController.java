package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Buyer;
import com.example.demo.entity.Person;
import com.example.demo.entity.Seller;
import com.example.demo.service.BuyerService;
import com.example.demo.service.PersonService;
import com.example.demo.service.SellerService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private SellerService sellerService;
    
    @GetMapping(value={"/person", "/person/"})
    public String PersonPage(Model model)
    {
        List<Person> personList = personService.getAllPerson();
        model.addAttribute("personList", personList);
        model.addAttribute("personInfo", new Person());
        return "person.html";
    }
    
    @GetMapping("/person/{id}")
    public String personGetRec(Model model, @PathVariable("id") int id)
    {
        List<Person> personList = personService.getAllPerson();
        Person personRec = personService.getPersonById(id);
        model.addAttribute("personList", personList);
        model.addAttribute("personRec", personRec);
        return "person.html";
    }

    @GetMapping(value={"/buyer", "/buyer/"})
    public String BuyerPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Seller") != null){
            List<Buyer> buyerList = buyerService.getAllBuyer();
            model.addAttribute("buyerList", buyerList);
            model.addAttribute("buyerInfo", new Buyer());
            model.addAttribute("logSeller", request.getSession().getAttribute("Seller"));
            return "buyer.html";
        }
        else {
            request.getSession().setAttribute("pageBuyer", "B");
            return "redirect:/login";
        }
    }

    @GetMapping("/buyer/{id}")
    public String buyerGetRec(Model model, @PathVariable("id") int id, HttpServletRequest request){
        if(request.getSession().getAttribute("Seller") != null){
            List<Buyer> buyerList = buyerService.getAllBuyer();
            Buyer buyerRec = buyerService.getBuyerById(id);
            model.addAttribute("buyerList", buyerList);
            model.addAttribute("buyerRec", buyerRec);
            model.addAttribute("logSeller", request.getSession().getAttribute("Seller"));
            return "buyer.html";
        }
        else return "redirect:/login";
    }
    
    @GetMapping("/seller/{id}")
    public String sellerGetRec(Model model, @PathVariable("id") int id, HttpServletRequest request)
    {
        if(request.getSession().getAttribute("Seller") != null){
            List<Seller> sellerList = sellerService.getAllSeller();
            Seller sellerRec = sellerService.getSellerById(id);
            model.addAttribute("sellerList", sellerList);
            model.addAttribute("sellerRec", sellerRec);
            model.addAttribute("logSeller", request.getSession().getAttribute("Seller"));
            return "seller.html";
        }
        else return "redirect:/login";
    }
    
    @GetMapping(value="/login")
    public String sellerLoginPage(Model model, HttpServletRequest request) {
        if(request.getSession().getAttribute("Seller") != null){
            if(request.getSession().getAttribute("pageBuyer") !=null)
                return "redirect:/buyer";
            else return "redirect:/seller";
        }
        else return "login.html";
    }
    
    @GetMapping(value="/sellerlogout")
    public String sellerLogout(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("Seller") != null) {
            request.getSession().invalidate();
        }
        return "redirect:/login";
    }
    
    @GetMapping(value={"/seller", "/seller/"})
    public String SellerPage(Model model, HttpServletRequest request)
    {
        if(request.getSession().getAttribute("Seller") != null){
            List<Seller> sellerList = sellerService.getAllSeller();
            model.addAttribute("sellerList", sellerList);
            model.addAttribute("sellerInfo", new Seller());
            model.addAttribute("logSeller", request.getSession().getAttribute("Seller"));
            return "seller.html";
        }
        else return "redirect:/login";
    }
    
    @PostMapping( value={"/person/submit/", "/person/submit/{id}"}, params={"add"})
    public String personAdd(@ModelAttribute("personInfo") Person personInfo)
    {
        personService.addPerson(personInfo);
        return "redirect:/person";
    }
    
    @PostMapping( value="/person/submit/{id}", params={"edit"})
    public String personEdit(@ModelAttribute("personInfo") Person personInfo,
                            @PathVariable("id") int id)
    {
        personService.updatePerson(id,personInfo);
        return "redirect:/person";
    }
    
    @PostMapping( value="/person/submit/{id}", params={"delete"})
    public String personDelete(@PathVariable("id") int id)
    {
        personService.deletePerson(id);
        return "redirect:/person";
    }
    
    @PostMapping( value={"/buyer/submit/", "/buyer/submit/{id}"}, params={"add"})
    public String buyerAdd(@ModelAttribute("buyerInfo") Buyer buyerInfo)
    {
        buyerService.addBuyer(buyerInfo);
        return "redirect:/buyer";
    }
    
    @PostMapping( value="/buyer/submit/{id}", params={"edit"})
    public String buyerEdit(@ModelAttribute("buyerInfo") Buyer buyerInfo,
                            @PathVariable("id") int id)
    {
        buyerService.updateBuyer(id,buyerInfo);
        return "redirect:/buyer";
    }
    
    @PostMapping( value="/buyer/submit/{id}", params={"delete"})
    public String buyerDelete(@PathVariable("id") int id)
    {
        buyerService.deleteBuyer(id);
        return "redirect:/buyer";
    }
    
    @PostMapping( value={"/seller/submit/", "/seller/submit/{id}"}, params={"add"})
    public String sellerAdd(@ModelAttribute("sellerInfo") Seller sellerInfo)
    {
        sellerService.addSeller(sellerInfo);
        return "redirect:/seller";
    }
    
    @PostMapping( value="/seller/submit/{id}", params={"edit"})
    public String sellerEdit(@ModelAttribute("sellerInfo") Seller sellerInfo,
                            @PathVariable("id") int id)
    {
        sellerService.updateSeller(id,sellerInfo);
        return "redirect:/seller";
    }
    
    @PostMapping( value="/seller/submit/{id}", params={"delete"})
    public String sellerDelete(@PathVariable("id") int id)
    {
        sellerService.deleteSeller(id);
        return "redirect:/seller";
    }
    
    @PostMapping(value="/validateLogin")
    public String sellerLogin(Model model, @RequestParam(value="kode") String kodeUser,
                            @RequestParam(value="password") String passUser, HttpServletRequest request) {
        Seller S = sellerService.findSeller(kodeUser);
        model.addAttribute("userRec", S);
        if(S != null && passUser.equals(S.getPassword())) {
            request.getSession().setAttribute("Seller", S);
            if(request.getSession().getAttribute("pageBuyer") !=null)
                return "redirect:/motor";
            else return "redirect:/mobil";
        }
        else return "redirect:/login";
    }
}
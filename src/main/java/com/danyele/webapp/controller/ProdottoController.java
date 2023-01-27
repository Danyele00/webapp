package com.danyele.webapp.controller;

import com.danyele.webapp.entities.Posizioni;
import com.danyele.webapp.entities.Prodotto;
import com.danyele.webapp.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/prodotti")
public class ProdottoController {

    @Autowired
    private ProdottoService prodottoService;

    @GetMapping("/list")
    public String listProdotti(Model model){
        List<Prodotto> prodotti = prodottoService.findAll();
        model.addAttribute("prodotti",prodotti);
        return ("prodotti/list");
    }

    @GetMapping("/show/{id}")
    public String showProdotto(@PathVariable Long id, Model model){
        Prodotto prodotto = prodottoService.findById(id);
        model.addAttribute("prodotto", prodotto);
        return ("prodotti/show");
    }

    @GetMapping("/create")
    public String createProdotto(Model model) {
        Prodotto prodotto = new Prodotto();
        model.addAttribute("prodotto",prodotto);
        return "prodotti/create";
    }

    @PostMapping("/create")
    public String createProdotto(@ModelAttribute Prodotto prodotto, @ModelAttribute Posizioni posizioni,BindingResult result) {
        if(result.hasErrors()){
            System.out.println(result.getModel());

            return "prodotti/create";
        }
        prodottoService.save(prodotto);
        return "redirect:/prodotti/list";
    }
    @GetMapping("/edit/{id}")
    public String editProdottoForm(@PathVariable Long id, Model model){

        Prodotto prodotto = prodottoService.findById(id);
        model.addAttribute("prodotto",prodotto);
        deleteProdotto(id);
        return ("prodotti/edit");
    }

    @PostMapping("/edit")
    public String editProdotto(@ModelAttribute Prodotto prodotto){
        prodottoService.save(prodotto);

        return "redirect:/prodotti/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProdotto(@PathVariable Long id){
        prodottoService.deleteById(id);
        return ("redirect:/prodotti/list");
    }
}

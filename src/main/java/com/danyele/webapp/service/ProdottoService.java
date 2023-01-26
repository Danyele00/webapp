package com.danyele.webapp.service;

import com.danyele.webapp.entities.Prodotto;
import com.danyele.webapp.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;

    public List<Prodotto> findAll(){
        return prodottoRepository.findAll();
    }

    public Prodotto findById(Long id){
        Optional<Prodotto> optionalProdotto = prodottoRepository.findById(id);
        return optionalProdotto.orElse(null);
    }

    public Prodotto save(Prodotto prodotto){
        return prodottoRepository.save(prodotto);
    }

    public void deleteById(Long id){
        prodottoRepository.deleteById(id);
    }
}

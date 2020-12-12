package com.redupkr.distancia_cidades;

import com.redupkr.distancia_cidades.entity.Country;
import com.redupkr.distancia_cidades.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/counrty")
public class CountryResource {
    @Autowired
    private CountryRepository repository;

    @GetMapping("/all")
    public List<Country> findAll(){
        return repository.findAll();
    }

}

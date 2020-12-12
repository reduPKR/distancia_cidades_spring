package com.redupkr.distancia_cidades;

import com.redupkr.distancia_cidades.entity.Country;
import com.redupkr.distancia_cidades.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {
    @Autowired
    private CountryRepository repository;

    @GetMapping("/all")
    public List<Country> findAll(){
        return repository.findAll();
    }

    @GetMapping("/page")
    public Page<Country> getPage(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable long id){
        Optional<Country> optional = repository.findById(id);

        return optional.map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

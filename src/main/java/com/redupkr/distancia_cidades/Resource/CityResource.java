package com.redupkr.distancia_cidades.Resource;

import com.redupkr.distancia_cidades.entity.City;
import com.redupkr.distancia_cidades.entity.Country;
import com.redupkr.distancia_cidades.repository.CityRepository;
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
@RequestMapping("/cities")
public class CityResource {
    @Autowired
    private CityRepository repository;

    @GetMapping("/all")
    public List<City> findAll(){
        return repository.findAll();
    }

    @GetMapping("/page")
    public Page<City> getPage(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable long id){
        Optional<City> optional = repository.findById(id);

        return optional.map(city -> ResponseEntity.ok().body(city))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

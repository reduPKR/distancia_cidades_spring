package com.redupkr.distancia_cidades.Resource;

import com.redupkr.distancia_cidades.entity.Country;
import com.redupkr.distancia_cidades.entity.State;
import com.redupkr.distancia_cidades.repository.StateRepository;
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
@RequestMapping("/states")
public class StateResource {
    @Autowired
    private StateRepository repository;

    @GetMapping("/all")
    public List<State> findAll(){
        return repository.findAll();
    }

    @GetMapping("/page")
    public Page<State> getPage(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> getById(@PathVariable long id){
        Optional<State> optional = repository.findById(id);

        return optional.map(state -> ResponseEntity.ok().body(state))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

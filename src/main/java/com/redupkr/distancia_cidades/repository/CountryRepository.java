package com.redupkr.distancia_cidades.repository;

import com.redupkr.distancia_cidades.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}

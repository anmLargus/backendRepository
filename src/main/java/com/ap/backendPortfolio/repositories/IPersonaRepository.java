package com.ap.backendPortfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.backendPortfolio.models.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{

}

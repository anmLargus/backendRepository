package com.ap.backendPortfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.backendPortfolio.models.Educacion;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long>{

}

package com.ap.backendPortfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.backendPortfolio.models.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long>{

}

package com.ap.backendPortfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ap.backendPortfolio.models.Job;

@Repository
public interface IJobRepository extends JpaRepository<Job, Long>{	

}

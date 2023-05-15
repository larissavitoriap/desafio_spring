package com.edusync.spring.repositories;

import com.edusync.spring.models.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClinicaRepository  extends JpaRepository<Clinica, Integer> {


}

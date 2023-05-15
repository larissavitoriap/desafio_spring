package com.edusync.spring.repositories;

import com.edusync.spring.models.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer>{


}

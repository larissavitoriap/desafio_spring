package com.edusync.spring.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Veterinario {
    @Id
    Integer crm;
    String medico;

    @ManyToOne
    private Clinica clinica;


}

package com.edusync.spring.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer codigo;

    private LocalDate data;
    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Veterinario veterinario;
}

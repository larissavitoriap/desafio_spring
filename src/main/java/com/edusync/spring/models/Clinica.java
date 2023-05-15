package com.edusync.spring.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
public class Clinica {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    String nomeDaClinica;


}

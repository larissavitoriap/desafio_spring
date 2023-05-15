package com.edusync.spring.controllers;

import com.edusync.spring.models.Clinica;
import com.edusync.spring.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clinica")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;


    //adicionar
    @PostMapping(value = "/adicionar")
    public ResponseEntity novaClinica(@RequestBody Clinica clinica) {
        clinicaService.adicionar(clinica);
        return new ResponseEntity(clinica, HttpStatus.CREATED);
    }
    //listar
    @GetMapping
    public ResponseEntity listarClinicas() {
        return new ResponseEntity(clinicaService.listarTudo(), HttpStatus.OK);
    }

    //deletar
    @DeleteMapping(value = "/delete/{codigo}")
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        clinicaService.remover(codigo);
        return new ResponseEntity(HttpStatus.OK);


    }
    //alterar


    @PutMapping(value = "/atualizar/{codigo}")
    public ResponseEntity atualizarClinica(@PathVariable Integer codigo, @RequestBody Clinica clinica){
        clinicaService.update(codigo, clinica);
        return new ResponseEntity(codigo, HttpStatus.OK);
    }
}

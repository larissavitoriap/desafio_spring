package com.edusync.spring.controllers;

import com.edusync.spring.models.Clinica;
import com.edusync.spring.models.Veterinario;
import com.edusync.spring.service.ClinicaService;
import com.edusync.spring.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/veterinario")
public class VeterinarioController {
    @Autowired
    private VeterinarioService veterinarioService;


    //adicionar
    @PostMapping(value = "/adicionar")
    public ResponseEntity cadastrarVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.adicionar(veterinario);

        return new ResponseEntity("Cadastrado com Sucesso!", HttpStatus.CREATED);

    }

    //listar
    @GetMapping
    public ResponseEntity listarVeterinario() {
        return new ResponseEntity(veterinarioService.listarTudo(), HttpStatus.OK);
    }


    //deletar
    @DeleteMapping(value = "/apagar/{crm}")
    public ResponseEntity deletar(@PathVariable Integer crm) {
        veterinarioService.remover(crm);
        return new ResponseEntity(HttpStatus.OK);


    }
    //alterar


    @PutMapping(value = "/atualizar/{crm}")
    public ResponseEntity atualizar(@PathVariable Integer crm, @RequestBody Veterinario veterinario){
        veterinarioService.update(crm, veterinario);
        return new ResponseEntity(crm, HttpStatus.OK);
    }
}

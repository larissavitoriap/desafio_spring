package com.edusync.spring.controllers;

import com.edusync.spring.models.Agendamento;
import com.edusync.spring.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;



    //adicionar
    @PostMapping(value = "/novo")
    public ResponseEntity novoAgendamento(@RequestBody Agendamento agendamento) {
        agendamentoService.adicionar(agendamento);
        return new ResponseEntity(agendamento, HttpStatus.CREATED);
    }
    //listar
    @GetMapping
    public ResponseEntity listar() {
        return new ResponseEntity(agendamentoService.listarTudo(), HttpStatus.OK);
    }


    //deletar
    @DeleteMapping(value = "/apagar/{codigo}")
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        agendamentoService.remover(codigo);
        return new ResponseEntity(HttpStatus.OK);


    }
    //alterar


    @PutMapping(value = "/atualizar/{codigo}")
    public ResponseEntity atualizar(@PathVariable Integer codigo, @RequestBody Agendamento agendamento){
        agendamentoService.update(codigo, agendamento);
        return new ResponseEntity(codigo, HttpStatus.OK);
    }


}




package com.edusync.spring.controllers;


import com.edusync.spring.models.Cliente;
import com.edusync.spring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    //adicionar
    @PostMapping(value = "/adicionar")
    public ResponseEntity novoCliente(@RequestBody Cliente cliente) {
        clienteService.adicionar(cliente);
        return new ResponseEntity(cliente, HttpStatus.CREATED);
    }
    //listar
    @GetMapping
    public ResponseEntity listarTodosClientes() {
        return new ResponseEntity(clienteService.listarTudo(), HttpStatus.OK);
    }


    //deletar
    @DeleteMapping(value = "apagar/{codigo}")
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        clienteService.remover(codigo);
        return new ResponseEntity(HttpStatus.OK);


    }
    //alterar


    @PutMapping(value = "/atualizar/{codigo}")
    public ResponseEntity atualizarEstoque(@PathVariable Integer codigo, @RequestBody Cliente cliente){
        clienteService.update(codigo, cliente);
        return new ResponseEntity(codigo, HttpStatus.OK);
    }

}

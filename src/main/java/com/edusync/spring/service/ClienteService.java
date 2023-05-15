package com.edusync.spring.service;

import com.edusync.spring.models.Cliente;
import com.edusync.spring.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //criar
    public void adicionar(Cliente clienteSalvo) {
        clienteRepository.save(clienteSalvo);


    }

    //buscar
    private  Cliente buscarCodigo(Integer codigo) {
        Optional<Cliente> optionalDeCliente = clienteRepository.findById(codigo);
        if (optionalDeCliente.isPresent()) {
            return optionalDeCliente.get();
        }return null;
    }


    //deletar
    private void delete (Integer codigo){

        clienteRepository.deleteById(codigo);
    }

    //atualizar

    private void atualizar (Integer codigo){
        if (clienteRepository.existsById(codigo)){
            clienteRepository.deleteById(codigo);
        }
    }


    //listar todos
    public List<Cliente> listarTudo(){
        return clienteRepository.findAll();

    }


    public void remover(Integer codigo) {
        if (clienteRepository.existsById(codigo)) {
            clienteRepository.deleteById(codigo);
        }
    }

    public void update(Integer codigo, Cliente cliente) {

        if (clienteRepository.existsById(codigo)){
            clienteRepository.save(cliente);
        }
    }
}

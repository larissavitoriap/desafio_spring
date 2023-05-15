package com.edusync.spring.service;

import com.edusync.spring.models.Veterinario;
import com.edusync.spring.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    //criar
    public void adicionar( Veterinario veterinarioSalvo) {
        veterinarioRepository.save(veterinarioSalvo);


    }

    //buscar
    private  Veterinario buscarCodigo(Integer crm) {
        Optional<Veterinario> optionalDeVeterinario = veterinarioRepository.findById(crm);
        if (optionalDeVeterinario.isPresent()) {
            return optionalDeVeterinario.get();
        }return null;
    }


    //deletar
    private void delete (Integer crm){

        veterinarioRepository.deleteById(crm);
    }

    //atualizar

    private void atualizar (Integer crm){
        if (veterinarioRepository.existsById(crm)){
            veterinarioRepository.deleteById(crm);
        }
    }


    //listar todos
    public List<Veterinario> listarTudo(){
        return veterinarioRepository.findAll();

    }

    public void update(Integer crm, Veterinario veterinario) {

        if (veterinarioRepository.existsById(crm)){
            veterinarioRepository.save(veterinario);
        }
    }

    public void remover(Integer codigo) {
        if (veterinarioRepository.existsById(codigo)) {
            veterinarioRepository.deleteById(codigo);
        }
    }



}

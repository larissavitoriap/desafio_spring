package com.edusync.spring.service;

import com.edusync.spring.models.Cliente;
import com.edusync.spring.models.Clinica;
import com.edusync.spring.repositories.ClienteRepository;
import com.edusync.spring.repositories.ClinicaRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    //criar
    public void adicionar(Clinica clinicaSalva) {
        clinicaRepository.save(clinicaSalva);


    }

    //buscar
    public Clinica buscarCodigo(Integer codigo) {
        Optional<Clinica> optionalDeClinica = clinicaRepository.findById(codigo);
        if (optionalDeClinica.isPresent()) {
            return optionalDeClinica.get();
        }return null;
    }


    //deletar
    public void delete (Integer codigo){

        clinicaRepository.deleteById(codigo);
    }

    //atualizar

    public void atualizar (Integer codigo){
        if (clinicaRepository.existsById(codigo)){
            clinicaRepository.deleteById(codigo);
        }
    }


    //listar todos
    public List<Clinica> listarTudo(){
        return clinicaRepository.findAll();

    }

    public void remover(Integer codigo) {
        if (clinicaRepository.existsById(codigo)) {
            clinicaRepository.deleteById(codigo);
        }
    }

    public void update(Integer codigo, Clinica clinica) {
        if (clinicaRepository.existsById(codigo)){
           clinicaRepository.save(clinica);
        }

    }
}

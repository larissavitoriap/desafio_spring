package com.edusync.spring.service;

import com.edusync.spring.models.Agendamento;
import com.edusync.spring.models.Clinica;
import com.edusync.spring.repositories.AgendamentoRepository;
import com.edusync.spring.repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agenRepository;

    //criar
    public void adicionar(Agendamento agendamento) {
        agenRepository.save(agendamento);


    }

    //buscar
    public Agendamento buscarPorCodigo(Integer codigo) {
        Optional<Agendamento> optionalDeAgendamento = agenRepository.findById(codigo);
        if (optionalDeAgendamento.isPresent()) {
            return optionalDeAgendamento.get();
        }return null;
    }


    //deletar
    public void delete (Integer codigo){

        agenRepository.deleteById(codigo);
    }

    //atualizar

    public void atualizar (Integer codigo){
        if (agenRepository.existsById(codigo)){
            agenRepository.deleteById(codigo);
        }
    }


    //listar todos
    public List<Agendamento> listarTudo(){
        return agenRepository.findAll();

    }

    public void remover(Integer codigo) {
        if (agenRepository.existsById(codigo)) {
            agenRepository.deleteById(codigo);
        }
    }

    public void update(Integer codigo, Agendamento agendamento) {
        if (agenRepository.existsById(codigo)){
            agenRepository.save(agendamento);
        }

    }

}

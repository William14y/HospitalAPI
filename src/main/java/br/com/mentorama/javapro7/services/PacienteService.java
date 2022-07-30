package br.com.mentorama.javapro7.services;

import br.com.mentorama.javapro7.models.Paciente;
import br.com.mentorama.javapro7.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente findById(Long id){
        Optional<Paciente> obj = pacienteRepository.findById(id);
        return obj.orElseThrow(()-> new NotFoundException("id não foi encontrado"));
    }

    public Paciente post(Paciente patient){
        return pacienteRepository.save(patient);
    }

    public Paciente update(Paciente patient){
        return pacienteRepository.save(patient);
    }

    public void delete(Long id){
        pacienteRepository.deleteById(id);
    }

}

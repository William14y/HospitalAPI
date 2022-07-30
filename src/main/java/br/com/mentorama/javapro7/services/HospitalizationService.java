package br.com.mentorama.javapro7.services;


import br.com.mentorama.javapro7.models.Hospitalization;
import br.com.mentorama.javapro7.repository.HospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalizationService {

    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    public List<Hospitalization> findAll(){
        return hospitalizationRepository.findAll();
    }

    public Hospitalization findById(Long id){
        Optional<Hospitalization> obj = hospitalizationRepository.findById(id);
        return obj.orElseThrow(()-> new NotFoundException("id não foi encontrado"));
    }

    public Hospitalization post(Hospitalization hospitalization){
        return hospitalizationRepository.save(hospitalization);
    }
    public Hospitalization update (Hospitalization hospitalization){
        return hospitalizationRepository.save(hospitalization);
    }

    public void delete(Long id){
        hospitalizationRepository.deleteById(id);
    }


}

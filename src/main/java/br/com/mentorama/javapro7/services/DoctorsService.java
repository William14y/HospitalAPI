package br.com.mentorama.javapro7.services;

import br.com.mentorama.javapro7.models.Doctors;
import br.com.mentorama.javapro7.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository doctorsRepository;


    public List<Doctors> findAll (){
        return doctorsRepository.findAll();
    }


    public Doctors findById(Long id){
        Optional<Doctors> obj = doctorsRepository.findById(id);
        return obj.orElseThrow(()-> new NotFoundException("id Não foi encontrado"));
    }
    public Doctors post(Doctors doctor){
        return doctorsRepository.save(doctor);
    }

    public Doctors update(Doctors doctor){
        return doctorsRepository.save(doctor);
    }

    public void delete(Long id){
        doctorsRepository.deleteById(id);
    }


}

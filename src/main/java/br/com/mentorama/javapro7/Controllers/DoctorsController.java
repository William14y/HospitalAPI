package br.com.mentorama.javapro7.Controllers;

import br.com.mentorama.javapro7.models.Doctors;
import br.com.mentorama.javapro7.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/doctors")
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping()
    public ResponseEntity<List<Doctors>> findAll(){
        List<Doctors> all = doctorsService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctors> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(doctorsService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctors> post(Doctors doctor){
        return new ResponseEntity<>(doctorsService.post(doctor), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Doctors> update (Doctors doctor){
        return new ResponseEntity<>(doctorsService.update(doctor), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        doctorsService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

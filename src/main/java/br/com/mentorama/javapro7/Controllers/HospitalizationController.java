package br.com.mentorama.javapro7.Controllers;

import br.com.mentorama.javapro7.adapter.HospitalizationAdapter;
import br.com.mentorama.javapro7.models.*;
import br.com.mentorama.javapro7.services.DoctorsService;
import br.com.mentorama.javapro7.services.HospitalizationService;
import br.com.mentorama.javapro7.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/hospitalization")
public class HospitalizationController {
    @Autowired
    private HospitalizationService hospitalizationService;
    @Autowired
    private PacienteService paciente;
    @Autowired
    private DoctorsService doctorService;

    HospitalizationAdapter hospitalizationAdapter = new HospitalizationAdapter();

    @GetMapping
    public ResponseEntity<List<Hospitalization>> findAll(){
        return new ResponseEntity<>(hospitalizationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/by-paciente")
    public ResponseEntity<List<HospitalizationByPacient>> hospitalizationByPatient(){
        List<Paciente> patients = paciente.findAll();
        List<Hospitalization> hospitalizations = hospitalizationService.findAll();

        List<HospitalizationByPacient> hospitalizationByPatients = hospitalizationAdapter
                .adapterHospitalizationByPatient(hospitalizations,patients);

        return new ResponseEntity<>(hospitalizationByPatients, HttpStatus.OK);
    }

    @GetMapping("/by-doctors")
    public ResponseEntity<List<HospitalizationByDoctors>> hospitalizationByDoctor(){
        List<Doctors> doctors = doctorService.findAll();
        List<Hospitalization> hospitalizationList = hospitalizationService.findAll();

        List<HospitalizationByDoctors> hospitalizationByDoctors = hospitalizationAdapter
                .adapterHospitalizationByDoctor(hospitalizationList,doctors);
        return new ResponseEntity<>(hospitalizationByDoctors,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospitalization> findById(@PathVariable("id") Long id){
        hospitalizationService.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Hospitalization> post(Hospitalization hospitalization){
        return new ResponseEntity<>(hospitalizationService.post(hospitalization), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Hospitalization> update(Hospitalization hospitalization){
        return new ResponseEntity<>(hospitalizationService.update(hospitalization),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        hospitalizationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
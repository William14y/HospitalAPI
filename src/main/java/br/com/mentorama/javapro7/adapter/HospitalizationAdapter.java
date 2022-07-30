package br.com.mentorama.javapro7.adapter;

import br.com.mentorama.javapro7.models.*;

import java.util.List;
import java.util.stream.Collectors;

public class HospitalizationAdapter {


    public List<HospitalizationByPacient> adapterHospitalizationByPatient(List<Hospitalization> hospitalizations, List<Paciente> patient){
        List<HospitalizationByPacient> hospitalizationByPatients = patient.stream().map(patient1 -> {
            List<Hospitalization> hospitalizationList = hospitalizations.stream().filter(f->f.getPaciente().getId().equals(patient1.getId()))
                    .collect(Collectors.toList());
            return new HospitalizationByPacient(patient1,hospitalizationList);
        }).collect(Collectors.toList());
        return hospitalizationByPatients;
}
    public List<HospitalizationByDoctors> adapterHospitalizationByDoctor(List<Hospitalization> hospitalizations, List<Doctors> doctors){
        List<HospitalizationByDoctors> hospitalizationByDoctors = doctors.stream().map(doctor ->{
            List<Hospitalization> hospitalizationList = hospitalizations.stream().filter(d->d.getPaciente().getId().equals(doctor.getId()))
                    .collect(Collectors.toList());
            return new HospitalizationByDoctors(doctor,hospitalizationList);
        }).collect(Collectors.toList());
        return hospitalizationByDoctors;
    }
}



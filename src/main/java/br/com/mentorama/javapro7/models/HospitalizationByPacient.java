package br.com.mentorama.javapro7.models;


import java.util.List;

public class HospitalizationByPacient {
    private Paciente paciente;
    private List<Hospitalization> hospitalizations;

    public HospitalizationByPacient(Paciente paciente, List<Hospitalization> hospitalizations) {
        this.paciente = paciente;
        this.hospitalizations = hospitalizations;
    }

    public Paciente getPatient() {
        return paciente;
    }

    public void setPatient(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<Hospitalization> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }
}
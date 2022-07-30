package br.com.mentorama.javapro7.models;

import java.util.List;

public class HospitalizationByDoctors {
    private Doctors doctors;
    private List<Hospitalization> hospitalizations;

    public HospitalizationByDoctors(Doctors doctors, List<Hospitalization> hospitalizations) {
        this.doctors = doctors;
        this.hospitalizations = hospitalizations;
    }

    public Doctors getDoctors() {
        return doctors;
    }

    public void setDoctor(Doctors doctors) {
        this.doctors = doctors;
    }

    public List<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<Hospitalization> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }
}

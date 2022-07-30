package br.com.mentorama.javapro7.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_hospitalization")
public class Hospitalization {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Paciente patient;

    @ManyToMany
    @JoinColumn(name = "doctors")
    private List<Doctors> Responsedoctor = new ArrayList<>();

    private String dateEntry;
    private String dateExit;
    @Lob
    private String description;

    public Hospitalization(){

    }

    public Hospitalization(Long id, Paciente patient, List<Doctors> responsedoctor, String dateEntry, String dateExit, String description) {
        this.id = id;
        this.patient = patient;
        Responsedoctor = responsedoctor;
        this.dateEntry = dateEntry;
        this.dateExit = dateExit;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return patient;
    }

    public void setPatient(Paciente patient) {
        this.patient = patient;
    }

    public List<Doctors> getResponsedoctor() {
        return Responsedoctor;
    }

    public void setResponsedoctor(List<Doctors> responsedoctor) {
        Responsedoctor = responsedoctor;
    }

    public String getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getDateExit() {
        return dateExit;
    }

    public void setDateExit(String dateExit) {
        this.dateExit = dateExit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
package br.com.mentorama.javapro7;

import br.com.mentorama.javapro7.models.Doctors;
import br.com.mentorama.javapro7.models.Hospitalization;
import br.com.mentorama.javapro7.models.Paciente;
import br.com.mentorama.javapro7.repository.DoctorsRepository;
import br.com.mentorama.javapro7.repository.HospitalizationRepository;
import br.com.mentorama.javapro7.repository.PacienteRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;


@Configuration
public class sql implements CommandLineRunner {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private HospitalizationRepository hospitalizationRepository;
    @Autowired
    private DoctorsRepository doctorsRepository;
   

    @Override
    public void run(String... args) throws Exception {
        pacienteRepository.deleteAll();
        hospitalizationRepository.deleteAll();


        Paciente p4 = new Paciente(null,"Larissa Costa","(87)98846-4300", "15/03/1995");
        Paciente p5 = new Paciente(null,"Lorena Guimarães","(85)98855-4200", "07/06/1995");
        Paciente p6 = new Paciente(null,"Genilson Ulisses","(84)98850-2120", "18/09/1995");
        pacienteRepository.saveAll(Arrays.asList(p4,p5,p6));


        Doctors d1 = new Doctors(1L, "Juan José", "Cirurgião", "Cirurgias", "9999-9991");
        Doctors d2 = new Doctors(2L, "Janaina Fernandes", "Pediatra", "Pediatria", "9999-9990");
        doctorsRepository.saveAll(Arrays.asList(d1,d2));


        Hospitalization h1 =  new Hospitalization(1L,p4, Arrays.asList(d1), "27/07/2018", "10/08/2018","covid-19");
        Hospitalization h2 =  new Hospitalization(2L,p5, Arrays.asList(d2), "10/10/2017", "12/10/2017","Asma");
        Hospitalization h3 =  new Hospitalization(3L,p6, Arrays.asList(d1, d2), "09/09/2015", "09/09/2015","Gripe");


        hospitalizationRepository.saveAll(Arrays.asList(h1, h2, h3));
    }
}

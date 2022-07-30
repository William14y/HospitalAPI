package br.com.mentorama.javapro7.repository;


import br.com.mentorama.javapro7.models.Doctors;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
}

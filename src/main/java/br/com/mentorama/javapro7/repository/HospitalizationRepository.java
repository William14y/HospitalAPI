package br.com.mentorama.javapro7.repository;

import br.com.mentorama.javapro7.models.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {
}

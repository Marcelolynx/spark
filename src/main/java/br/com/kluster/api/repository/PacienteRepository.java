package br.com.kluster.api.repository;

import br.com.kluster.api.model.Paciente;
import br.com.kluster.api.repository.filter.PacienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, PacienteRepositoryQuery {
}

package br.com.kluster.api.repository.filter;



import br.com.kluster.api.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PacienteRepositoryQuery {

    public Page<Paciente> filtrar(PacienteFilter pacienteFilter, Pageable pageable);
}

package br.com.kluster.api.repository;

import br.com.kluster.api.model.Dentista;
import br.com.kluster.api.repository.filter.DentistaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Long>, DentistaRepositoryQuery {
}

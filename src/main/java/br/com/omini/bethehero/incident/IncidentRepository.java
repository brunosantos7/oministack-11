package br.com.omini.bethehero.incident;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Long>{

	List<Incident> findByOngId(Long ongId);

	Iterable<Incident> findAll(Pageable pageable);

}

package br.com.omini.bethehero.incident;

import java.util.Optional;

import javax.management.BadAttributeValueExpException;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.omini.bethehero.ong.Ong;

@RequestMapping("/incident")
@RestController
public class IncidentController {
	
	private IncidentRepository incidentRepository;
	
	public IncidentController(IncidentRepository incidentRepository) {
		super();
		this.incidentRepository = incidentRepository;
	}
	
	@GetMapping
	public Iterable<Incident> getAll(@RequestParam("page") int page){
		
		Pageable pageable =  PageRequest.of((page - 1) * 5, 5);
		return this.incidentRepository.findAll(pageable);
	}

	@PostMapping
	public Long createIncident(@RequestBody IncidentDTO incidentDTO, @RequestHeader("Authorization") Long ongId) {
		incidentDTO.setOngId(ongId);
		return this.incidentRepository.save(incidentDTO.toIncidentEntity()).getId();
	}
	
	@DeleteMapping("/{id}")
	public void deleteIncident(@PathVariable Long id, @RequestHeader("Authorization") Long ongId) throws BadAttributeValueExpException {
		Optional<Incident> incident = this.incidentRepository.findById(id);
		Ong ong = incident.isPresent() ? incident.get().getOng() : new Ong();
		
		if(!ongId.equals(ong.getId())){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "NOT ALLOWED!!");
		}
		
		this.incidentRepository.deleteById(id);
	}
	
}

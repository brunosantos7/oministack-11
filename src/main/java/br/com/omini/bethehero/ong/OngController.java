package br.com.omini.bethehero.ong;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omini.bethehero.incident.Incident;
import br.com.omini.bethehero.incident.IncidentRepository;

@RestController
@RequestMapping("/ong")
public class OngController {
	
	private OngRepository ongRepository;
	private IncidentRepository incidentRepository;
	
	public OngController(OngRepository ongRepository, IncidentRepository incidentRepository) {
		super();
		this.ongRepository = ongRepository;
		this.incidentRepository = incidentRepository;
	}

	@PostMapping
	public Long saveOng(@RequestBody OngDTO ongDTO) {
		return ongRepository.save(ongDTO.toOng()).getId();
	}
	
	@GetMapping
	public Iterable<Ong> getAllOngs(){
		return ongRepository.findAll();
	}
	
	@GetMapping("/{ongId}/incidents")
	public List<Incident> getAIncidentsByOng(@PathVariable Long ongId){
		return incidentRepository.findByOngId(ongId);
	}
}

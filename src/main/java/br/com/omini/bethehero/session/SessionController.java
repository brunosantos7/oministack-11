package br.com.omini.bethehero.session;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.omini.bethehero.ong.Ong;
import br.com.omini.bethehero.ong.OngRepository;

@RequestMapping("/session")
@RestController
public class SessionController {

	private OngRepository ongRepository;
	
	public SessionController(OngRepository ongRepository) {
		super();
		this.ongRepository = ongRepository;
	}

	@PostMapping
	public String createSession(@RequestBody SessionDTO sessionDTO) {
		Optional<Ong> ongOp = ongRepository.findById(sessionDTO.getId());
		
		if(!ongOp.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ong not found.");
		}
		
		Ong ong = ongOp.get();
		return ong.getName();
	}
}

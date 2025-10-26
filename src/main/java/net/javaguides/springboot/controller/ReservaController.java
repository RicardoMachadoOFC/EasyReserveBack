package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.exception.ResourceNotFoundException;

import net.javaguides.springboot.model.Reserva;
import net.javaguides.springboot.repository.ReservaRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {
	
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	
	@GetMapping("/reservas")
	public List<Reserva> getAllReservas(){
		return reservaRepository.findAll();
		
		
	}
	
	@PostMapping("/reservas")
	public List<Reserva> criarReservas(@RequestBody List<Reserva> reserva) {
		return reservaRepository.saveAll(reserva);             
		// post para varios dados JSON
		
	}
	
	@PostMapping("/reserva")
	public Reserva criarReserva(@RequestBody Reserva reserva) {
		return reservaRepository.save(reserva);             
		// post para dado unico JSON
		
	}
	
	@DeleteMapping("/reservas/{id}")
	public ResponseEntity<String> deletarReserva(@PathVariable Long id) {
	    if (!reservaRepository.existsById(id)) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Reserva não encontrada com ID: " + id);
	    }

	    reservaRepository.deleteById(id);
	    return ResponseEntity.ok("Reserva deletada com sucesso!");

    }
	
	
	@PutMapping("/reservas/{id}")
	public Reserva atualizarReserva(@PathVariable Long id, @RequestBody Reserva novaReserva) {
	    Reserva reserva = reservaRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));

	    reserva.setEmail(novaReserva.getEmail());
	    reserva.setNome(novaReserva.getNome());
	    reserva.setHorarioReserva(novaReserva.getHorarioReserva());

	    return reservaRepository.save(reserva);
	}
	}


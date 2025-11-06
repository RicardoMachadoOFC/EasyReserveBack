package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.Reserva;
import net.javaguides.springboot.service.ReservaService;

@RestController
@RequestMapping("/api/v1/reservas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // GET - Listar todas as reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        return ResponseEntity.ok(reservaService.getAllReservas());
    }

    //  buscar reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reservaService.getReservaById(id));
    }

    // criar uma reserva unica
    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.criarReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
    }

    // POST - criar varias reservas de uma vez
    @PostMapping("/multiplas")
    public ResponseEntity<List<Reserva>> criarReservas(@RequestBody List<Reserva> reservas) {
        List<Reserva> novasReservas = reservaService.criarReservas(reservas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novasReservas);
    }

    //  atualizar reserva existente
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable("id") Long id, @RequestBody Reserva reservaAtualizada) {
        Reserva reserva = reservaService.atualizarReserva(id, reservaAtualizada);
        return ResponseEntity.ok(reserva);
    }

    // deletar reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarReserva(@PathVariable("id") Long id) {
        reservaService.deletarReserva(id);
        return ResponseEntity.ok("Reserva deletada com sucesso!");
    }

}

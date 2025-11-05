package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Reserva;
import net.javaguides.springboot.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Listar todas as reservas
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Buscar reserva por ID
    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrada com ID: " + id));
    }

    // Criar uma reserva
    public Reserva criarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Criar várias reservas
    public List<Reserva> criarReservas(List<Reserva> reservas) {
        return reservaRepository.saveAll(reservas);
    }

    // Atualizar uma reserva
    public Reserva atualizarReserva(Long id, Reserva novaReserva) {
        Reserva reserva = getReservaById(id);

        reserva.setNome(novaReserva.getNome());
        reserva.setEmail(novaReserva.getEmail());
        reserva.setHorarioReserva(novaReserva.getHorarioReserva());

        return reservaRepository.save(reserva);
    }

    // Deletar uma reserva
    public void deletarReserva(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reserva não encontrada com ID: " + id);
        }
        reservaRepository.deleteById(id);
    }
}

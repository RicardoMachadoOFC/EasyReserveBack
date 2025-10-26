package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Reserva;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}

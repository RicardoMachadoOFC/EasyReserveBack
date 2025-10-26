package net.javaguides.springboot.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "Nome")
	private String Nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "horario_reserva")
	@JsonProperty("horarioReserva")
    private LocalDateTime horarioReserva;
	
	public Reserva() {
		
	}
	
	public Reserva(String nome, String email, LocalDateTime horarioReserva) {
		super();
		Nome = nome;
		this.email = email;
		this.horarioReserva = horarioReserva;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	 public LocalDateTime getHorarioReserva() {
	        return horarioReserva;
	    }
	    public void setHorarioReserva(LocalDateTime horarioReserva) {
	        this.horarioReserva = horarioReserva;
	    }
	
	

}

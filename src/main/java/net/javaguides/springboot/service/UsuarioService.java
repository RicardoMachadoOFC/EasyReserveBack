package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Reserva;
import net.javaguides.springboot.model.Usuario;
import net.javaguides.springboot.repository.UsuarioRepository;
import java.util.Optional;
import net.javaguides.springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	
		// autenticar login 
	  public boolean autenticar(String email, String senha) {
	        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
	        return usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(senha);
	    }
	  // apagar registro de Login
	 public void deletarUsuario(Long id) {
		 if(!usuarioRepository.existsById(id)) {
			 throw new RuntimeException("Usuário não encontrado com ID: " + id);
		 }
		 usuarioRepository.deleteById(id);
	 }
	 
	// Buscar reserva por ID
	    public Usuario getUsuarioById(Long id) {
	        return usuarioRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrada com ID: " + id));
	    }
	 
	}


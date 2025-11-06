package net.javaguides.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Usuario;
import net.javaguides.springboot.repository.UsuarioRepository;
import java.util.Optional;
import net.javaguides.springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	public UsuarioRepository usuarioRepository;

	  public boolean autenticar(String email, String senha) {
	        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
	        return usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(senha);
	    }
	}


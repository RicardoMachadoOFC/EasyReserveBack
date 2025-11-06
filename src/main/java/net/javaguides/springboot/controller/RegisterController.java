package net.javaguides.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.javaguides.springboot.model.Role;

import net.javaguides.springboot.dto.LoginRequest;
import net.javaguides.springboot.dto.RegisterRequest;
import net.javaguides.springboot.model.Usuario;
import net.javaguides.springboot.service.UsuarioService;



@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")

public class RegisterController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());
        usuario.setRole(Role.valueOf(request.getRole().toUpperCase()));

        usuarioService.usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

}

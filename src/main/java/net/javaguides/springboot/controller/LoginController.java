package net.javaguides.springboot.controller;


import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.javaguides.springboot.model.Role;

import net.javaguides.springboot.dto.LoginRequest;
import net.javaguides.springboot.dto.RegisterRequest;
import net.javaguides.springboot.model.Usuario;
import net.javaguides.springboot.service.UsuarioService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean ok = usuarioService.autenticar(request.getEmail(), request.getSenha());
        if (ok) {
            return ResponseEntity.ok("Login aprovado!");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
        
        
    }
     @GetMapping("/login")
     public ResponseEntity<java.util.List<Usuario>> listarUsarios(){
    	List<Usuario> 
    	 
     }
    
    
}
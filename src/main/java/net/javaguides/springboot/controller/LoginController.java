package net.javaguides.springboot.controller;


import java.util.List;

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
     public ResponseEntity<List<Usuario>> listarUsuarios() {
    	    List<Usuario> usuarios = usuarioService.usuarioRepository.findAll();
    	    return ResponseEntity.ok(usuarios);
    
    
}
     @PutMapping("/login/{id}")
     public ResponseEntity<String> atualizarUsuario(@PathVariable("id") Long id, @RequestBody RegisterRequest request) {
         return usuarioService.usuarioRepository.findById(id)
             .map(usuario -> {
                 usuario.setEmail(request.getEmail());
                 usuario.setSenha(request.getSenha());
                 usuario.setRole(Role.valueOf(request.getRole().toUpperCase()));
                 usuarioService.usuarioRepository.save(usuario);
                 return ResponseEntity.ok("Usuário atualizado com sucesso!");
             })
             .orElse(ResponseEntity.status(404).body("Usuário não encontrado"));
     }
     @DeleteMapping("/login/{id}")
     public ResponseEntity<String> deletarUsuario(@PathVariable("id") Long id) {
         usuarioService.deletarUsuario(id);
         return ResponseEntity.ok("usuario deletado");
     }
     

}
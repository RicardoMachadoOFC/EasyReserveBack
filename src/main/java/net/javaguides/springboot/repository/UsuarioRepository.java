package net.javaguides.springboot.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.springboot.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}

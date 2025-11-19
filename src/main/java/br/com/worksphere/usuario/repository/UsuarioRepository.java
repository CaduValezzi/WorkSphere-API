package br.com.worksphere.usuario.repository;

import br.com.worksphere.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmailValor(String email);

    boolean existsByEmailValor(String email);
}

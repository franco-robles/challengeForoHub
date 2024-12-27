package challenge.alura.challengeforohub.repository;

import challenge.alura.challengeforohub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

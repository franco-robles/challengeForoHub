package challenge.alura.challengeforohub.model.usuario;

import challenge.alura.challengeforohub.dto.UsuarioDto;
import challenge.alura.challengeforohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseEntity<Usuario> registrar(UsuarioDto datosUsuario) {
        Usuario usuario = new Usuario(datosUsuario, passwordEncoder);
        return  ResponseEntity.ok().body(usuarioRepository.save(usuario)) ;
    }


}

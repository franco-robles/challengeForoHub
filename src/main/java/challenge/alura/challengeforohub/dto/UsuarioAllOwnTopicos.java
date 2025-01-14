package challenge.alura.challengeforohub.dto;

import challenge.alura.challengeforohub.model.Topico;
import challenge.alura.challengeforohub.model.usuario.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UsuarioAllOwnTopicos(@NotBlank String nombre,
                                   @Email String email,
                                   List<TopicoBasicDto> topicos){
    public UsuarioAllOwnTopicos (Usuario user){
        this (user.getEmail(),
                user.getNombre(),
                user.getTopicos());
    }
}

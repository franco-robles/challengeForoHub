package challenge.alura.challengeforohub.dto;

import challenge.alura.challengeforohub.model.usuario.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioBasicDTO(@NotBlank String nombre,
                              @Email String email ){
    public UsuarioBasicDTO(Usuario user){
        this (user.getEmail(),
                user.getNombre() );
    }
}

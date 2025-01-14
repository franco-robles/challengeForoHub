package challenge.alura.challengeforohub.dto;

import challenge.alura.challengeforohub.model.usuario.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto (@NotBlank String nombre,
                          @Email  String email,
                          @NotBlank String password){
    public UsuarioDto (Usuario user){
        this (user.getEmail(),
                user.getNombre(),
                user.getPassword());
    }
}

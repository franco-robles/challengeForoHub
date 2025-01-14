package challenge.alura.challengeforohub.controller;

import challenge.alura.challengeforohub.dto.UsuarioAllOwnTopicos;
import challenge.alura.challengeforohub.dto.UsuarioDto;
import challenge.alura.challengeforohub.exception.ValidacionDeIntegridad;
import challenge.alura.challengeforohub.model.usuario.Usuario;
import challenge.alura.challengeforohub.model.usuario.UsuarioService;
import challenge.alura.challengeforohub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository userRepo;
    @Autowired
    UsuarioService userService;

    @PostMapping("/newUser")
    public ResponseEntity<Usuario> newUser(@RequestBody @Valid UsuarioDto user){
        return  userService.registrar(user);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioAllOwnTopicos> usuarioConTopicos(@PathVariable Long id){
        if (userRepo.findById(id).isEmpty()) {
        throw new ValidacionDeIntegridad("Usuario no encontrado");
    }

        return  ResponseEntity.ok(new UsuarioAllOwnTopicos(userRepo.getReferenceById(id)));
    }


}

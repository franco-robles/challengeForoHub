package challenge.alura.challengeforohub.controller;

import challenge.alura.challengeforohub.dto.TopicoDto;
import challenge.alura.challengeforohub.dto.TopicoNew;
import challenge.alura.challengeforohub.exception.ValidacionDeIntegridad;
import challenge.alura.challengeforohub.model.Topico;
import challenge.alura.challengeforohub.repository.TopicoRepository;
import challenge.alura.challengeforohub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoRepository repo;
    @Autowired
    private UsuarioRepository userRepo;


    @PostMapping("/addTopico")
    public ResponseEntity<Topico> nuevoTopico(@RequestBody @Valid TopicoNew tdto){
        Topico topico = new Topico(tdto, userRepo.getReferenceById(tdto.id()));
        return ResponseEntity.ok(repo.save(topico));
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<TopicoDto>> obtenerTopicos(){
        return ResponseEntity.ok().body(repo.findAll().stream().map(TopicoDto::new).toList()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> verTopico(@PathVariable Long id){
        if (repo.findById(id).isEmpty()) {
            throw new ValidacionDeIntegridad("Topico no encontrado");
        }
        TopicoDto tdo =  new TopicoDto(repo.getReferenceById(id));
        return ResponseEntity.ok().body(tdo);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<TopicoDto> actualizarTopico(@RequestBody @Valid Topico topico){
        Optional<Topico> topicoOp = repo.findById(topico.getId());
        if (topicoOp.isPresent()){
            topicoOp.get().actuaizarTopico(topico);
            System.out.println("topico actualizado");
            return  ResponseEntity.ok(new TopicoDto(topicoOp.get()));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopico(@PathVariable Long id){
        var optionalTopico = repo.findById(id);
        if (optionalTopico.isEmpty()) {
            throw new ValidacionDeIntegridad("Topico no encontrado");
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build() ;
    }

}


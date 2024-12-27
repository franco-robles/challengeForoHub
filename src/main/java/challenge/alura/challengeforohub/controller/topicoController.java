package challenge.alura.challengeforohub.controller;

import challenge.alura.challengeforohub.dto.TopicoDto;
import challenge.alura.challengeforohub.model.Topico;
import challenge.alura.challengeforohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topico")
public class topicoController {
    @Autowired
    private TopicoRepository repo;

    @GetMapping
    public String holamundo(){
        return "Hola Mundo";
    }

    @PostMapping("/ola")
    public String nuevoTopico(@RequestBody TopicoDto tdto){
        Topico topico = new Topico(tdto);
        repo.save(topico);
        return "hola";
    }

    @GetMapping("/all")
    public List<TopicoDto> obtenerTopicos(){
        return repo.findAll().stream().map(TopicoDto::new).toList() ;
    }

    @GetMapping("/{id}")
    public TopicoDto verTopico(@PathVariable Long id){
        TopicoDto tdo =  new TopicoDto(repo.getReferenceById(id));
        return tdo;
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<TopicoDto> actualizarTopico(@RequestBody Topico topico){
        Optional<Topico> topicoOp = repo.findById(topico.getId());
        if (topicoOp.isPresent()){
            topicoOp.get().actuaizarTopico(topico);
            System.out.println("a huevo se actualizó");
            return  ResponseEntity.ok(new TopicoDto(topicoOp.get()));
        }else{
            System.out.println("mamaste verga wey");
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> deleteTopico(@PathVariable Long id){
        repo.deleteById(id);
        return ResponseEntity.ok().build() ;
    }

}


package challenge.alura.challengeforohub.model;

import challenge.alura.challengeforohub.dto.TopicoDto;
import challenge.alura.challengeforohub.dto.TopicoNew;
import challenge.alura.challengeforohub.dto.UsuarioBasicDTO;
import challenge.alura.challengeforohub.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;


import java.time.LocalDateTime;


@Entity
@Table(name = "topicos")
@AllArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(unique = true)
    String titulo;
    @Column(unique = true)
    String mensaje;
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime fecha_creacion;
    String status;
    String curso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    //contructor a partir de un dto
    public Topico(TopicoDto topico){
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        this.fecha_creacion = LocalDateTime.now();
        this.autor = new Usuario();
    }

    public Topico(TopicoNew topico, Usuario user){
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        this.fecha_creacion = LocalDateTime.now();
        this.autor = user;
    }

    public Topico(){

    }


    //methods

    public void actuaizarTopico(Topico topico) {
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
        this.fecha_creacion = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", status='" + status + '\'' +
                ", curso='" + curso + '\'' +
                ", autor=" + autor +
                '}';
    }

    //setter and getters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioBasicDTO getAutor() {
        return new UsuarioBasicDTO(autor);
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}






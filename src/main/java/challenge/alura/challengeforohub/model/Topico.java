package challenge.alura.challengeforohub.model;

import challenge.alura.challengeforohub.dto.TopicoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;


import java.util.Date;

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
    Date fecha_creacion;
    String status;
    String curso;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    //contructor a partir de un dto
    public Topico(TopicoDto topico){
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();

    }

    public Topico(){

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

    //getter and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void actuaizarTopico(Topico topico) {
        this.titulo = topico.getTitulo();
        this.mensaje = topico.getMensaje();
    }
}

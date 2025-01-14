package challenge.alura.challengeforohub.model.usuario;

import challenge.alura.challengeforohub.dto.TopicoBasicDto;

import challenge.alura.challengeforohub.dto.UsuarioDto;
import challenge.alura.challengeforohub.model.Topico;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String nombre;
    @Column(unique = true)
    String email;
    String password;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Topico> topicos;

    //constructor
    public Usuario(){

    }

    public Usuario(UsuarioDto datosUsuario, PasswordEncoder passwordEncoder) {
        this.nombre = datosUsuario.nombre();
        this.email = datosUsuario.email();
        this.password = passwordEncoder.encode(datosUsuario.password());
    }

    //getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TopicoBasicDto> getTopicos() {
        return topicos.stream().map(TopicoBasicDto::new).toList();
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
}

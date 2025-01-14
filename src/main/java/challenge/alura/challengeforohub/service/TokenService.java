package challenge.alura.challengeforohub.service;
import challenge.alura.challengeforohub.model.usuario.Usuario;
import com.auth0.jwt.JWTVerifier;
import org.springframework.stereotype.Service;
import java.time.*;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.temporal.ChronoUnit;


@Service
public class TokenService {


    private String apiSecret = "123456";

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("foro hub")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al crear el token: " + exception.getMessage());
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            return null; // Devuelve null en lugar de lanzar una excepción
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("foro hub")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token); // Guarda el resultado de la verificación
            return decodedJWT.getSubject(); // Retorna el subject del token decodificado
        } catch (JWTVerificationException exception) {
            System.out.println("Error al verificar el token: " + exception.getMessage()); // para imprimir el mensaje de error
            return null;
        }
    }

    private Instant generarFechaExpiracion() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault()).plus(2, ChronoUnit.HOURS);
        return zonedDateTime.toInstant();
    }

}
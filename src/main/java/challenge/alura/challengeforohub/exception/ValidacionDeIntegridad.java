package challenge.alura.challengeforohub.exception;

import org.springframework.http.HttpStatus;

public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String string) {
        super(string);
    }
}

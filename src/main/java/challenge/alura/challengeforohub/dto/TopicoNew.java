package challenge.alura.challengeforohub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoNew(@NotBlank String titulo,
                        @NotBlank String mensaje,
                        @NotNull Long id) {
}

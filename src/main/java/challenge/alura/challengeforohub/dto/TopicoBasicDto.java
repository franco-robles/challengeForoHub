package challenge.alura.challengeforohub.dto;

import challenge.alura.challengeforohub.model.Topico;

public record TopicoBasicDto(String titulo,
                             String mensaje) {
    public TopicoBasicDto(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje());
    }


}

package challenge.alura.challengeforohub.dto;

import challenge.alura.challengeforohub.model.Topico;

public record TopicoDto (
        String titulo,
        String mensaje,
        UsuarioBasicDTO autor){
        public TopicoDto(Topico topico) {
                this(topico.getTitulo(), topico.getMensaje(), topico.getAutor());
        }

}

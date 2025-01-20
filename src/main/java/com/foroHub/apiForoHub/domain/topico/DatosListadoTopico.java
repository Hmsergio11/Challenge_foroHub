package com.foroHub.apiForoHub.domain.topico;

public record DatosListadoTopico(
        Long id,
        String mensaje,
        String nombreDelCurso,
        String titulo
) {

    public DatosListadoTopico (Topico topico){
        this(topico.getId(), topico.getMensaje(), topico.getNombreDelCurso(), topico.getTitulo());
    }
}

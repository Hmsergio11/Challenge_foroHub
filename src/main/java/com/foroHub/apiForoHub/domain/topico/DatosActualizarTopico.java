package com.foroHub.apiForoHub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String mensaje,
        String nombreDelCurso,
        String titulo

) {
}

package com.foroHub.apiForoHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(@NotBlank @NotNull
                                  String idDelUsuario,
                                  @NotBlank @NotNull
                                  String mensaje,
                                  @NotBlank @NotNull
                                  String nombreDelCurso,
                                  @NotBlank @NotNull
                                  String titulo) {
}

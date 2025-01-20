package com.foroHub.apiForoHub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idDelUsuario;
    private String mensaje;
    private String nombreDelCurso;
    private String titulo;
    private Boolean activo;

    public Topico() {
    }

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.idDelUsuario = datosRegistroTopico.idDelUsuario();
        this.mensaje = datosRegistroTopico.mensaje();
        this.nombreDelCurso = datosRegistroTopico.nombreDelCurso();
        this.titulo = datosRegistroTopico.titulo();
        this.activo = true;

    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.nombreDelCurso() != null) {
        this.nombreDelCurso = datosActualizarTopico.nombreDelCurso();
        }
        if(datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdDelUsuario() {
        return idDelUsuario;
    }

    public void setIdDelUsuario(String idDelUsuario) {
        this.idDelUsuario = idDelUsuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreDelCurso() {
        return nombreDelCurso;
    }

    public void setNombreDelCurso(String nombreDelCurso) {
        this.nombreDelCurso = nombreDelCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

package com.eschool.schoolpage.dtos;

import com.eschool.schoolpage.models.Comentario;
import com.eschool.schoolpage.models.Respuesta;

import java.time.LocalDateTime;

public class RespuestaDTO {
    private Long id;
    private boolean isAsset;
    private String texto;
    private LocalDateTime fecha;
    private String nombreUsuario;
    private String respuestaPara;
    private Long usuarioId;
    private String nombreDeMateria;
    private String nombreDeContenido;
    private String profileImgFromUserAnswer;

    public RespuestaDTO(Respuesta respuesta) {
        this.id = respuesta.getId();
        this.isAsset = respuesta.isAsset();
        this.texto = respuesta.getTexto();
        this.fecha = respuesta.getFecha();
        this.nombreDeMateria = respuesta.getComentario().getContenido().getMateria().getNombre();
        this.nombreDeContenido = respuesta.getComentario().getContenido().getTitulo();
        this.nombreUsuario = respuesta.getUsuario().getName() + " " + respuesta.getUsuario().getLastName();
        this.profileImgFromUserAnswer = respuesta.getUsuario().getProfileUserImage();
        this.usuarioId = respuesta.getUsuario().getId();
        //this.respuestaPara  = respuesta.getComentario().getUsuario().getName() + " " + respuesta.getComentario().getUsuario().getLastName();
        this.respuestaPara  = respuesta.getRespuestaPara();
    }


    public Long getId() {
        return id;
    }

    public boolean isAsset() {
        return isAsset;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getRespuestaPara() {
        return respuestaPara;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getNombreDeMateria() {
        return nombreDeMateria;
    }

    public String getNombreDeContenido() {
        return nombreDeContenido;
    }

    public String getProfileImgFromUserAnswer() {
        return profileImgFromUserAnswer;
    }
}

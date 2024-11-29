package com.eschool.schoolpage.dtos;

import com.eschool.schoolpage.models.Rol;
import com.eschool.schoolpage.models.Usuario;
import com.eschool.schoolpage.models.UsuarioMateria;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {
    private Long id;
    private String name;
    private String lastName;
    private String mail;
    private String DNI;
    private boolean asset = true; // "Activo"
    private Rol rol;
    private boolean estaEnUnaMateria = false;
    private List<UsuarioMateriaDTO> usuarioMaterias = new ArrayList<>();
    private List<ComentarioDTO> comentarioDTOS = new ArrayList<>();
    private List<RespuestaDTO> respuestaDTOS = new ArrayList<>();

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.lastName = usuario.getLastName();
        this.mail = usuario.getMail();
        this.DNI= usuario.getDNI();
        this.asset = usuario.isAsset();
        this.rol = usuario.getRol();
        this.estaEnUnaMateria = usuario.isEstaEnUnaMateria();
        this.usuarioMaterias = usuario.getUsuarioMaterias().stream().filter(usuarioMateria -> usuarioMateria.isAsset())
                .map(usuarioMateria -> new UsuarioMateriaDTO(usuarioMateria)).collect(Collectors.toList());
        this.comentarioDTOS = usuario.getComentarios().stream().filter(comentario -> comentario.isAsset())
                .map(comentario -> new ComentarioDTO(comentario)).collect(Collectors.toList());
        this.respuestaDTOS = usuario.getRespuestas().stream().filter(respuesta -> respuesta.isAsset())
                .map(respuesta -> new RespuestaDTO(respuesta)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getDNI() {
        return DNI;
    }

    public boolean isAsset() {
        return asset;
    }

    public List<UsuarioMateriaDTO> getUsuarioMaterias() {
        return usuarioMaterias;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean isEstaEnUnaMateria() {
        return estaEnUnaMateria;
    }

    public List<ComentarioDTO> getComentarioDTOS() {
        return comentarioDTOS;
    }

    public List<RespuestaDTO> getRespuestaDTOS() {
        return respuestaDTOS;
    }
}

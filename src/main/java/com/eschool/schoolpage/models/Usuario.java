package com.eschool.schoolpage.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String mail;
    private String DNI;
    private String password;
    private boolean asset = true; // "Activo"
    private Rol rol;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<UsuarioMateria> usuarioMaterias = new ArrayList<>();


    //----------------------------Métodos Constructor------------------------------------
    public Usuario() { }

    public Usuario(String name, String lastName, String DNI, String mail, String password, Rol rol) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.mail = mail;
        this.password = password;
        this.rol = rol;
    }
    //--------------------------------------------------------------------------------------



    //----------------------------Métodos GETTER Y SETTER------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAsset() {
        return asset;
    }

    public void setAsset(boolean asset) {
        this.asset = asset;
    }

    public Long getId() {
        return id;
    }


    public List<UsuarioMateria> getUsuarioMaterias() {
        return usuarioMaterias;
    }

    public void setUsuarioMaterias(List<UsuarioMateria> usuarioMaterias) {
        this.usuarioMaterias = usuarioMaterias;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    //--------------------------------------------------------------------------------------

    public void addUsuarioMateria(UsuarioMateria usuarioMateria){
        this.usuarioMaterias.add(usuarioMateria);
        usuarioMateria.setUsuario(this);
    }


}

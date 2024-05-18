package com.iudigital.crud.domain;

public class GrupoFamiliar extends Funcionario {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String rol;

    public GrupoFamiliar() {
    }

    public GrupoFamiliar(int id, String nombre, String apellidos, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "GrupoFamiliar{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", rol=" + rol + '}';
    }
    
    
    
}

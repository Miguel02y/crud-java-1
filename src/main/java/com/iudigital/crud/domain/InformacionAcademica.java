 package com.iudigital.crud.domain;

public class InformacionAcademica extends Funcionario {
    
    
    
    private int id;
    private String universidad;
    private String nivelestudio;
    private String tituloestudio;

    public InformacionAcademica() {
    }

    public InformacionAcademica(int id, String universidad, String nivelestudio, String tituloestudio) {
        this.id = id;
        this.universidad = universidad;
        this.nivelestudio = nivelestudio;
        this.tituloestudio = tituloestudio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getNivelestudio() {
        return nivelestudio;
    }

    public void setNivelestudio(String nivelestudio) {
        this.nivelestudio = nivelestudio;
    }

    public String getTituloestudio() {
        return tituloestudio;
    }

    public void setTituloestudio(String tituloestudio) {
        this.tituloestudio = tituloestudio;
    }

    @Override
    public String toString() {
        return "informaccionacademica{" + "id=" + id + ", universidad=" + universidad + ", nivelestudio=" + nivelestudio + ", tituloestudio=" + tituloestudio + '}';
    }

       
    
    
}


    


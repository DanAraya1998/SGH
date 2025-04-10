package com.mycompany.proyecto_final;

public abstract class Persona {

    private int identificacion;
    private String nombre;

    public Persona(int identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }
    
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    public Persona(int identificacion) {
        this.identificacion = identificacion;
    }
    

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public abstract String agregarUsuario();

    public abstract String eliminarUsuario();

    public abstract String buscarUsuario();
    
    public abstract String actualizarUsuario();

}

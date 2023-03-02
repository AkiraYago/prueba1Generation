package com.generation.evaluacion_java.models;

public class Usuario {
    public String nombre;
    public char sexo;
    private String contraseña;
    public Integer rut;
    public Usuario() {
    }
    public Usuario(String nombre, char sexo, String contraseña, Integer rut) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.contraseña = contraseña;
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public Integer getRut() {
        return rut;
    }
    public void setRut(Integer rut) {
        this.rut = rut;
    }
    @Override
    public String toString() {
        return "\nUsuario [nombre=" + nombre + ", sexo=" + sexo + ", rut=" + rut + "]";
    }

    
    
}

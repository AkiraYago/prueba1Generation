package com.generation.evaluacion_java.models;

import java.util.ArrayList;

public class Alumno extends Usuario{
    public ArrayList<Double> listaNotas = new ArrayList<Double>();
    public Double promedio;
    public Alumno() {
        super();
    }
    public Alumno(String nombre, char sexo, String contraseña, Integer rut, ArrayList<Double> listaNotas,
            Double promedio) {
        super(nombre, sexo, contraseña, rut);
        this.listaNotas = listaNotas;
        this.promedio = promedio;
    }
    public ArrayList<Double> getListaNotas() {
        return listaNotas;
    }
    public void setListaNotas(ArrayList<Double> listaNotas) {
        this.listaNotas = listaNotas;
    }
    public Double getPromedio() {
        return promedio;
    }
    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return super.toString() + "Alumno [listaNotas=" + listaNotas + ", promedio=" + promedio + "]";
    }
    
    
}

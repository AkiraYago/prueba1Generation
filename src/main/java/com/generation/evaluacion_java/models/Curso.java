package com.generation.evaluacion_java.models;

import java.util.ArrayList;

public class Curso {
    public String nivel;
    public Profesor profesorJefe;
    public ArrayList<Alumno> listaAlumnos;
    public ArrayList<String> materias;
    public Double promedioGeneral;

    public Curso() {
    }

    public Curso(String nivel, Profesor profesorJefe, ArrayList<Alumno> listaAlumnos) {
        this.nivel = nivel;
        this.profesorJefe = profesorJefe;
        this.listaAlumnos = listaAlumnos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Profesor getProfesorJefe() {
        return profesorJefe;
    }

    public void setProfesorJefe(Profesor profesorJefe) {
        this.profesorJefe = profesorJefe;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }

    public Double getPromedioGeneral() {
        return promedioGeneral;
    }

    public void setPromedioGeneral(Double promedioGeneral) {
        this.promedioGeneral = promedioGeneral;
    }

    @Override
    public String toString() {
        return "\n[Curso]\n \n\nNivel: \n" + nivel + "\n\nProfesor Jefe: " + profesorJefe + "\n\nLista de Alumnos: " + listaAlumnos
                + "\n\nMaterias: " + materias + "\n\nPromedio General: " + promedioGeneral;
    }
    
    
}

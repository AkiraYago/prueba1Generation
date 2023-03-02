package com.generation.evaluacion_java.models;

public class Profesor extends Usuario{
    public String materiaPrincipal;

    public Profesor(){
        super();
    }

    public Profesor(String nombre, char sexo, String contraseña, Integer rut, String materiaPrincipal) {
        super(nombre, sexo, contraseña, rut);
        this.materiaPrincipal = materiaPrincipal;
    }

    public String getMateriaPrincipal() {
        return materiaPrincipal;
    }

    public void setMateriaPrincipal(String materiaPrincipal) {
        this.materiaPrincipal = materiaPrincipal;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesor [materiaPrincipal=" + materiaPrincipal + "]";
    }
    
    
}

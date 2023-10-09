package com.neyser;

public class Escritor {
    private String nombre;
    private String fechaNacimineto;
    private String nacionalidad;

    public Escritor() {
    }

    public Escritor(String nombre, String fechaNacimineto, String nacionalidad) {
        this.nombre = nombre;
        this.fechaNacimineto = fechaNacimineto;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(String fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}

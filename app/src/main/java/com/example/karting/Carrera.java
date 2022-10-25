package com.example.karting;

public class Carrera {
    private String nombre;
    private String dia;
    public Carrera(){};
    public Carrera(String nombre, String carrera){
        this.setDia(getDia());
        this.setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}

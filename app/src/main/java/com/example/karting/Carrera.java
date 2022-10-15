package com.example.karting;

public class Carrera {
    private String Nombre;
    private String dia;
    public Carrera(){};
    public Carrera(String Nombre, String carrera){
        this.setDia(getDia());
        this.setNombre(Nombre);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}

package com.example.karting;

public class Usuario {
    private String Nombre;
    private String Apellido;
    private String Ubicacion;
    private String Nick;
    //constructor vacio
    public Usuario(){

    }
    //Constructor lleno
    public Usuario(String nombre,String apellido,String ubicacion,String nick){

        this.setApellido(apellido);
        this.setNick(nick);
        this.setNombre(nombre);
        this.setUbicacion(ubicacion);


    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.Ubicacion = ubicacion;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String nick) {
        this.Nick = nick;
    }
}

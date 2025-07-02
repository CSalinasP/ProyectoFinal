package org.Lógica;
/*
Clase para crear al organizador del torneo
@author ignacio
*/
public class Organizador {
    private String nombre;
    private String apellido;
    private String telefono;
    public Organizador(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
//**********************************************************
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }
    @Override
    public String toString() {
        return "Organizador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

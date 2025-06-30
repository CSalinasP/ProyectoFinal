package org.example;

public class Jugador {
    private String nombre;
    private int edad;
    private int altura;
    private int peso;
    private String categoria;
    private Equipo equipo;

    public Jugador(String nombre, int edad, int altura, int peso, String categoria) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.categoria = categoria;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                ", peso=" + peso +
                ", categoria='" + categoria + '\'' +
                ", equipo=" + (equipo != null ? equipo.getNombreEquipo() : "sin equipo") +
                '}';
    }
}
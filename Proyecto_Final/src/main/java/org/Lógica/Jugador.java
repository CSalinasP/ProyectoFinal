package org.Lógica;

public class Jugador implements competidor{
    /*
    Datos basico de los participantes
     */
    private String nombre;
    private int edad;
    private String categoria;
    private Equipo equipo;

    public Jugador(String nombre, int edad, int altura, int peso, String categoria) {
        this.nombre = nombre;
        this.edad = edad;
        this.categoria = categoria;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
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
                ", categoria='" + categoria + '\'' +
                ", equipo=" + (equipo != null ? equipo.getNombreEquipo() : "sin equipo") +
                '}';
    }
}


package org.LogicaJuego;

/**
 * Clase que usa el patrón Factory para fabricar personajes
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-05
 */

public class FabricaPersonajes {

    public FabricaPersonajes(){
    }

    /**
     * Metodo que crea un Personaje con sus caracteristicas y los retorna
     *
     * @param Nombre El nombre del Personaje
     * @param Vida La cantidad de vida del Personaje
     * @param Resistencia La resistencia al daño del Personaje
     * @param Regeneracion La cantidad de regeneracion de vida del Personaje en cada turno
     */
    static Personaje crearPersonaje(String Nombre, int Vida, int Resistencia, int Regeneracion){
        return new Personaje(Nombre, Vida, Resistencia, Regeneracion);
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes";
    }
}

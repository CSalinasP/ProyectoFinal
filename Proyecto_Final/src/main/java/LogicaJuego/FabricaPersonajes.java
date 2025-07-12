package LogicaJuego;

import LogicaTorneo.*;

/**
 * Clase que usa el patrón Factory para fabricar personajes
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-05
 */

/**
 * Metodo que crea un Personaje con sus caracteristicas y los retorna
 */
public class FabricaPersonajes {
    public FabricaPersonajes(){}

    public static Personaje crearPersonaje(TipoPersonaje tipoPersonaje){
        switch (tipoPersonaje) {
            case HUMANO:
                return new Personaje_Humano();
            case CABALLERO:
                return new Personaje_Caballero();
            case CAVERNARIO:
                return new Personaje_Cavernario();
            case NOMUERTO:
                return new Personaje_NoMuerto();
            default: return null;
        }
    }

    public String toString() {
        return "Clase encargada de fabricar personajes";
    }
}
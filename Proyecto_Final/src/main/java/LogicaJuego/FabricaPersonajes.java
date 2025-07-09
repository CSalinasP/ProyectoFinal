package LogicaJuego;

import LogicaTorneo.*;

/**
 * Clase que usa el patrón Factory para fabricar personajes
 * @author CSalinasP
 * @version 1.1
 * @since 2025-07-07
 */

public abstract class FabricaPersonajes {
    public FabricaPersonajes(){}

    /**
     * Metodo que crea un Personaje con sus características y los retorna
     *
     * @param tipoPersonaje El tipo de Personaje que se desea crear
     * @param Nivel El nivel del Personaje que se desea crear
     * Dependiendo del tipo de Personaje, se usa su fábrica respectivamente
     */
    public static Personaje crearPersonaje(TipoPersonaje tipoPersonaje, int Nivel){
        switch (tipoPersonaje) {
            case HUMANO:
                return FabricaHumanos.crearPersonaje(Nivel);
            case CABALLERO:
                return FabricaCaballeros.crearPersonaje(Nivel);
            case CAVERNARIO:
                return FabricaCavernarios.crearPersonaje(Nivel);
            case NOMUERTO:
                return FabricaNoMuertos.crearPersonaje(Nivel);
            default: return null;
        }
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes";
    }
}

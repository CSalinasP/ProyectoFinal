package LogicaJuego;

import LogicaTorneo.*;

/**
 * Clase que usa el patrón Factory para fabricar personajes.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */

public abstract class FabricaPersonajes {
    public FabricaPersonajes(){}

    /**
     * Metodo que crea un personaje con sus características y lo retorna.
     * Dependiendo del tipo de personaje, se usa su fábrica respectivamente.
     * @param tipoPersonaje El tipo de personaje que se desea crear.
     * @param Nivel El nivel del personaje que se desea.
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
        return "Clase encargada de fabricar personajes.";
    }
}

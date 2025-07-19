package LogicaJuego;

import java.util.ArrayList;

/**
 * Clase que usa el patrón Factory para fabricar las habilidades del Caballero.
 * Crea 3 habilidades, una que solo hace daño, una que solo cura, y una que hace daño y cura a la vez.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */
public class FabricaHabilidadCaballero {
    /** El daño base de la habilidad que solo hace daño. */
    static int damageBase1 = 50;
    /** El daño base de la habilidad que hace daño y cura a la vez. */
    static int damageBase2 = 30;
    /** La curación base de la habilidad que solo cura. */
    static int curacionBase1 = 50;
    /** La curación base de la habilidad que hace daño y cura a la vez. */
    static int curacionBase2 = 30;

    FabricaHabilidadCaballero(){}

    /**
     * Metodo que crea las 3 habilidades del Caballero con los atributos base y los retorna.
     * Los atributos de la habilidad aumentan conforme el nivel del personaje es mayor.
     * @param Nivel El nivel del Caballero al que se le están creando las habilidades.
     */
    public static ArrayList<Habilidad> crearHabilidades(int Nivel){
        ArrayList<Habilidad> auxLista = new ArrayList<Habilidad>();
        auxLista.add(new Habilidad(
                "Ataque con espada",
                damageBase1+5*Nivel,
                0));
        auxLista.add(new Habilidad(
                "Ataque con escudo",
                damageBase2+5*Nivel,
                curacionBase2+5*Nivel));
        auxLista.add(new Habilidad(
                "Recuperacion",
                0,
                curacionBase1+5*Nivel));

        return auxLista;
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar las habilidades del Caballero.";
    }
}

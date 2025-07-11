package LogicaJuego;

import java.util.ArrayList;

/**
 * Clase que usa el patrón Factory para fabricar las habilidades del Humano.
 * Crea 3 habilidades, una que solo hace daño, una que solo cura, y una que hace daño y cura a la vez.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */
public class FabricaHabilidadHumano {
    /** El daño base de la habilidad que solo hace daño. */
    static int damageBase1 = 70;
    /** El daño base de la habilidad que hace daño y cura a la vez. */
    static int damageBase2 = 20;
    /** La curación base de la habilidad que solo cura. */
    static int curacionBase1 = 40;
    /** La curación base de la habilidad que hace daño y cura a la vez. */
    static int curacionBase2 = 15;

    FabricaHabilidadHumano(){}

    /**
     * Metodo que crea las 3 habilidades del Humano con los atributos base y los retorna.
     * Los atributos de la habilidad aumentan conforme el nivel del personaje es mayor.
     * @param Nivel El nivel del Humano al que se le están creando las habilidades.
     */
    public static ArrayList<Habilidad> crearHabilidades(int Nivel){
        ArrayList<Habilidad> auxLista = new ArrayList<Habilidad>();
        auxLista.add(new Habilidad(
                "Ataque con los puños",
                damageBase1+5*Nivel,
                0));
        auxLista.add(new Habilidad(
                "Patada",
                damageBase2+5*Nivel,
                curacionBase2+5*Nivel));
        auxLista.add(new Habilidad(
                "Meditacion",
                0,
                curacionBase1+5*Nivel));

        return auxLista;
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar las habilidades del Humano.";
    }
}

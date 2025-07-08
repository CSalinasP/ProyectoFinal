package LogicaJuego;

/**
 * Clase que usa el patrón Factory para fabricar personajes tipo No Muerto
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-07
 */
public class FabricaNoMuertos {
    /** El nombre de todos los Personajes tipo No Muerto */
    private static String nombre = "No Muerto";
    /** La vida base de todos los Personajes tipo No Muerto */
    private static int vidaBase = 70;
    /** La resistencia base de todos los Personajes tipo No Muerto */
    private static int resistenciaBase = 70;
    /** La regeneración base de todos los Personajes tipo No Muerto */
    private static int regeneracionBase = 5;

    public FabricaNoMuertos(){}

    /**
     * Metodo que crea un Personaje con los atributos base del No Muerto y lo retorna
     *
     * @param Nivel El nivel del No Muerto que se desea crear
     * Los atributos del No Muerto aumentan conforme más alto el nivel
     */
    public static Personaje crearPersonaje(int Nivel){
        return new Personaje(nombre, vidaBase+10*Nivel,
                resistenciaBase+5*Nivel,
                regeneracionBase+5*Nivel);
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes tipo No Muerto";
    }
}

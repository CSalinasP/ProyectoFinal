package LogicaJuego;

/**
 * Clase que usa el patrón Factory para fabricar personajes tipo Cavernario
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-07
 */
public class FabricaCavernarios extends FabricaPersonajes{
    /** El nombre de todos los Personajes tipo Cavernario */
    private static String nombre = "Cavernarios";
    /** La vida base de todos los Personajes tipo Cavernario */
    private static int vidaBase = 180;
    /** La resistencia base de todos los Personajes tipo Cavernario */
    private static int resistenciaBase = 15;
    /** La regeneración base de todos los Personajes tipo Cavernario */
    private static int regeneracionBase = 5;

    public FabricaCavernarios(){}

    /**
     * Metodo que crea un Personaje con los atributos base del Cavernario y lo retorna
     *
     * @param Nivel El nivel del Cavernario que se desea crear
     * Los atributos del Cavernario aumentan conforme más alto el nivel
     */
    public static Personaje crearPersonaje(int Nivel){
        return new Personaje(nombre, vidaBase+10*Nivel,
                resistenciaBase+5*Nivel,
                regeneracionBase+5*Nivel);
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes tipo Cavernario";
    }
}

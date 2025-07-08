package LogicaJuego;

/**
 * Clase que usa el patrón Factory para fabricar personajes tipo Humano
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-07
 */
public class FabricaHumanos {
    /** El nombre de todos los Personajes tipo Humano */
    private static String nombre = "Humano";
    /** La vida base de todos los Personajes tipo Humano */
    private static int vidaBase = 100;
    /** La resistencia base de todos los Personajes tipo Humano */
    private static int resistenciaBase = 20;
    /** La regeneración base de todos los Personajes tipo Humano */
    private static int regeneracionBase = 10;

    public FabricaHumanos(){}

    /**
     * Metodo que crea un Personaje con los atributos base del Humano y lo retorna
     *
     * @param Nivel El nivel del Humano que se desea crear
     * Los atributos del Humano aumentan conforme más alto el nivel
     */
    public static Personaje crearPersonaje(int Nivel){
        return new Personaje(nombre, vidaBase+10*Nivel,
                resistenciaBase+5*Nivel,
                regeneracionBase+5*Nivel);
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes tipo Humano";
    }
}

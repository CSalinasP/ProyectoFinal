package LogicaJuego;

/**
 * Clase que usa el patrón Factory para fabricar personajes tipo Humano y sus habilidades.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */
public class FabricaHumanos extends FabricaPersonajes{
    /** El nombre de todos los personajes tipo Humano. */
    private static String nombre = "Humano";
    /** La vida base de todos los personajes tipo Humano. */
    private static int vidaBase = 100;
    /** La resistencia base de todos los personajes tipo Humano. */
    private static int resistenciaBase = 20;
    /** La regeneración base de todos los personajes tipo Humano. */
    private static int regeneracionBase = 10;

    public FabricaHumanos(){}

    /**
     * Metodo que crea un Personaje con los atributos base del Humano y lo retorna.
     * Los atributos del Humano aumentan conforme más alto el nivel.
     * Se usa el Factory de habilidades del Humano para crear sus habilidades.
     * @param Nivel El nivel del Humano que se desea crear.
     */
    public static Personaje crearPersonaje(int Nivel){
        return new Personaje(nombre, vidaBase+10*Nivel,
                resistenciaBase+5*Nivel,
                regeneracionBase+5*Nivel,
                FabricaHabilidadHumano.crearHabilidades(Nivel));
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes tipo Humano.";
    }
}

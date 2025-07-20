package LogicaJuego;

/**
 * Clase que usa el patrón Factory para fabricar personajes tipo No Muerto y sus habilidades.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */
public class FabricaNoMuertos extends FabricaPersonajes{
    /** El nombre de todos los personajes tipo No Muerto. */
    private static String nombre = "No Muerto";
    /** La vida base de todos los personajes tipo No Muerto. */
    private static int vidaBase = 70;
    /** La resistencia base de todos los personajes tipo No Muerto. */
    private static int resistenciaBase = 70;
    /** La regeneración base de todos los personajes tipo No Muerto.*/
    private static int regeneracionBase = 5;

    public FabricaNoMuertos(){}

    /**
     * Metodo que crea un Personaje con los atributos base del No Muerto y lo retorna.
     * Los atributos del No Muerto aumentan conforme más alto el nivel.
     * Se usa el Factory de habilidades del No Muerto para crear sus habilidades.
     * @param Nivel El nivel del No Muerto que se desea crear.
     */
    public static Personaje crearPersonaje(int Nivel){
        return new Personaje(nombre, vidaBase+10*Nivel,
                resistenciaBase+5*Nivel,
                regeneracionBase+5*Nivel,"/nomuerto.jpg",
                FabricaHabilidadNoMuerto.crearHabilidades(Nivel));
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes tipo No Muerto.";
    }
}

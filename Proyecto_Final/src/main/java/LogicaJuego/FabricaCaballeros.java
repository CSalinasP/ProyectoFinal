package LogicaJuego;

/**
 * Clase que usa el patrón Factory para fabricar personajes tipo Caballero y sus habilidades.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */
public class FabricaCaballeros extends FabricaPersonajes{
    /** El nombre de todos los personajes tipo Caballero. */
    private static String nombre = "Caballero";
    /** La vida base de todos los personajes tipo Caballero. */
    private static int vidaBase = 150;
    /** La resistencia base de todos los personajes tipo Caballero. */
    private static int resistenciaBase = 30;
    /** La regeneración base de todos los personajes tipo Caballero. */
    private static int regeneracionBase = 15;

    public FabricaCaballeros(){}

    /**
     * Metodo que crea un personaje con los atributos base del Caballero y lo retorna.
     * Los atributos del Caballero aumentan conforme más alto el nivel.
     * Se usa el Factory de habilidades del Caballero para crear sus habilidades.
     * @param Nivel El nivel del Caballero que se desea crear.
     */
    public static Personaje crearPersonaje(int Nivel){
        return new Personaje(nombre, Nivel, vidaBase+10*(Nivel-1),
                                resistenciaBase+5*(Nivel-1),
                              regeneracionBase+5*(Nivel-1),"/caballero.jpg",
                FabricaHabilidadCaballero.crearHabilidades(Nivel));
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes tipo Caballero.";
    }
}

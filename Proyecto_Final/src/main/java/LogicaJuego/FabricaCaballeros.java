package LogicaJuego;

/**
 * Clase que usa el patrón Factory para fabricar personajes tipo Caballero
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-07
 */
public class FabricaCaballeros extends FabricaPersonajes{
    /** El nombre de todos los Personajes tipo Caballero */
    private static String nombre = "Caballero";
    /** La vida base de todos los Personajes tipo Caballero */
    private static int vidaBase = 150;
    /** La resistencia base de todos los Personajes tipo Caballero */
    private static int resistenciaBase = 30;
    /** La regeneracion base de todos los Personajes tipo Caballero */
    private static int regeneracionBase = 15;

    public FabricaCaballeros(){}

    /**
     * Metodo que crea un Personaje con los atributos base del Caballero y lo retorna
     *
     * @param Nivel El nivel del Caballero que se desea crear
     * Los atributos del Caballero aumentan conforme más alto el nivel
     */
    public static Personaje crearPersonaje(int Nivel){
        return new Personaje(nombre, vidaBase+10*Nivel,
                                resistenciaBase+5*Nivel,
                              regeneracionBase+5*Nivel);
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes tipo Caballero";
    }
}

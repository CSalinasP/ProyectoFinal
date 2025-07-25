import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaJuego.*;

/**
 * Clase que se encarga de hacer los tests para la subida de nivel de los 4 tipos de personaje.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 *
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-24
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_SubirNivelPersonajes {
    /** El personaje tipo Caballero al que se le harán los tests. */
    static Personaje PersonajeCaballero;
    /** El personaje tipo Cavernario al que se le harán los tests. */
    static Personaje PersonajeCavernario;
    /** El personaje tipo Humano al que se le harán los tests. */
    static Personaje PersonajeHumano;
    /** El personaje tipo No Muerto al que se le harán los tests. */
    static Personaje PersonajeNoMuerto;

    /**
     * Metodo que usa la fábrica de personajes para crear cada tipo de personaje
     * de nivel 1 y asignarlos a las variables antes de hacer los tests.
     */
    @BeforeAll
    static void setUp() {
        PersonajeCaballero = FabricaPersonajes.crearPersonaje(TipoPersonaje.CABALLERO, 1);
        PersonajeCavernario = FabricaPersonajes.crearPersonaje(TipoPersonaje.CAVERNARIO, 1);
        PersonajeHumano = FabricaPersonajes.crearPersonaje(TipoPersonaje.HUMANO, 1);
        PersonajeNoMuerto = FabricaPersonajes.crearPersonaje(TipoPersonaje.NOMUERTO, 1);
    }

    /**
     * El primer test que se encarga de usar el metodo de subir el nivel al Caballero y verifica que
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener después de subir el nivel.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación del Caballero.
     */
    @Test
    @Order(1)
    void SubirNivelCaballero(){
        PersonajeCaballero.subirNivel();
        assertEquals(160,PersonajeCaballero.getVida());
        assertEquals(35,PersonajeCaballero.getResistencia());
        assertEquals(20,PersonajeCaballero.getRegeneracion());
        assertEquals((double)100/3,PersonajeCaballero.getPromedioDamageHabilidades());
        assertEquals((double)100/3,PersonajeCaballero.getPromedioCuracionHabilidades());
    }

    /**
     * El segundo test que se encarga de usar el metodo de subir el nivel al Cavernario y verifica que
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener después de subir el nivel.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación del Cavernario.
     */
    @Test
    @Order(2)
    void SubirNivelCavernario(){
        PersonajeCavernario.subirNivel();
        assertEquals(200,PersonajeCavernario.getVida());
        assertEquals(25,PersonajeCavernario.getResistencia());
        assertEquals(15,PersonajeCavernario.getRegeneracion());
        assertEquals((double)110/3,PersonajeCavernario.getPromedioDamageHabilidades());
        assertEquals((double)75/3,PersonajeCavernario.getPromedioCuracionHabilidades());
    }

    /**
     * El tercer test que se encarga de usar el metodo de subir el nivel al Humano y verifica que
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener después de subir el nivel.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación del Humano.
     */
    @Test
    @Order(3)
    void SubirNivelHumano(){
        PersonajeHumano.subirNivel();
        assertEquals(120,PersonajeHumano.getVida());
        assertEquals(30,PersonajeHumano.getResistencia());
        assertEquals(20,PersonajeHumano.getRegeneracion());
        assertEquals((double)110/3,PersonajeHumano.getPromedioDamageHabilidades());
        assertEquals((double)75/3,PersonajeHumano.getPromedioCuracionHabilidades());
    }

    /**
     * El cuarto test que se encarga de usar el metodo de subir el nivel al No Muerto y verifica que
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener después de subir el nivel.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación del No Muerto.
     */
    @Test
    @Order(4)
    void SubirNivelNoMuerto(){
        PersonajeNoMuerto.subirNivel();
        assertEquals(90,PersonajeNoMuerto.getVida());
        assertEquals(80,PersonajeNoMuerto.getResistencia());
        assertEquals(15,PersonajeNoMuerto.getRegeneracion());
        assertEquals((double)60/3,PersonajeNoMuerto.getPromedioDamageHabilidades());
        assertEquals((double)45/3,PersonajeNoMuerto.getPromedioCuracionHabilidades());
    }
}

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaJuego.*;

/**
 * Clase que se encarga de hacer los tests para la creación de los 4 tipos de personaje.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-13
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_CreacionPersonajes
{
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
     * El primer test que se encarga de que el Caballero de nivel 1
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener al ser creado.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación de las habilidades del Caballero.
     */
    @Test
    @Order(1)
    void CreacionCaballero(){
        assertEquals(150,PersonajeCaballero.getVida());
        assertEquals(30,PersonajeCaballero.getResistencia());
        assertEquals(15,PersonajeCaballero.getRegeneracion());
        assertEquals(30,PersonajeCaballero.getPromedioDamageHabilidades());
        assertEquals(30,PersonajeCaballero.getPromedioCuracionHabilidades());
    }

    /**
     * El segundo test que se encarga de que el Cavernario de nivel 1
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener al ser creado.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación de las habilidades del Cavernario.
     */
    @Test
    @Order(2)
    void CreacionCavernario(){
        assertEquals(190,PersonajeCavernario.getVida());
        assertEquals(20,PersonajeCavernario.getResistencia());
        assertEquals(10,PersonajeCavernario.getRegeneracion());
        assertEquals((double)100/3,PersonajeCavernario.getPromedioDamageHabilidades());
        assertEquals((double)65/3,PersonajeCavernario.getPromedioCuracionHabilidades());
    }

    /**
     * El tercer test que se encarga de que el Humano de nivel 1
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener al ser creado.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación de las habilidades del Humano.
     */
    @Test
    @Order(3)
    void CreacionHumano(){
        assertEquals(110,PersonajeHumano.getVida());
        assertEquals(25,PersonajeHumano.getResistencia());
        assertEquals(15,PersonajeHumano.getRegeneracion());
        assertEquals((double)100/3,PersonajeHumano.getPromedioDamageHabilidades());
        assertEquals((double)65/3,PersonajeHumano.getPromedioCuracionHabilidades());
    }

    /**
     * El cuarto test que se encarga de que el No Muerto de nivel 1
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener al ser creado.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación de las habilidades del No Muerto.
     */
    @Test
    @Order(4)
    void CreacionNoMuerto(){
        assertEquals(80,PersonajeNoMuerto.getVida());
        assertEquals(75,PersonajeNoMuerto.getResistencia());
        assertEquals(10,PersonajeNoMuerto.getRegeneracion());
        assertEquals((double)50/3,PersonajeNoMuerto.getPromedioDamageHabilidades());
        assertEquals((double)35/3,PersonajeNoMuerto.getPromedioCuracionHabilidades());
    }

    /**
     * El quinto test que se encarga de usar el metodo de subir el nivel al Caballero y verifica que
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener después de subir el nivel.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación del Caballero.
     */
    @Test
    @Order(5)
    void SubirNivelCaballero(){
        PersonajeCaballero.subirNivel();
        assertEquals(160,PersonajeCaballero.getVida());
        assertEquals(35,PersonajeCaballero.getResistencia());
        assertEquals(20,PersonajeCaballero.getRegeneracion());
        assertEquals((double)100/3,PersonajeCaballero.getPromedioDamageHabilidades());
        assertEquals((double)100/3,PersonajeCaballero.getPromedioCuracionHabilidades());
    }

    /**
     * El sexto test que se encarga de usar el metodo de subir el nivel al Cavernario y verifica que
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener después de subir el nivel.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación del Cavernario.
     */
    @Test
    @Order(6)
    void SubirNivelCavernario(){
        PersonajeCavernario.subirNivel();
        assertEquals(200,PersonajeCavernario.getVida());
        assertEquals(25,PersonajeCavernario.getResistencia());
        assertEquals(15,PersonajeCavernario.getRegeneracion());
        assertEquals((double)110/3,PersonajeCavernario.getPromedioDamageHabilidades());
        assertEquals((double)75/3,PersonajeCavernario.getPromedioCuracionHabilidades());
    }

    /**
     * El séptimo test que se encarga de usar el metodo de subir el nivel al Humano y verifica que
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener después de subir el nivel.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación del Humano.
     */
    @Test
    @Order(7)
    void SubirNivelHumano(){
        PersonajeHumano.subirNivel();
        assertEquals(120,PersonajeHumano.getVida());
        assertEquals(30,PersonajeHumano.getResistencia());
        assertEquals(20,PersonajeHumano.getRegeneracion());
        assertEquals((double)110/3,PersonajeHumano.getPromedioDamageHabilidades());
        assertEquals((double)75/3,PersonajeHumano.getPromedioCuracionHabilidades());
    }

    /**
     * El octavo test que se encarga de usar el metodo de subir el nivel al No Muerto y verifica que
     * tenga la vida, resistencia, regeneración y el daño/curación de sus habilidades
     * que deberían tener después de subir el nivel.
     * En el caso de las habilidades, se usa el metodo de la clase Personaje que
     * calcula el promedio del daño y la curación del No Muerto.
     */
    @Test
    @Order(8)
    void SubirNivelNoMuerto(){
        PersonajeNoMuerto.subirNivel();
        assertEquals(90,PersonajeNoMuerto.getVida());
        assertEquals(80,PersonajeNoMuerto.getResistencia());
        assertEquals(15,PersonajeNoMuerto.getRegeneracion());
        assertEquals((double)60/3,PersonajeNoMuerto.getPromedioDamageHabilidades());
        assertEquals((double)45/3,PersonajeNoMuerto.getPromedioCuracionHabilidades());
    }

}

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaTorneo.*;

/**
 * Clase que se encarga de hacer los tests para la creación del torneo de eliminatoria simple.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 *
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-24
 */
public class Test_CreacionElimSimple {
    /** Única instancia del torneo al que se le harán los tests. */
    static Torneo eliminatoriaSimple;

    /**
     * Metodo que usa la fábrica de torneos para crear la eliminatoria simple de máximo nivel para los tests.
     * En este caso es el nivel 4, que hace que empiece el torneo con unos octavos de final.
     */
    @BeforeAll
    static void setUp() {
        eliminatoriaSimple = FabricaTorneos.crearTorneo(TipoTorneo.ELIMINATORIA_SIMPLE, 4);
    }

    /**
     * Test que verifica que cuando se crea un torneo con octavos de final,
     * la cantidad de competidores inicial tiene que ser 16 incluyendo Avatar.
     */
    @Test
    @Order(1)
    void creacionCompetidores() {
        assertEquals(16, eliminatoriaSimple.getCompetidores().size());
    }

    /**
     * Test que verifica que cuando se crea un torneo con octavos de final,
     * la cantidad de fechas de enfrentamientos tiene que ser 8 incluyendo la fecha de combate de Avatar.
     */
    @Test
    @Order(2)
    void creacionFechas() {
        assertEquals(8, eliminatoriaSimple.getFechasEnfrentamientos().size());
    }
}

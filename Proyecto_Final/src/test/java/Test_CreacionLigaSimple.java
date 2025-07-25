import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaTorneo.*;

/**
 * Clase que se encarga de hacer los tests para la creación del torneo de liga simple.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 *
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-24
 */
public class Test_CreacionLigaSimple {
    /** Única instancia del torneo al que se le harán los tests. */
    static Torneo ligaSimple;

    /**
     * Metodo que usa la fábrica de torneos para crear la liga simple de máximo nivel para los tests.
     * En este caso es el nivel 10, que hace que empiece el torneo con 11 competidores incluyendo Avatar.
     */
    @BeforeAll
    static void setUp() {
        ligaSimple = FabricaTorneos.crearTorneo(TipoTorneo.LIGA_SIMPLE, 10);
    }

    /**
     * Test que verifica que cuando se crea un torneo de nivel 10,
     * la cantidad de competidores inicial tiene que ser 11 incluyendo Avatar.
     */
    @Test
    @Order(1)
    void creacionCompetidores() {
        assertEquals(11, ligaSimple.getCompetidores().size());
    }

    /**
     * Test que verifica que cuando se crea un torneo de nivel 10,
     * la cantidad de fechas de enfrentamientos tiene que ser 5 incluyendo la fecha de combate de Avatar.
     */
    @Test
    @Order(2)
    void creacionFechas() {
        assertEquals(5, ligaSimple.getFechasEnfrentamientos().size());
    }
}
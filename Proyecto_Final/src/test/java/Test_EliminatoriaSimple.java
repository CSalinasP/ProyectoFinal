import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaTorneo.*;

/**
 * Clase que se encarga de hacer los tests para la creación del torneo de eliminatoria simple.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-20
 */
public class Test_EliminatoriaSimple {
    static Torneo eliminatoriaSimple;

    /**
     * Metodo que usa la fábrica de torneos para crear la eliminatoria simple de 3 niveles,
     * al cual es asignada antes de hacer los tests.
     */
    @BeforeAll
    static void setUp() {
        eliminatoriaSimple = FabricaTorneos.crearTorneo(TipoTorneo.ELIMINATORIA_SIMPLE, 3);
    }

    /**
     * Test que verifica que cuando se crea un torneo de 3 niveles,
     * el número de competidores inicial tiene que ser de 7.
     */
    @Test
    @Order(1)
    void creacionCompetidores() {
        assertEquals(7, eliminatoriaSimple.getCompetidores().size());
    }

    /**
     * Test que verifica que después de que se simulen los resultados de los competidores 1 vez,
     * el número de enfrentamientos restantes en el torneo tiene que ser de 3.
     */
    @Test
    @Order(2)
    void verificacionResultados() {
        eliminatoriaSimple.actualizarEnfrentamientos();
        assertEquals(3, eliminatoriaSimple.getEnfrentamientos().size());
    }
}

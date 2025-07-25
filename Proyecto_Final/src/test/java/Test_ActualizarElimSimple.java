import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaTorneo.*;

/**
 * Clase que se encarga de hacer los tests para la actualización del torneo de Eliminatoria simple
 * después de calcular el resultado de los combates en los octavos y cuartos de final
 * usando la función de probabilidad.
 *
 * LOS COMBATES DE AVATAR (o del usuario) NO SE CONSIDERAN, ya que no se ejecuta el juego en sí,
 * solo los combates que se calculan automáticamente con la función de probabilidad.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 *
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-24
 */
public class Test_ActualizarElimSimple {
    /** Única instancia del torneo al que se le harán los tests. */
    static Torneo eliminatoriaSimple;

    /**
     * Metodo que usa la fábrica de torneos para crear la eliminatoria simple de máximo nivel para los tests.
     * En este caso es el nivel 4, que hace que empiece el torneo con unos octavos de final.
     */
    @BeforeEach
    void setUp() {
        eliminatoriaSimple = FabricaTorneos.crearTorneo(TipoTorneo.ELIMINATORIA_SIMPLE, 4);
    }

    /**
     * Test que verifica que después de calcular los resultados de los octavos de final,
     * la cantidad de competidores restantes en el torneo tiene que ser 7, y
     * después de calcular los resultados de los cuartos de final, tiene que ser 2.
     * (SIN CONTAR EL COMBATE DE CUARTOS Y OCTAVOS DE FINAL DE AVATAR)
     */
    @Test
    @Order(1)
    void actualizarEnfrentamientos() {
        eliminatoriaSimple.actualizarEnfrentamientos();
        assertEquals(7, eliminatoriaSimple.getEnfrentamientos().size());

        eliminatoriaSimple.actualizarEnfrentamientos();
        assertEquals(2, eliminatoriaSimple.getEnfrentamientos().size());
    }

    /**
     * Test que verifica que después de calcular los resultados de los octavos de final,
     * la cantidad de fechas de los siguientes enfrentamientos en los cuartos de final debe ser 3,
     * y después de calcular los resultados de los cuartos de final, debe ser 1.
     * (SIN CONTAR LAS FECHAS DE COMBATE DE AVATAR EN LOS OCTAVOS Y CUARTOS DE FINAL)
     */
    @Test
    @Order(2)
    void actualizarFechas() {
        eliminatoriaSimple.actualizarEnfrentamientos();
        eliminatoriaSimple.actualizarFechas();
        assertEquals(3, eliminatoriaSimple.getFechasEnfrentamientos().size());

        eliminatoriaSimple.actualizarEnfrentamientos();
        eliminatoriaSimple.actualizarFechas();
        assertEquals(1, eliminatoriaSimple.getFechasEnfrentamientos().size());
    }
}

import LogicaJuego.Personaje;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaTorneo.*;

/**
 * Clase que se encarga de hacer los tests para la actualización del torneo de Liga simple
 * después de calcular el resultado de los combates usando la función de probabilidad.
 *
 * LOS COMBATES DE AVATAR (o del usuario) NO SE CONSIDERAN, ya que no se ejecuta el juego en sí,
 * solo los combates que se calculan automáticamente con la función de probabilidad.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 *
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-24
 */
public class Test_ActualizarLigaSimple {
    /** Única instancia del torneo al que se le harán los tests. */
    static Torneo ligaSimple;

    /**
     * Metodo que usa la fábrica de torneos para crear la liga simple de máximo nivel para los tests.
     * En este caso es el nivel 10, que hace que empiece el torneo con 11 competidores incluyendo Avatar.
     */
    @BeforeEach
    void setUp() {
        ligaSimple = FabricaTorneos.crearTorneo(TipoTorneo.LIGA_SIMPLE, 10);
    }

    /**
     * Test que verifica que después de calcular los resultados de los combates 1 vez,
     * todos los competidores tienen que haber ganado o perdido 1 vez,
     * si en cualquier momento no se cumple la condición, el test falla.
     *
     * (SIN CONTAR EL COMBATE DE AVATAR Y 1 COMPETIDOR QUE NO PUEDE COMBATIR,
     * YA QUE SON 11 COMPETIDORES CON 5 COMBATES CADA JORNADA).
     */
    @Test
    @Order(1)
    void actualizarEnfrentamientos() {
        ligaSimple.actualizarEnfrentamientos();
        boolean test = true;

        for (int i=2;i<ligaSimple.getCompetidores().size()-1;i++){

            Personaje aux = ligaSimple.getCompetidores().get(i);

            if (aux.getVictorias() == 0 && aux.getDerrotas() == 0){
                test = false;
                break;
            }
        }
        assert test;
    }

    /**
     * Test que verifica que siempre tiene que haber 5 fechas de enfrentamientos en cada
     * jornada de combates, ya que son 11 competidores en la liga.
     * (1 COMPETIDOR NO COMBATE POR CADA JORNADA, PORQUE SON 11 COMPETIDORES EN TOTAL)
     */
    @Test
    @Order(2)
    void actualizarFechas() {
        ligaSimple.actualizarEnfrentamientos();
        ligaSimple.actualizarFechas();
        assertEquals(5, ligaSimple.getFechasEnfrentamientos().size());
    }
}

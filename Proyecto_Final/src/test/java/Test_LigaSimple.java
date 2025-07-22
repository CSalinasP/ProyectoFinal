import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaTorneo.*;

/**
 * Clase que se encarga de hacer los tests para la creación del torneo de liga simple.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 * @author CSalinasP
 * @version 1.1
 * @since 2025-07-22
 */
public class Test_LigaSimple {
    static Torneo ligaSimple;

    /**
     * Metodo que usa la fábrica de torneos para crear la liga simple de 3 niveles,
     * al cual es asignada antes de hacer los tests.
     */
    @BeforeAll
    static void setUp() {
        ligaSimple = FabricaTorneos.crearTorneo(TipoTorneo.LIGA_SIMPLE, 3);
    }

    /**
     * Test que verifica que cuando se crea un torneo de 3 niveles,
     * el número de competidores inicial tiene que ser de 2.
     */
    @Test
    @Order(1)
    void creacionCompetidores() {
        assertEquals(2, ligaSimple.getCompetidores().size());
    }

    /**
     * Test que verifica que cuando se crea un torneo de 3 niveles,
     * el número de fechas de enfrentamientos tiene que ser de 1.
     */
    @Test
    @Order(2)
    void creacionFechas() {
        assertEquals(1, ligaSimple.getFechasEnfrentamientos().size());
    }

    /**
     * Test que verifica que después de que se obtienen los resultados de los combates 1 vez,
     * al menos uno de los competidores tiene que haber subido su puntaje al ganar y
     * que el número de fechas de enfrentamientos tiene que seguir siendo 1.
     */
    @Test
    @Order(3)
    void actualizarEnfrentamientosyFechas() {
        ligaSimple.actualizarEnfrentamientos();
        boolean aux = false;
        for (int i=0;i<ligaSimple.getCompetidores().size();i++){
            if (ligaSimple.getCompetidores().get(i).getPuntaje() != 0){
                aux = true;
                break;
            }
        }
        assertTrue(aux);

        ligaSimple.actualizarFechas();
        assertEquals(1, ligaSimple.getFechasEnfrentamientos().size());
    }
}





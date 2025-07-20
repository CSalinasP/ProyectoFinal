import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import LogicaTorneo.*;

/**
 * Clase que se encarga de hacer los tests para la creación del torneo de liga simple.
 * Se usa el @TestMethodOrder para hacer que los tests se hagan en orden.
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-20
 */
public class Test_LigaSimple {
    static Torneo ligaSimple;

    /**
     * Metodo que usa la fábrica de torneos para crear la liga simple de 5 niveles,
     * al cual es asignada antes de hacer los tests.
     */
    @BeforeAll
    static void setUp() {
        ligaSimple = FabricaTorneos.crearTorneo(TipoTorneo.LIGA_SIMPLE, 5);
    }

    /**
     * Test que verifica que cuando se crea un torneo de 5 niveles,
     * el número de competidores tiene que ser de 6.
     */
    @Test
    @Order(1)
    void creacionCompetidores() {
        assertEquals(6, ligaSimple.getCompetidores().size());
    }

    /**
     * Test que verifica que después de que se simulen los resultados de los competidores 1 vez,
     * al menos uno de los competidores tiene que haber subido su puntaje al ganar.
     */
    @Test
    @Order(2)
    void verificacionResultados() {
        ligaSimple.resultadosEnfrentamientos();
        boolean aux = false;
        for (int i=0;i<ligaSimple.getCompetidores().size();i++){
            if (ligaSimple.getCompetidores().get(i).getPuntaje() != 0){
                aux = true;
                break;
            }
        }
        assert aux;
    }
}

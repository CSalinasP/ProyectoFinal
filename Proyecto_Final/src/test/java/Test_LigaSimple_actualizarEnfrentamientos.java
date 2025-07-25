import LogicaTorneo.*;

import LogicaJuego.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que se encarga de hacer los tests para la funcion actualizarEnfrentamientos de la clase
 * LigaSimple
 * @author Francisco Arentsen
 */
class Test_LigaSimple_actualizarEnfrentamientos {

    private LigaSimple torneoParaTest;

    /**Se asegura de que la instancia sea nula antes de cada test para evitar interferencias*/
    @BeforeEach
    void setUp() {}

   //CASO NORMAL
    @Test
    /**prueba que los enfrentamientos se actualizen correctamente 4 competidores, todos combaten, niveles y victorias/derrotas se actualizan*/
    void actualizarEnfrentamientos_cuatroCompetidores_todosCombaten() {
        Personaje p1 = FabricaHumanos.crearPersonaje(1);
        Personaje p2 = FabricaCaballeros.crearPersonaje(1);
        Personaje p3 = FabricaCavernarios.crearPersonaje(1);
        Personaje p4 = FabricaNoMuertos.crearPersonaje(1);

        ArrayList<Personaje> enfrentamientosIniciales = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));

        torneoParaTest = new LigaSimple(3) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) {
                if (avatar.equals(p1) && contendiente.equals(p2)) {
                    return p1;
                }
                if (avatar.equals(p3) && contendiente.equals(p4)) {
                    return p3;
                }
                fail("determinarGanador fue llamado con argumentos inesperados en el test de 4 competidores.");
                return null;
            }
        };

        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getEnfrentamientos().addAll(enfrentamientosIniciales);
        torneoParaTest.getHistorialEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().add(new ArrayList<>(enfrentamientosIniciales));

        torneoParaTest.actualizarEnfrentamientos();

        ArrayList<Personaje> enfrentamientosActualizados = torneoParaTest.getEnfrentamientos();
        assertNotNull(enfrentamientosActualizados);
        assertEquals(4, enfrentamientosActualizados.size());
        assertEquals(p2, enfrentamientosActualizados.get(0));
        assertEquals(p3, enfrentamientosActualizados.get(1));
        assertEquals(p4, enfrentamientosActualizados.get(2));
        assertEquals(p1, enfrentamientosActualizados.get(3));

        assertEquals(2, p1.getNivel(), "P1 debería haber subido de nivel.");
        assertEquals(2, p2.getNivel(), "P2 debería haber subido de nivel.");
        assertEquals(2, p3.getNivel(), "P3 debería haber subido de nivel.");
        assertEquals(2, p4.getNivel(), "P4 debería haber subido de nivel.");

        assertEquals(1, p1.getVictorias()); assertEquals(0, p1.getDerrotas());
        assertEquals(0, p2.getVictorias()); assertEquals(1, p2.getDerrotas());
        assertEquals(1, p3.getVictorias()); assertEquals(0, p3.getDerrotas());
        assertEquals(0, p4.getVictorias()); assertEquals(1, p4.getDerrotas());

        ArrayList<ArrayList<Personaje>> historial = torneoParaTest.getHistorialEnfrentamientos();
        assertEquals(2, historial.size());
        assertEquals(enfrentamientosIniciales, historial.get(0));
        assertEquals(enfrentamientosActualizados, historial.get(1));
    }

    //CASOS EXTREMOS
    @Test
    /**prueba que el metodo no haga nada si la lista de enfrentamientos está vacía*/
    void actualizarEnfrentamientos_listaVacia_noLanzaExcepcionYNoCambia() {
        torneoParaTest = new LigaSimple(0) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) {
                fail("determinarGanador no debería ser llamado si la lista está vacía.");
                return null;
            }
        };
        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().clear();

        assertDoesNotThrow(() -> torneoParaTest.actualizarEnfrentamientos(),
                "No se esperaba una excepción para una lista vacía.");

        assertTrue(torneoParaTest.getEnfrentamientos().isEmpty());
        assertTrue(torneoParaTest.getHistorialEnfrentamientos().isEmpty());
    }

    @Test
    /**prueba que el metodo maneje una lista con un numero impar de enfrentamientos (el último no combate, pero se rota)*/
    void actualizarEnfrentamientos_listaImpar_ultimoNoCombatePeroRota() {
        Personaje p1 = FabricaHumanos.crearPersonaje(1);
        Personaje p2 = FabricaCaballeros.crearPersonaje(1);
        Personaje p3 = FabricaCavernarios.crearPersonaje(1);

        ArrayList<Personaje> enfrentamientosIniciales = new ArrayList<>(Arrays.asList(p1, p2, p3));

        torneoParaTest = new LigaSimple(2) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) {
                assertEquals(p1, avatar);
                assertEquals(p2, contendiente);
                return p1;
            }
        };

        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getEnfrentamientos().addAll(enfrentamientosIniciales);
        torneoParaTest.getHistorialEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().add(new ArrayList<>(enfrentamientosIniciales));

        torneoParaTest.actualizarEnfrentamientos();

        ArrayList<Personaje> enfrentamientosActualizados = torneoParaTest.getEnfrentamientos();
        assertNotNull(enfrentamientosActualizados);
        assertEquals(3, enfrentamientosActualizados.size());
        assertEquals(p2, enfrentamientosActualizados.get(0));
        assertEquals(p3, enfrentamientosActualizados.get(1));
        assertEquals(p1, enfrentamientosActualizados.get(2));

        assertEquals(2, p1.getNivel(), "P1 debería haber subido de nivel.");
        assertEquals(2, p2.getNivel(), "P2 debería haber subido de nivel.");
        assertEquals(1, p3.getNivel(), "P3 no debería haber subido de nivel (no combatió).");

        assertEquals(1, p1.getVictorias()); assertEquals(0, p1.getDerrotas());
        assertEquals(0, p2.getVictorias()); assertEquals(1, p2.getDerrotas());
        assertEquals(0, p3.getVictorias()); assertEquals(0, p3.getDerrotas());

        ArrayList<ArrayList<Personaje>> historial = torneoParaTest.getHistorialEnfrentamientos();
        assertEquals(2, historial.size());
        assertEquals(enfrentamientosIniciales, historial.get(0));
        assertEquals(enfrentamientosActualizados, historial.get(1));
    }

    @Test
    /**prueba que el metodo maneje una lista con un solo elemento (no combate ni sube de nivel, pero se rota)*/
    void actualizarEnfrentamientos_listaUnSoloElemento_noCombatePeroRota() {
        Personaje p1 = FabricaHumanos.crearPersonaje(1);
        ArrayList<Personaje> enfrentamientosIniciales = new ArrayList<>(Arrays.asList(p1));

        torneoParaTest = new LigaSimple(0) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) {
                fail("determinarGanador no debería ser llamado con un solo personaje.");
                return null;
            }
        };

        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getEnfrentamientos().addAll(enfrentamientosIniciales);
        torneoParaTest.getHistorialEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().add(new ArrayList<>(enfrentamientosIniciales));

        torneoParaTest.actualizarEnfrentamientos();

        ArrayList<Personaje> enfrentamientosActualizados = torneoParaTest.getEnfrentamientos();
        assertNotNull(enfrentamientosActualizados);
        assertEquals(1, enfrentamientosActualizados.size());
        assertEquals(p1, enfrentamientosActualizados.get(0));

        assertEquals(1, p1.getNivel(), "P1 no debería haber subido de nivel.");
        assertEquals(0, p1.getVictorias());
        assertEquals(0, p1.getDerrotas());

        ArrayList<ArrayList<Personaje>> historial = torneoParaTest.getHistorialEnfrentamientos();
        assertEquals(2, historial.size());
        assertEquals(enfrentamientosIniciales, historial.get(0));
        assertEquals(enfrentamientosActualizados, historial.get(1));
    }
}


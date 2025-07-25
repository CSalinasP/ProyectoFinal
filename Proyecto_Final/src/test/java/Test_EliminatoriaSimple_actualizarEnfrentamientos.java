import LogicaTorneo.*;

import LogicaJuego.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase que se encarga de hacer los tests para la funcion actualizarEnfrentamientos de la clase
 * EliminatoriaSimple
 * @author Francisco Arentsen
 */

class Test_EliminatoriaSimple_actualizarEnfrentamientos {

    private EliminatoriaSimple torneoParaTest;

    /**Se asegura de que la instancia sea nula antes de cada test para evitar interferencias*/
    @BeforeEach
    void setUp() {}

    //CASO NORMAL
     @Test
    /**Prueba que la lista de enfrentameintos quede vacia para 2 competidores*/
    void actualizarEnfrentamientos_dosCompetidores_listaVacia() {
        Personaje p1 = FabricaHumanos.crearPersonaje(1);
        Personaje p2 = FabricaCaballeros.crearPersonaje(1);

        ArrayList<Personaje> enfrentamientosIniciales = new ArrayList<>(Arrays.asList(p1, p2));

        torneoParaTest = new EliminatoriaSimple(1) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) {
                fail("determinarGanador no deberia ser llamado con 2 competidores si la implementacion es correcta.");
                return avatar;
            }
        };

        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getEnfrentamientos().addAll(enfrentamientosIniciales);
        torneoParaTest.getHistorialEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().add(new ArrayList<>(enfrentamientosIniciales));

        torneoParaTest.actualizarEnfrentamientos();

        ArrayList<Personaje> enfrentamientosActualizados = torneoParaTest.getEnfrentamientos();
        assertNotNull(enfrentamientosActualizados);
        assertTrue(enfrentamientosActualizados.isEmpty(), "La lista de enfrentamientos debería estar vacía para 2 competidores.");

        assertEquals(1, p1.getNivel(), "P1 no debería haber subido de nivel.");
        assertEquals(1, p2.getNivel(), "P2 no debería haber subido de nivel.");

        ArrayList<ArrayList<Personaje>> historial = torneoParaTest.getHistorialEnfrentamientos();
        assertEquals(2, historial.size(), "El historial debería tener 2 entradas.");
        assertEquals(enfrentamientosIniciales, historial.get(0));
        assertTrue(historial.get(1).isEmpty(), "La segunda entrada del historial debería ser una lista vacía.");
    }

    //CASOS EXTREMOS
    @Test
    /**El metodo no deberia hacer nada con una lista vacia*/
    void actualizarEnfrentamientos_listaVacia_noCambia() {
        torneoParaTest = new EliminatoriaSimple(1) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) { return avatar; }
        };
        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().clear();

        torneoParaTest.actualizarEnfrentamientos();

        assertTrue(torneoParaTest.getEnfrentamientos().isEmpty(), "La lista de enfrentamientos debe permanecer vacía.");
        assertTrue(torneoParaTest.getHistorialEnfrentamientos().isEmpty(), "El historial de enfrentamientos debe permanecer vacío.");
    }

    @Test
    /**Deberia dejar la lista de enfrentamientos vacia para una lista impar (por ejemplo 3 competidores)*/
    void actualizarEnfrentamientos_listaImpar_vacia() {
        Personaje p1 = FabricaHumanos.crearPersonaje(1);
        Personaje p2 = FabricaCaballeros.crearPersonaje(1);
        Personaje p3 = FabricaCavernarios.crearPersonaje(1);

        ArrayList<Personaje> enfrentamientosIniciales = new ArrayList<>(Arrays.asList(p1, p2, p3));

        torneoParaTest = new EliminatoriaSimple(1) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) {
                fail("determinarGanador no debería ser llamado con 3 competidores si la implementación es correcta.");
                return avatar;
            }
        };

        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getEnfrentamientos().addAll(enfrentamientosIniciales);
        torneoParaTest.getHistorialEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().add(new ArrayList<>(enfrentamientosIniciales));

        // Acción
        torneoParaTest.actualizarEnfrentamientos();

        // Verificación
        ArrayList<Personaje> enfrentamientosActualizados = torneoParaTest.getEnfrentamientos();
        assertNotNull(enfrentamientosActualizados);
        assertTrue(enfrentamientosActualizados.isEmpty(), "La lista de enfrentamientos debería estar vacía para 3 competidores.");

        assertEquals(1, p1.getNivel(), "P1 no debería haber subido de nivel.");
        assertEquals(1, p2.getNivel(), "P2 no debería haber subido de nivel.");
        assertEquals(1, p3.getNivel(), "P3 no debería haber subido de nivel.");

        ArrayList<ArrayList<Personaje>> historial = torneoParaTest.getHistorialEnfrentamientos();
        assertEquals(2, historial.size(), "El historial debería tener 2 entradas.");
        assertEquals(enfrentamientosIniciales, historial.get(0));
        assertTrue(historial.get(1).isEmpty(), "La segunda entrada del historial debería ser una lista vacía.");
    }

    //EXCEPCIONES
    @Test
    /**deberia lanzar NullPointerException si un personaje es nulo en las posiciones procesadas*/
    void actualizarEnfrentamientos_personajeNulo_lanzaNullPointerException() {
        Personaje p1 = FabricaHumanos.crearPersonaje(1);
        Personaje p2 = FabricaCaballeros.crearPersonaje(1);

        ArrayList<Personaje> enfrentamientosConNuloEnCombate = new ArrayList<>(Arrays.asList(p1, p2, p2, null));

        torneoParaTest = new EliminatoriaSimple(2) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) {
                assertEquals(p2, avatar, "El primer contendiente en el combate nulo debe ser P2.");
                assertNull(contendiente, "El segundo contendiente en el combate nulo debe ser NULL.");

                return super.determinarGanador(avatar, contendiente);
            }
        };

        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getEnfrentamientos().addAll(enfrentamientosConNuloEnCombate);
        torneoParaTest.getHistorialEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().add(new ArrayList<>(enfrentamientosConNuloEnCombate));

        assertThrows(NullPointerException.class, () -> torneoParaTest.actualizarEnfrentamientos(),
                "Se esperaba un NullPointerException cuando determinarGanador se llama con un personaje nulo.");
    }

    @Test
    /**"deberia lanzar NullPointerException si ambos personajes en el combate son nulos"*/
    void actualizarEnfrentamientos_ambosNulosEnCombate_lanzaNullPointerException() {
        // Creamos una lista donde ambos personajes que el bucle procesaría son nulos.
        ArrayList<Personaje> enfrentamientosSoloNulosEnCombate = new ArrayList<>(Arrays.asList(FabricaHumanos.crearPersonaje(1), FabricaCaballeros.crearPersonaje(1), null, null));

        torneoParaTest = new EliminatoriaSimple(2) {
            @Override
            public Personaje determinarGanador(Personaje avatar, Personaje contendiente) {
                assertNull(avatar, "El primer contendiente en el combate nulo debe ser NULL.");
                assertNull(contendiente, "El segundo contendiente en el combate nulo debe ser NULL.");
                return super.determinarGanador(avatar, contendiente);
            }
        };

        torneoParaTest.getEnfrentamientos().clear();
        torneoParaTest.getEnfrentamientos().addAll(enfrentamientosSoloNulosEnCombate);
        torneoParaTest.getHistorialEnfrentamientos().clear();
        torneoParaTest.getHistorialEnfrentamientos().add(new ArrayList<>(enfrentamientosSoloNulosEnCombate));

        assertThrows(NullPointerException.class, () -> torneoParaTest.actualizarEnfrentamientos(),
                "Se esperaba un NullPointerException cuando determinarGanador se llama con dos personajes nulos.");
    }
}
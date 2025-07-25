import GUIJuego.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.ImageIcon;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class Test_MetodoCargarImagen {

    /**Se asegura de que la instancia sea nula antes de cada test para evitar interferencias
    si bien no es necesario como la clase RcursosGraficos implementa el patron Singeton creo
     que es una buena practica*/
    @BeforeEach
    void setUp() {}


    //CASOS NORMALES

    /**Prueba cargando una imagen sin escalar*/
    @Test
    void testCargarImagenNormalSinEscalar() {
        String imgPath = "/16bit.png";
        ImageIcon icon = RecursosGraficos.cargarImagen(imgPath, 0, 0);

        assertNotNull(icon, "El icono debe ser no nulo para una imagen existente");
        assertTrue(icon.getIconWidth() > 0, "El ancho del icono debe ser mayor que 0.");
        assertTrue(icon.getIconHeight() > 0, "El alto del icono debe ser mayor que 0.");
    }

    /**Prueba cargando una imagen escalada*/
    @Test
    void testCargarImagenNormalConEscala() {
        String imgPath = "/16bit.png";
        int anchoDeseado = 100;
        int altoDeseado = 50;
        ImageIcon icon = RecursosGraficos.cargarImagen(imgPath, anchoDeseado, altoDeseado);

        assertNotNull(icon, "El icono debe ser no nulo para una imagen existente");
        assertEquals(anchoDeseado, icon.getIconWidth(), "El ancho del icono escalado debe coincidir.");
        assertEquals(altoDeseado, icon.getIconHeight(), "El alto del icono escalado debe coincidir.");
    }


    /**Prueba cargando una imagen relativamente grande sin escaar*/
    @Test
    void testCargarImagenGrandeSinEscalar() {
        String imgPath = "/GPU_Reducida.jpg";
        ImageIcon icon = RecursosGraficos.cargarImagen(imgPath, 0, 0);

        assertNotNull(icon, "El icono debe ser no nulo para una imagen existente");
        assertTrue(icon.getIconWidth() > 100, "El ancho del icono grande debe ser mayor que 100.");
        assertTrue(icon.getIconHeight() > 100, "El alto del icono grande debe ser mayor que 100.");
    }


    //CASOS EXTREMOS
    /**Prueba cargando una imagen a una escala minima*/
    @Test
    void testCargarImagenEscalaMinima() {
        // Asegúrate de tener 'test_image_small.png' en src/test/resources
        String imgPath = "/16bit.png";
        int anchoMinimo = 1;
        int altoMinimo = 1;
        ImageIcon icon = RecursosGraficos.cargarImagen(imgPath, anchoMinimo, altoMinimo);

        assertNotNull(icon, "El icono no debería ser nulo para escala minima");
        assertEquals(anchoMinimo, icon.getIconWidth(), "El ancho del icono debe ser 1.");
        assertEquals(altoMinimo, icon.getIconHeight(), "El alto del icono debe ser 1.");
    }

    @Test
    /**Prueba cargando una imagen con dimensiones negativas*/
    void testCargarImagenDimensionesNegativas() {
        String imgPath = "/16bit.png";
        ImageIcon iconOriginal = new ImageIcon(Objects.requireNonNull(RecursosGraficos.class.getResource(imgPath)));
        ImageIcon icon = RecursosGraficos.cargarImagen(imgPath, -100, -50);

        assertNotNull(icon, "El icono no debería ser nulo con dimensiones negativas.");
        assertEquals(iconOriginal.getIconWidth(), icon.getIconWidth(), "El ancho debe ser el original con dimensiones negativas.");
        assertEquals(iconOriginal.getIconHeight(), icon.getIconHeight(), "El alto debe ser el original con dimensiones negativas.");
    }


    //EXCEPCIONES
    /**Prueba cargando una imagen con ruta nula*/
    @Test
    void testCargarImagenRutaNula() {
        assertThrows(NullPointerException.class, () -> RecursosGraficos.cargarImagen(null, 10, 10),
                "DeberIa lanzar NullPointerException si la ruta es nula.");
    }

    /**Prueba cargando una imagen con ruta vacia*/
    @Test
    void testCargarImagenRutaVacia() {
        ImageIcon icon = RecursosGraficos.cargarImagen("", 10, 10);
        assertNotNull(icon, "El icono no deberia ser nulo, aun si la ruta esta vacia.");
        assertTrue(icon.getIconWidth() == -1 || icon.getIconWidth() == 0,
                "El ancho del icono deberia ser -1 o 0 para una ruta vacia.");
        assertTrue(icon.getIconHeight() == -1 || icon.getIconHeight() == 0,
                "El alto del icono deberia ser -1 o 0 para una ruta vacía.");
    }

    /**Prueba cargando una imagen que no esta presente en la carpeta resources*/
    @Test
    void testCargarImagenNoEncontrada() {
        String imgPath = "/rutaErrada.png";
        ImageIcon icon = RecursosGraficos.cargarImagen(imgPath, 10, 10);
        assertNull(icon, "El icono debería ser nulo si la imagen no se encuentra.");
    }

    /**Prueba cargando una imagen desde un archivo en otro formato*/
    @Test
    void testCargarImagenFormatoInvalido() {
        String imgPath = "/Untitled.vpd";
        ImageIcon icon = RecursosGraficos.cargarImagen(imgPath, 10, 10);

        assertNotNull(icon, "El icono no deberia ser nulo, incluso para un formato invalido.");
        assertTrue(icon.getIconWidth() == -1 || icon.getIconWidth() == 0,
                "El ancho del icono deberia ser -1 o 0 para un formato de imagen invalido.");
        assertTrue(icon.getIconHeight() == -1 || icon.getIconHeight() == 0,
                "El alto del icono deberia ser -1 o 0 para un formato de imagen invalido.");
    }
}
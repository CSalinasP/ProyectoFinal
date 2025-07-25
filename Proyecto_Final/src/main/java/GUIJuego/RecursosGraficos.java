package GUIJuego;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class RecursosGraficos {
    private static RecursosGraficos instancia;

    private RecursosGraficos(){}
    public static RecursosGraficos getInstancia(){
        if (instancia == null){
            instancia = new RecursosGraficos();
        }
        return instancia;
    }

    /**
     * Agrega una imagen a un componente Swing, escalándola si se especifican dimensiones.
     * La función maneja la adición de imágenes a JButton o JLabel (para ser usado en JPanel).
     *
     * @param imgPath La ruta de la imagen dentro del classpath (ej. "/icons/mi_imagen.png").
     * @param ancho El ancho deseado para la imagen. Si es <= 0, se usa el tamaño original.
     * @param alto El alto deseado para la imagen. Si es <= 0, se usa el tamaño original.
     */
    public static ImageIcon cargarImagen(String imgPath, int ancho, int alto) {
        URL imageURL = RecursosGraficos.class.getResource(imgPath);

        if (imageURL == null) {
            System.err.println("No se pudo encontrar la imagen en: " + imgPath);
            return null; // Salir si la imagen no se encuentra
        }

        ImageIcon iconoOriginal = new ImageIcon(imageURL);

        // Escalar la imagen si se especifican ancho y alto validos
        if (ancho > 0 && alto > 0) {
            Image img = iconoOriginal.getImage();
            Image imgEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(imgEscalada);
        } else {
            return iconoOriginal;
        }
    }
}

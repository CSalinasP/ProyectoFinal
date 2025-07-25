package GUITorneo;
import GUIJuego.MenuInicial;
import GUIJuego.VentanaJuego;
import LogicaTorneo.Torneo;

import javax.swing.*;
import java.awt.*;

public class VentanaTorneo extends JFrame {
    private static VentanaTorneo instancia;
    private BracketTorneo bracketTorneo;

    /**Constructor de la clase que configura las dimensiones de la ventana, la posisiona en pantalla,
     * establece el termino de la aplicación cuando se presiona el icono de cerrar ventana,
     * agrega una instancia de MenuInicial al JFrame y lo hace visible.*/
    private VentanaTorneo(BracketTorneo bracketTorneo){
        this.setPreferredSize(new Dimension(400,200));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.bracketTorneo=bracketTorneo;
        this.add(bracketTorneo);
        this.pack();
        // --- Código para situar en la esquina superior derecha ---
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        Rectangle screenBounds = gd.getDefaultConfiguration().getBounds();

        // Obtener los insets (ej. barra de tareas)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Insets insets = toolkit.getScreenInsets(gd.getDefaultConfiguration());

        int screenWidth = screenBounds.width;
        int screenHeight = screenBounds.height;

        int windowWidth = this.getWidth();    // Obtiene el ancho de la ventana después de pack()
        int windowHeight = this.getHeight();  // Obtiene el alto de la ventana después de pack()

        // Calcular la posición X para la esquina superior derecha
        // (Ancho de la pantalla - Ancho de la ventana - Inset derecho)
        int x = screenWidth - windowWidth - insets.right;

        // Calcular la posición Y para la esquina superior derecha (o superior izquierda)
        // (Inset superior)
        int y = insets.top;

        this.setLocation(x, y);
        // --- Fin del código para situar ---
        this.setVisible(true);
        //*setExtendedState(JFrame.MAXIMIZED_BOTH);*/
    }

    public static VentanaTorneo getInstancia(BracketTorneo bracketTorneo){
        if(instancia==null){
            return new VentanaTorneo(bracketTorneo);
        }
        return instancia;
    }

    /**Este metodo cierra VentanaJuego*/
    public void cerrarVantanaJuego(){
        this.dispose();
    }

    public BracketTorneo getBracketTorneo() {
        return bracketTorneo;
    }

    public void setBracketTorneo(BracketTorneo bracketTorneo) {
        this.bracketTorneo = bracketTorneo;
    }

    public String toString(){
        return "Esta clase sirve de contenedor para los paneles que que constituyen la GUI del juego";
    }
}
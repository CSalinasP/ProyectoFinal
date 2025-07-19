package GUIJuego;
import LogicaTorneo.Torneo;
import javax.swing.*;
import java.awt.*;

/**
 * Clase que contiene los JPanels que cosntituyen la GUI del juego.
 * Mantiene como atributo la única instancia de Torneo que se usa durante el juego
 * para que los JPanels que contiene puedan acceder a ella.
 * @author Francisco Arentsen
 */
public class VentanaJuego extends JFrame {
    private static VentanaJuego instancia;
    private Torneo torneo;
    private JPanel panelActual;

    /**Constructor de la clase que configura las dimensiones de la ventana, la posisiona en pantalla,
     * establece el termino de la aplicación cuando se presiona el icono de cerrar ventana,
     * agrega una instancia de MenuInicial al JFrame y lo hace visible.*/
    private VentanaJuego(){
        this.setPreferredSize(new Dimension(800,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelActual = new MenuInicial();
        this.add(panelActual);
        this.pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    /**Este metodo crea la única instancia de VentanaJuego que se usara en el juego si no existe
     * o retorna esta misma instancia si ya fue creada.
     * @return instancia es la única instancia de esta clase que sera usada en el juego.
     * */
    public static VentanaJuego getInstancia(){
        if(instancia==null){
            instancia = new VentanaJuego();
        }
        return instancia;
    }

    /**Este metodo remueve el JPanel que se encuetra contenido en VentanaJuego en el momento y agrega otro en su lugar.
     * @param panel es el nuevo JPanel que se quiere agregar a VentanaJuego.
     * */
    public void cambiarPanel(JPanel panel){
        this.remove(panelActual);
        panelActual = panel;
        this.add(panelActual);
        this.revalidate();
        this.repaint();
    }

    /**Este metodo cierra VentanaJuego*/
    public void cerrarVantanaJuego (){
        this.dispose();
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public JPanel getPanelActual() {
        return panelActual;
    }

    public void setPanelActual(JPanel panelActual) {
        this.panelActual = panelActual;
    }

    public String toString(){
        return "Esta clase sirve de contenedor para los paneles que que constituyen la GUI del juego";
    }
}

package GUITorneo;
import GUIJuego.MenuInicial;
import GUIJuego.VentanaJuego;
import LogicaTorneo.Torneo;

import javax.swing.*;
import java.awt.*;

public class VentanaTorneo extends JFrame {
    private BracketTorneo bracketTorneo;

    /**Constructor de la clase que configura las dimensiones de la ventana, la posisiona en pantalla,
     * establece el termino de la aplicación cuando se presiona el icono de cerrar ventana,
     * agrega una instancia de MenuInicial al JFrame y lo hace visible.*/
    public VentanaTorneo(BracketTorneo bracketTorneo){
        this.setPreferredSize(new Dimension(800,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.bracketTorneo=bracketTorneo;
        this.add(bracketTorneo);
        this.pack();
        this.setLocationRelativeTo(VentanaJuego.getInstancia());
        //*setExtendedState(JFrame.MAXIMIZED_BOTH);*/
    }

    public void abrirVentana(){
        this.setVisible(true);
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
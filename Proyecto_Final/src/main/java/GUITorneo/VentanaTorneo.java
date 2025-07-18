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
        this.setPreferredSize(new Dimension(800,600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.bracketTorneo=bracketTorneo;
        this.add(bracketTorneo);
    }

    /**Este metodo crea la única instancia de VentanaJuego que se usara en el juego si no existe
     * o retorna esta misma instancia si ya fue creada.
     * @return instancia es la única instancia de esta clase que sera usada en el juego.
     * */
    public static VentanaTorneo getInstancia(BracketTorneo bracketTorneo){
        if(instancia==null){
            instancia = new VentanaTorneo(bracketTorneo);
        }
        return instancia;
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

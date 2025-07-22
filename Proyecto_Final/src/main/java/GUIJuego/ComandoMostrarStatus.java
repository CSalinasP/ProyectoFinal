// Nuevo archivo: GUIJuego/ComandoMostrarStatus.java
package GUIJuego;
import GUITorneo.BracketES;
import GUITorneo.BracketLS;
import GUITorneo.VentanaTorneo;
import GUITorneo.BracketTorneo;
import LogicaTorneo.EliminatoriaSimple;

import javax.swing.*;

public class ComandoMostrarStatus implements Comando {

    public ComandoMostrarStatus() {
    }

    @Override
    public void ejecutar() {
        if(VentanaJuego.getInstancia().getTorneoActual() instanceof EliminatoriaSimple){
            VentanaTorneo statusFrame = new VentanaTorneo(new BracketES());
            statusFrame.abrirVentana();
        }
        else {
            VentanaTorneo statusFrame = new VentanaTorneo(new BracketLS());
            statusFrame.abrirVentana();
        }
    }
}
// Nuevo archivo: GUIJuego/ComandoMostrarStatus.java
package GUIJuego;
import GUITorneo.BracketES;
import GUITorneo.VentanaTorneo;
import GUITorneo.BracketTorneo;

import javax.swing.*;

public class ComandoMostrarStatus implements Comando {

    public ComandoMostrarStatus() {
    }

    @Override
    public void ejecutar() {
        VentanaTorneo statusFrame = new VentanaTorneo(new BracketES());
        statusFrame.abrirVentana();
    }
}
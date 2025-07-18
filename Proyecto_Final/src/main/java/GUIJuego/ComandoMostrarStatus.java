// Nuevo archivo: GUIJuego/ComandoMostrarStatus.java
package GUIJuego;

import javax.swing.*;

import GUITorneo.BracketES;
import GUITorneo.VentanaTorneo;
import LogicaTorneo.*;
import GUIJuego.*;
import java.awt.*;

public class ComandoMostrarStatus implements Comando {

    public ComandoMostrarStatus() {
    }

    @Override
    public void ejecutar() {
        VentanaTorneo.getInstancia(new BracketES()).abrirVentana();
    }
}
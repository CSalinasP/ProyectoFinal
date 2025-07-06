// Nuevo archivo: GUIJuego/ComandoMostrarStatus.java
package GUIJuego;

import javax.swing.*;
import java.awt.*;

public class ComandoMostrarStatus implements Comando {

    public ComandoMostrarStatus() {
    }

    @Override
    public void ejecutar() {
        JFrame statusFrame = new JFrame("Bracket del Torneo");
        statusFrame.setSize(400, 300);
        statusFrame.setLocationRelativeTo(VentanaJuego.getInstancia()); // Posiciona relativo a la ventana principal
        statusFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cierra esta ventana
                statusFrame.setVisible(true);
    }
}
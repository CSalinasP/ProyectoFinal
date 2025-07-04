// Nuevo archivo: JuegoGUI/ComandoMostrarStatus.java
package JuegoGUI;

import javax.swing.*;
import java.awt.*;

public class ComandoMostrarStatus implements Comando {
    private VentanaJuego ventanaJuego; // O podrías pasárselo al constructor del JFrame de Status

    public ComandoMostrarStatus(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    @Override
    public void ejecutar() {
        // Abre un nuevo JFrame para mostrar el status
        JFrame statusFrame = new JFrame("Estado del Juego");
        statusFrame.setSize(400, 300);
        statusFrame.setLocationRelativeTo(ventanaJuego); // Posiciona relativo a la ventana principal
        statusFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cierra esta ventana

        // Puedes añadir aquí la lógica para mostrar la información de status
        // Por ejemplo, un JLabel con texto o un JPanel más complejo
        JLabel statusLabel = new JLabel("<html><body><p>Aquí se mostraría el estado del torneo, personajes, etc.</p><p>Total de combates: X</p><p>Personajes desbloqueados: Y</p></body></html>");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusFrame.add(statusLabel, BorderLayout.CENTER);

        statusFrame.setVisible(true);
    }
}
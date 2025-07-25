package GUIJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Derrota extends JPanel {
    private final String mensaje;

    /**
     * Constructor para el panel de derrota.
     * @param mensaje El mensaje a mostrar en el panel.
     */
    public Derrota(String mensaje, JPanel jPanel) {
        this.mensaje = mensaje;
        setBackground(new Color(70, 70, 70)); // Un gris oscuro para la derrota
        setLayout(new GridBagLayout()); // Usamos GridBagLayout para centrar el mensaje

        JLabel labelMensaje = new JLabel(mensaje);
        labelMensaje.setFont(new Font("Arial", Font.BOLD, 48));
        labelMensaje.setForeground(Color.LIGHT_GRAY); // Texto gris claro para un ambiente más sombrío
        add(labelMensaje);

        iniciarTemporizador(jPanel);
    }

    private void iniciarTemporizador(JPanel jPanel) {
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Al finalizar el temporizador, cambiamos al MenuInicial
                VentanaJuego.getInstancia().cambiarPanel(jPanel);
            }
        });
        timer.setRepeats(false); // Para que el temporizador se ejecute solo una vez
        timer.start();
    }
}

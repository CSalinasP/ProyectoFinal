package GUIJuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Victoria extends JPanel {
    private final String mensaje;

    /**
     * Constructor para el panel de victoria.
     * @param mensaje El mensaje a mostrar en el panel.
     */
    public Victoria(String mensaje, JPanel jPanel) {
        this.mensaje = mensaje;
        setBackground(new Color(135, 206, 250)); // Un azul cielo vibrante para la victoria
        setLayout(new GridBagLayout()); // Usamos GridBagLayout para centrar el mensaje

        JLabel labelMensaje = new JLabel(mensaje);
        labelMensaje.setFont(new Font("Arial", Font.BOLD, 48));
        labelMensaje.setForeground(Color.WHITE); // Texto blanco para contrastar
        add(labelMensaje);

        iniciarTemporizador(jPanel);
    }

    private void iniciarTemporizador(JPanel jPanel) {
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Al finalizar el temporizador, cambiamos al MenuInicial
                VentanaJuego.getInstancia().cambiarPanel(jPanel);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
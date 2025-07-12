package GUIMenu;

import javax.swing.*;
import java.awt.*;

/*
Crear la imagen del grafico para torneo con GridBagLayout
 */
public class BracketES extends BracketTorneo {
    private JPanel EliminatoriaSimple;
    private JLabel casilla;

    public BracketES() {
        // Inicializar panel principal si viene de la clase padre
        super(); // Asegura que el constructor padre se llame

        // Usar GridBagLayout para la configuración de casillas
        EliminatoriaSimple = new JPanel(new GridBagLayout());
        EliminatoriaSimple.setPreferredSize(new Dimension(600, 400));
        EliminatoriaSimple.setBackground(Color.WHITE);

        // Configuración de las casillas en el GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margen entre elementos
        gbc.fill = GridBagConstraints.BOTH; // Rellenar el espacio de la celda

        // Crear ejemplo de casillas para la primera ronda
        int numberOfRounds = 3;
        int players = 8; // Número de jugadores en la primera ronda

        for (int ronda = 0; ronda < numberOfRounds; ronda++) {
            for (int i = 0; i < players / 2; i++) {
                JLabel casilla = new JLabel("R " + (ronda + 1) + " - J " + (i + 1), SwingConstants.CENTER);
                casilla.setOpaque(true);
                casilla.setBackground(Color.RED);
                casilla.setForeground(Color.WHITE);

                // Configuración de la posición en la cuadrícula
                gbc.gridx = ronda; // Columna indica la ronda
                gbc.gridy = i; // Fila indica el jugador
                gbc.weightx = 1.0; // Pesos para distribuir las celdas proporcionalmente
                gbc.weighty = 1.0;

                EliminatoriaSimple.add(casilla, gbc); // Añadir al panel con las restricciones
            }
            players /= 2; // Reducir el número de jugadores en cada ronda
        }

        panel.add(EliminatoriaSimple); // Asume que 'panel' está definido en BracketTorneo
    }

    @Override
    protected void configurarPanel() {
        panel.setBorder(BorderFactory.createTitledBorder("Eliminatoria Simple"));
    }

    @Override
    protected void agregarListeners() {
        // Agrega tus eventos si los necesitas
    }

    @Override
    public void actualizarPanel() {
        System.out.println("Actualizando...");
        EliminatoriaSimple.repaint(); // Para redibujar las casillas
    }
}
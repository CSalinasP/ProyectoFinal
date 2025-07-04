package GUIJuego; // Asegúrate de que esté en el mismo paquete o ajústalo

import javax.swing.*;
import java.awt.*;

public class TestGUI extends JPanel {

    public TestGUI() {
        // Establecemos un BorderLayout para este JPanel principal.
        // Esto nos permitirá centrar otro JPanel que contendrá la rejilla vertical.
        setLayout(new BorderLayout());

        // --- Panel Contenedor Central ---
        // Este panel usará GridLayout para organizar sus componentes verticalmente.
        JPanel panelCentralContenedor = new JPanel();
        // GridLayout(filas, columnas, espacioHorizontal, espacioVertical)
        // Aquí, 3 filas, 1 columna, sin espacios entre componentes.
        panelCentralContenedor.setLayout(new GridLayout(3, 1, 0, 0));
        panelCentralContenedor.setBackground(Color.LIGHT_GRAY); // Para visualizarlo

        // --- Panel 1 ---
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.add(new JLabel("Panel Superior")); // Añadimos un JLabel para que sea visible
        panelCentralContenedor.add(panel1);

        // --- Panel 2 ---
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.add(new JLabel("Panel Medio"));
        panelCentralContenedor.add(panel2);

        // --- Panel 3 (Subdividido) ---
        JPanel panel3 = new JPanel();
        // Usamos otro GridLayout para dividir este panel en 2 columnas (o 2 filas si lo prefieres)
        panel3.setLayout(new GridLayout(1, 2, 5, 5)); // 1 fila, 2 columnas, con espacios
        panel3.setBackground(Color.GREEN); // Fondo del panel contenedor de la subdivisión

        // Sub-Panel 3.1
        JPanel subPanel3_1 = new JPanel();
        subPanel3_1.setBackground(Color.YELLOW);
        subPanel3_1.add(new JLabel("Sub-Panel 3.1"));
        panel3.add(subPanel3_1);

        // Sub-Panel 3.2
        JPanel subPanel3_2 = new JPanel();
        subPanel3_2.setBackground(Color.CYAN);
        subPanel3_2.add(new JLabel("Sub-Panel 3.2"));
        panel3.add(subPanel3_2);

        panelCentralContenedor.add(panel3); // Añadimos el Panel 3 (ya subdividido) al contenedor principal

        // Añadimos el panelCentralContenedor al centro de este JPanel principal.
        // Esto es lo que permite que todo el grupo de paneles se "centre" verticalmente
        // si el BorderLayout del JPanel padre lo permite (es decir, si no hay otros componentes
        // en NORTH o SOUTH que ocupen todo el espacio).
        this.add(panelCentralContenedor, BorderLayout.CENTER);

        // Para fines de visualización, podemos darle un borde al JPanel principal
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Margen alrededor
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz de usuario en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Diseño de Paneles Verticales");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400); // Tamaño de la ventana
            frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

            // Añadimos nuestro panel personalizado al JFrame
            frame.add(new TestGUI());

            frame.setVisible(true); // Hacer visible la ventana
        });
    }
}
package GUIMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//Asociar las imagenes

public class BotonesInicio extends JFrame implements ActionListener {
private JButton botonStart;
private JButton botonAvatares;
private JButton botonTorneos;
private JButton botonExit;
    public BotonesInicio() {
        try {
            ImageIcon startIcon = new ImageIcon(getClass().getResource("/GUIMenu/start.png"));
            JButton botonStart = new JButton();
            botonStart.addActionListener(this);
            botonStart.setIcon(startIcon);

            JButton botonAvatares = new JButton();
            botonAvatares.addActionListener(this);
            botonAvatares.setIcon(new ImageIcon(getClass().getResource("/GUIMenu/avatares.png")));

            JButton botonTorneos = new JButton();
            botonTorneos.addActionListener(this);
            botonTorneos.setIcon(new ImageIcon(getClass().getResource("/GUIMenu/torneos.png")));

            JButton botonExit = new JButton();
            botonExit.addActionListener(this);
            botonExit.setIcon(new ImageIcon(getClass().getResource("/GUIMenu/exit.png")));
            //Imagenes
        } catch (Exception ex) {
            System.err.println("Error al cargar las imágenes: " + ex.getMessage());
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonStart) {
            System.out.println("Botón Start presionado");
            // Aquí va la lógica para iniciar el juego
        }
        else if (e.getSource() == botonAvatares) {
            System.out.println("Botón Avatares presionado");
            // Aquí va la lógica para el menú de avatares
        }
        else if (e.getSource() == botonTorneos) {
            System.out.println("Botón Torneos presionado");
            // Aquí va la lógica para el menú de torneos
        }
        else if (e.getSource() == botonExit) {
            int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro que deseas salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {

    }
}
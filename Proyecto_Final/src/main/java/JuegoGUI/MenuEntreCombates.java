// Nuevo archivo: JuegoGUI/MenuEntreCombates.java
package JuegoGUI;

import Lógica.Personaje; // Asumo que tienes una clase Personaje en Lógica
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * JPanel que representa el menú que aparece entre combates.
 * Permite gestionar avatares, comenzar el siguiente combate,
 * volver al menú inicial o ver el estado del juego.
 * @author Francisco Arentsen (modificado por Asistente AI)
 */
public class MenuEntreCombates extends JPanel {
    private VentanaJuego ventanaJuego;
    private JPanel panelCentral;
    private JPanel seleccionAvatares;
    private BotonGenerico comenzar, volverInicio, status;

    public MenuEntreCombates(VentanaJuego ventanaJuego){
        this.ventanaJuego = ventanaJuego;
        this.setLayout(new BorderLayout());
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3,1,0,0));


    }


    /**private VentanaJuego ventanaJuego;
    private JPanel panelCentralPrincipal; // Contiene Avatares, Comenzar, Volver
    private JPanel panelSeleccionAvatares; // Contiene los 16 botones de avatares
    private BotonGenerico btnAvatares, btnComenzarCombate, btnVolverInicio;
    private BotonGenerico btnStatus; // Botón en la esquina superior derecha

    private ArrayList<BotonGenerico> botonesAvatares; // Lista para los 16 botones de avatar
    private boolean avatarSeleccionado = false; // Estado para habilitar/deshabilitar botón "Comenzar"

    public MenuEntreCombates(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
        this.setLayout(new BorderLayout()); // Layout principal del MenuEntreCombates

        // --- Panel Superior Derecho (para el botón de Status) ---
        JPanel panelSuperiorDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnStatus = new BotonGenerico(new ComandoMostrarStatus(ventanaJuego), "Status");
        btnStatus.addActionListener(e -> btnStatus.getComando().ejecutar());
        panelSuperiorDerecho.add(btnStatus);
        this.add(panelSuperiorDerecho, BorderLayout.NORTH); // Añadir al NORTE para que esté arriba

        // --- Panel Central Principal (Avatares, Comenzar, Volver) ---
        panelCentralPrincipal = new JPanel();
        panelCentralPrincipal.setLayout(new GridLayout(3, 1, 10, 10)); // Dividido en 3

        btnAvatares = new BotonGenerico(new ComandoMostrarOpciones(this), "Avatares");
        btnAvatares.addActionListener(e -> btnAvatares.getComando().ejecutar());

        btnComenzarCombate = new BotonGenerico(new ComandoComenzarCombate(ventanaJuego, this), "Comenzar Combate");
        btnComenzarCombate.addActionListener(e -> btnComenzarCombate.getComando().ejecutar());
        btnComenzarCombate.setEnabled(false); // Deshabilitado por defecto

        btnVolverInicio = new BotonGenerico(new ComandoVolverMenuInicial(ventanaJuego), "Volver al Inicio");
        btnVolverInicio.addActionListener(e -> btnVolverInicio.getComando().ejecutar());

        panelCentralPrincipal.add(btnAvatares);
        panelCentralPrincipal.add(btnComenzarCombate);
        panelCentralPrincipal.add(btnVolverInicio);

        // --- Panel de Selección de Avatares ---
        panelSeleccionAvatares = new JPanel();
        panelSeleccionAvatares.setLayout(new GridLayout(4, 4, 5, 5)); // 16 partes (4x4)
        botonesAvatares = new ArrayList<>();
        // Crear 16 botones de avatares (puedes personalizarlos con nombres/imágenes reales)
        for (int i = 0; i < 16; i++) {
            // Ejemplo: Suponiendo que tienes una forma de obtener personajes por índice o ID
            // Personaje personaje = obtenerPersonajePorIndice(i);
            // BotonGenerico btnAvatar = new BotonGenerico(new ComandoSeleccionarAvatar(this, personaje), "Avatar " + (i + 1));

            BotonGenerico btnAvatar = new BotonGenerico(new ComandoSeleccionarAvatar(this), "Avatar " + (i + 1));
            btnAvatar.addActionListener(e -> btnAvatar.getComando().ejecutar());
            botonesAvatares.add(btnAvatar);
            panelSeleccionAvatares.add(btnAvatar);
        }

        // --- Añadir el panel central principal por defecto ---
        this.add(panelCentralPrincipal, BorderLayout.CENTER);
    }

    /**
     * Muestra el panel central con los botones Avatares, Comenzar Combate, Volver al Inicio.

    public void MostrarOpcionesPrincipales() {
        this.remove(panelSeleccionAvatares); // Asegurarse de remover el otro
        this.add(panelCentralPrincipal, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    /**
     * Muestra el panel con la cuadrícula de 16 botones para seleccionar avatares.

    public void MostrarOpcionesAvatares() {
        this.remove(panelCentralPrincipal); // Asegurarse de remover el otro
        this.add(panelSeleccionAvatares, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    /**
     * Habilita o deshabilita el botón "Comenzar Combate".
     * @param habilitar true para habilitar, false para deshabilitar.

    public void habilitarComenzarCombate(boolean habilitar) {
        this.avatarSeleccionado = habilitar;
        btnComenzarCombate.setEnabled(habilitar);
    }

    // --- Getters para acceso desde los comandos si fuera necesario ---
    public VentanaJuego getVentanaJuego() {
        return ventanaJuego;
    }*/
}
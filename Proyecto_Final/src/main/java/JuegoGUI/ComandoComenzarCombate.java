// Nuevo archivo: JuegoGUI/ComandoComenzarCombate.java
package JuegoGUI;

import javax.swing.*;

public class ComandoComenzarCombate implements Comando {
    private VentanaJuego ventanaJuego;
    private MenuEntreCombates menuEntreCombates; // Referencia para deshabilitar/habilitar cosas si es necesario

    public ComandoComenzarCombate(VentanaJuego ventanaJuego, MenuEntreCombates menuEntreCombates) {
        this.ventanaJuego = ventanaJuego;
        this.menuEntreCombates = menuEntreCombates;
    }

    @Override
    public void ejecutar() {
        // Aquí deberías crear y pasar los personajes seleccionados a Arena
        // Por ahora, Arena está en blanco como pediste
        ventanaJuego.cambiarPanel(new Arena()); // Asumo que Arena es un JPanel
        System.out.println("Cambiando a la Arena de Combate.");
    }
}
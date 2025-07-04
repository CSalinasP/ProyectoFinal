// Nuevo archivo: JuegoGUI/ComandoVolverMenuInicial.java
package JuegoGUI;

import javax.swing.*;

public class ComandoVolverMenuInicial implements Comando {
    private VentanaJuego ventanaJuego;

    public ComandoVolverMenuInicial(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    @Override
    public void ejecutar() {
        ventanaJuego.cambiarPanel(new MenuInicial(ventanaJuego)); // Crea una nueva instancia de MenuInicial
        System.out.println("Volviendo al Menú Inicial.");
    }
}
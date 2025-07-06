// Nuevo archivo: GUIJuego/ComandoVolverMenuInicial.java
package GUIJuego;

public class ComandoVolverMenuInicial implements Comando {

    public ComandoVolverMenuInicial() {}

    @Override
    public void ejecutar() {
        VentanaJuego.getInstancia().cambiarPanel(new MenuInicial()); // Crea una nueva instancia de MenuInicial
    }
}
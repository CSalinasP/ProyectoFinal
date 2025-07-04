package GUIJuego;

public class ComandoSalir implements Comando{
    VentanaJuego ventanaJuego;

    public ComandoSalir(VentanaJuego ventanaJuego){
        this.ventanaJuego = ventanaJuego;
    }

    @Override
    public void ejecutar() {
        ventanaJuego.cerrarVantanaJuego();
    }
}

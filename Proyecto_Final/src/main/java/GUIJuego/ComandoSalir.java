package GUIJuego;

public class ComandoSalir implements Comando{

    public ComandoSalir(){
    }

    @Override
    public void ejecutar() {
        VentanaJuego.getInstancia().cerrarVantanaJuego();
    }
}

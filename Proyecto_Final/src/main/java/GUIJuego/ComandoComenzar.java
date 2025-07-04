package GUIJuego;
import LogicaTorneo.Torneo;

public class ComandoComenzar implements Comando{
    private VentanaJuego ventanaJuego;
    private OpcionesTorneo tipoTorneo;
    private OpcionesAvatares avatares;

    public ComandoComenzar(VentanaJuego ventanaJuego, OpcionesTorneo tipoTorneo, OpcionesAvatares avatares){
        this.ventanaJuego = ventanaJuego;
        this.tipoTorneo = tipoTorneo;
        this.avatares = avatares;
    }

    @Override
    public void ejecutar() {
        if(tipoTorneo!=null && avatares!=null){
            ventanaJuego.setTorneo(new Torneo(tipoTorneo.getTipoTorneo(), avatares.getAvatares()));
            ventanaJuego.cambiarPanel(new MenuEntreCombates(ventanaJuego));
        }
    }
}

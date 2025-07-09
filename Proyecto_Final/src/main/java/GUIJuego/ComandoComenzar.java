package GUIJuego;
import LogicaJuego.PlanillaPersonajes;
import LogicaTorneo.FabricaTorneos;

public class ComandoComenzar implements Comando{
    private OpcionesTorneo tipoTorneo;
    private OpcionesNiveles opcionesNiveles;

    public ComandoComenzar(OpcionesTorneo tipoTorneo, OpcionesNiveles opcionesNiveles){
        this.tipoTorneo = tipoTorneo;
        this.opcionesNiveles = opcionesNiveles;
    }

    @Override
    public void ejecutar() {
        if(tipoTorneo!=null){
            VentanaJuego.getInstancia().setTorneoActual(FabricaTorneos.crearTorneo(tipoTorneo.getTipoTorneo()));
            VentanaJuego.getInstancia().cambiarPanel(new MenuEntreCombates());
        }
    }
}

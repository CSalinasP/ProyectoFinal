package GUIJuego;
import LogicaJuego.PlanillaPersonajes;
import LogicaTorneo.FabricaTorneos;

public class ComandoComenzar implements Comando{
    private OpcionesTorneo tipoTorneo;
    private OpcionesAvatares avatares;

    public ComandoComenzar(OpcionesTorneo tipoTorneo, OpcionesAvatares avatares){
        this.tipoTorneo = tipoTorneo;
        this.avatares = avatares;
    }

    @Override
    public void ejecutar() {
        if(tipoTorneo.getTipoTorneo()!=null && !avatares.getAvatares().isEmpty()){
            VentanaJuego.getInstancia().setTorneo(FabricaTorneos.crearTorneo(tipoTorneo.getTipoTorneo()));
            PlanillaPersonajes.getInstance().añadirPersonaje(avatares.getAvatares().getFirst());
            VentanaJuego.getInstancia().cambiarPanel(new MenuEntreCombates());
        }
    }
}

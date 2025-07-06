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
        if(tipoTorneo!=null && avatares.getAvatares().size()==2){
            VentanaJuego.getInstancia().setTorneo(FabricaTorneos.crearTorneo(tipoTorneo.getTipoTorneo()));
            PlanillaPersonajes.getInstance().añadirPersonaje(avatares.getAvatares().get(0));
            PlanillaPersonajes.getInstance().añadirPersonaje(avatares.getAvatares().get(1));
            VentanaJuego.getInstancia().cambiarPanel(new MenuEntreCombates());
        }
    }
}

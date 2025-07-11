package GUIJuego;
import LogicaJuego.*;
import LogicaTorneo.FabricaTorneos;

public class ComandoComenzar implements Comando{
    private OpcionesTorneo tipoTorneo;

    public ComandoComenzar(OpcionesTorneo tipoTorneo){
        this.tipoTorneo = tipoTorneo;
    }

    @Override
    public void ejecutar() {
        if(tipoTorneo!=null){
            VentanaJuego.getInstancia().setTorneoActual(FabricaTorneos.crearTorneo(tipoTorneo.getTipoTorneo()));
            PlanillaPersonajes.getInstance().añadirPersonaje(TipoPersonaje.HUMANO,1);
            PlanillaPersonajes.getInstance().añadirPersonaje(TipoPersonaje.CABALLERO,1);
            PlanillaPersonajes.getInstance().añadirPersonaje(TipoPersonaje.CAVERNARIO,1);
            PlanillaPersonajes.getInstance().añadirPersonaje(TipoPersonaje.NOMUERTO,1);
            VentanaJuego.getInstancia().cambiarPanel(new MenuEntreCombates());
        }
    }
}

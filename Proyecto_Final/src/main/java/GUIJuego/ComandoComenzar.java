package GUIJuego;
import LogicaJuego.*;
import LogicaTorneo.*;

public class ComandoComenzar implements Comando{
    private OpcionesTorneo tipoTorneo;

    public ComandoComenzar(OpcionesTorneo tipoTorneo){
        this.tipoTorneo = tipoTorneo;
    }

    @Override
    public void ejecutar() {
        if(tipoTorneo.getTipoTorneo()!=null){
            PlanillaPersonajes.getInstance().añadirPersonaje(TipoPersonaje.HUMANO,1);
            PlanillaPersonajes.getInstance().añadirPersonaje(TipoPersonaje.CABALLERO,1);
            PlanillaPersonajes.getInstance().añadirPersonaje(TipoPersonaje.CAVERNARIO,1);
            PlanillaPersonajes.getInstance().añadirPersonaje(TipoPersonaje.NOMUERTO,1);
            VentanaJuego.getInstancia().setTorneoActual(FabricaTorneos.crearTorneo(tipoTorneo.getTipoTorneo(), ((MenuInicial) VentanaJuego.getInstancia().getPanelActual()).getNumNiveles()));
            VentanaJuego.getInstancia().cambiarPanel(new MenuEntreCombates());
        }
    }
}

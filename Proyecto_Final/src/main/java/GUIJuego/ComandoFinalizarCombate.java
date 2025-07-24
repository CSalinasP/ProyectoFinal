package GUIJuego;

import LogicaJuego.Combate;
import LogicaJuego.PlanillaPersonajes;
import LogicaTorneo.*;

public class ComandoFinalizarCombate implements Comando {
    private Combate combateActual;
    public ComandoFinalizarCombate(Combate combateActual){
        this.combateActual = combateActual;
    }
    public void ejecutar(){
        combateActual.finalizarCombate();
    }
}

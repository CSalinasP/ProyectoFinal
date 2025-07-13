package GUIJuego;

import LogicaJuego.Combate;
import LogicaTorneo.*;

public class ComandoFinalizarCombate implements Comando {
    private Combate combateActual;
    public ComandoFinalizarCombate(Combate combateActual){
        this.combateActual = combateActual;
    }
    public void ejecutar(){
        if(VentanaJuego.getInstancia().getTorneoActual().getNiveles()==0){
            if(combateActual.getGanador()==true) {
                VentanaJuego.getInstancia().getTorneoActual().setNiveles(VentanaJuego.getInstancia().getTorneoActual().getNiveles() - 1);
                VentanaJuego.getInstancia().cambiarPanel(new Victoria("HAS GANADO ESTA RONDA", new MenuEntreCombates()));
            }
            else{
                VentanaJuego.getInstancia().getTorneoActual().setNiveles(VentanaJuego.getInstancia().getTorneoActual().getNiveles() - 1);
                VentanaJuego.getInstancia().cambiarPanel(new Derrota("HAS PERDIDO ESTA RONDA", new MenuEntreCombates()));
            }
        }
        else{
            if(combateActual.getGanador()==true){
                VentanaJuego.getInstancia().cambiarPanel(new Victoria("HAS GANADO EL JUEGO", new MenuInicial()));
            }
            else{
                VentanaJuego.getInstancia().cambiarPanel(new Derrota("HAS PERDIDO EL JUEGO", new MenuInicial()));
            }
        }
    }
}

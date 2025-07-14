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
        if(VentanaJuego.getInstancia().getTorneoActual().getNiveles()>1){
            if(VentanaJuego.getInstancia().getTorneoActual() instanceof EliminatoriaSimple) {
                if (combateActual.getGanador() == true) {
                    VentanaJuego.getInstancia().getTorneoActual().resultadosEnfrentamientos();
                    PlanillaPersonajes.getInstance().getPersonajes().get(0).subirNivel();
                    PlanillaPersonajes.getInstance().getPersonajes().get(1).subirNivel();
                    PlanillaPersonajes.getInstance().getPersonajes().get(2).subirNivel();
                    PlanillaPersonajes.getInstance().getPersonajes().get(3).subirNivel();
                    VentanaJuego.getInstancia().getTorneoActual().setNiveles(VentanaJuego.getInstancia().getTorneoActual().getNiveles() - 1);
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("HAS GANADO ESTA RONDA", new MenuEntreCombates()));
                } else {
                    VentanaJuego.getInstancia().getTorneoActual().resultadosEnfrentamientos();
                    VentanaJuego.getInstancia().cambiarPanel(new Derrota("HAS PERDIDO EL JUEGO", new MenuInicial()));
                }
            }

            else{
                if (combateActual.getGanador() == true) {
                    combateActual.getAvatar().aumentarPuntaje();
                    VentanaJuego.getInstancia().getTorneoActual().getCompetidores().getFirst().disminuirPuntaje();
                    VentanaJuego.getInstancia().getTorneoActual().resultadosEnfrentamientos();
                    VentanaJuego.getInstancia().getTorneoActual().setNiveles(VentanaJuego.getInstancia().getTorneoActual().getNiveles() - 1);
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("HAS GANADO ESTA RONDA", new MenuEntreCombates()));
                } else {
                    combateActual.getAvatar().disminuirPuntaje();
                    VentanaJuego.getInstancia().getTorneoActual().getCompetidores().getFirst().aumentarPuntaje();
                    VentanaJuego.getInstancia().getTorneoActual().resultadosEnfrentamientos();
                    VentanaJuego.getInstancia().getTorneoActual().setNiveles(VentanaJuego.getInstancia().getTorneoActual().getNiveles() - 1);
                    VentanaJuego.getInstancia().cambiarPanel(new Derrota("HAS PERDIDO ESTA RONDA", new MenuInicial()));
                }
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

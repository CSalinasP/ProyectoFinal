// Nuevo archivo: GUIJuego/ComandoComenzarCombate.java
package GUIJuego;
import LogicaJuego.*;
import LogicaTorneo.*;

import LogicaJuego.Personaje_NoMuerto;

public class ComandoComenzarCombate implements Comando {
    private MenuEntreCombates menuEntreCombates;

    public ComandoComenzarCombate(MenuEntreCombates menuEntreCombates) {
        this.menuEntreCombates = menuEntreCombates;
    }

    @Override
    public void ejecutar() {
        if(menuEntreCombates.getPersonajeSeleccionado()!=null){
            VentanaJuego.getInstancia().cambiarPanel(new Arena(new Combate(PlanillaPersonajes.getInstance().seleccionarPersonaje(menuEntreCombates.getPersonajeSeleccionado()), VentanaJuego.getInstancia().getTorneoActual())));
        }
    }
}
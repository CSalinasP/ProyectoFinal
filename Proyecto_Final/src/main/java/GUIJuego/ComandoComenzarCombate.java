// Nuevo archivo: GUIJuego/ComandoComenzarCombate.java
package GUIJuego;
import LogicaJuego.*;
import LogicaTorneo.*;

import LogicaJuego.Personaje_NoMuerto;

public class ComandoComenzarCombate implements Comando {
    private VentanaJuego ventanaJuego;
    private MenuEntreCombates menuEntreCombates;

    public ComandoComenzarCombate(MenuEntreCombates menuEntreCombates, VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
        this.menuEntreCombates = menuEntreCombates;
    }

    @Override
    public void ejecutar() {
        if(menuEntreCombates.getPersonajeSeleccionado()!=null){
            ventanaJuego.cambiarPanel(new Arena(new Combate(PlanillaPersonajes.getInstance().seleccionarPersonaje(menuEntreCombates.getPersonajeSeleccionado()), ventanaJuego.getTorneo())));
        }
    }
}
// Nuevo archivo: GUIJuego/ComandoComenzarCombate.java
package GUIJuego;
import LogicaJuego.*;

public class ComandoComenzarCombate implements Comando {
    private MenuEntreCombates menuEntreCombates;

    public ComandoComenzarCombate(MenuEntreCombates menuEntreCombates) {
        this.menuEntreCombates = menuEntreCombates;
    }

    @Override
    public void ejecutar() {
        if(menuEntreCombates.getPersonajeSeleccionado()!=null){
            VentanaJuego.getInstancia().cambiarPanel(new Arena(new Combate(VentanaJuego.getInstancia().getTorneoActual())));
        }
    }
}
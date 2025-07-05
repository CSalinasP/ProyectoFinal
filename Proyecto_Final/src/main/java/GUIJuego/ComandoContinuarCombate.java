package GUIJuego;

import LogicaJuego.Combate;

public class ComandoContinuarCombate implements Comando {
    private Combate combate;
    public ComandoContinuarCombate(Combate combate){
        this.combate = combate;
    }
    public void ejecutar(){
        VentanaJuego.getInstancia().cambiarPanel(new Arena(combate));
    }
}

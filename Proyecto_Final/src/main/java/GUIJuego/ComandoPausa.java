package GUIJuego;
import LogicaJuego.Combate;

public class ComandoPausa implements Comando{
    private Combate combate;

    public ComandoPausa(Combate combate){
        this.combate = combate;
    }

    @Override
    public void ejecutar() {
        VentanaJuego.getInstancia().cambiarPanel(new MenuPausa(combate));
    }
}

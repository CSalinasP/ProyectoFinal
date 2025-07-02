package JuegoGUI;
import javax.swing.*;
import java.awt.*;

public class OpcionesAvatares extends JPanel {
    public OpcionesAvatares(MenuInicial menuInicial){
        this.setLayout(new GridLayout(1,4,0,0));
        this.add(new BotonGenerico(new ComandoEjemplo(), "Hombre"));
        this.add(new BotonGenerico(new ComandoEjemplo(), "Caballero"));
        this.add(new BotonGenerico(new ComandoEjemplo(), "Cavernarioi"));
        this.add(new BotonGenerico(new ComandoEjemplo(), "No-Muerto"));
    }
}

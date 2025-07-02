package JuegoGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OpcionesTorneo extends JPanel {
    private MenuInicial menuInicial;
    private BotonGenerico b;
    private ArrayList<BotonGenerico> botones;

    public OpcionesTorneo(MenuInicial menuInicial){
        this.menuInicial = menuInicial;
        b= new BotonGenerico(new ComandoEjemplo(),"Modalidad de Torneo");
    }

    public BotonGenerico getb(){
        return b;
    }
    public ArrayList<BotonGenerico> getBotones(){
        return botones;
    }
}

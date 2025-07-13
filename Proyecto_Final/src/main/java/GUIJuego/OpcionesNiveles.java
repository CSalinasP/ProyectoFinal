package GUIJuego;

import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OpcionesNiveles extends JPanel {
    private BotonGenerico niveles;
    private ArrayList<BotonGenerico> botones;

    public OpcionesNiveles(){
        this.setBackground(Color.blue);
        niveles = new BotonGenerico(new ComandoMostrarOpciones(this),"Opciones de Niveles", 1000, 100);
        niveles.addActionListener(k-> niveles.getComando().ejecutar());
        this.add(niveles);

        botones = new ArrayList<>();
        for(int i = 1; i<=10; i++){
            BotonGenerico btnNivel = new BotonGenerico(null, String.valueOf(i));
            btnNivel.setComando(new ComandoOcultarOpciones(this, btnNivel));
            btnNivel.addActionListener(e-> btnNivel.getComando().ejecutar());
            botones.add(btnNivel);
        }
    }

    public void MostrarOpciones(){
        this.remove(niveles);
        this.setLayout(new GridLayout(1,10,0,0));
        for(JButton avatar : botones){
            this.add(avatar);
        }
        this.revalidate();
        this.repaint();
    }

    public void OcultarOpciones(String numNiveles){
        ((MenuInicial) VentanaJuego.getInstancia().getPanelActual()).setNumNiveles(Integer.parseInt(numNiveles));
        for(JButton avatar : botones){
            this.remove(avatar);
        }
        this.setLayout(new GridLayout(1,1,0,0));
        this.add(niveles);
        this.revalidate();
        this.repaint();
    }

    public BotonGenerico getNiveles(){
        return niveles;
    }
    public ArrayList<BotonGenerico> getBotones(){
        return botones;
    }
}

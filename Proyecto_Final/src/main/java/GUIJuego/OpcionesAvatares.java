package GUIJuego;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import LogicaJuego.TipoPersonaje;

public class OpcionesAvatares extends JPanel {
    private ArrayList<TipoPersonaje> avatares;
    private BotonGenerico a, b, c, d, e;
    private ArrayList<BotonGenerico> botones;

    public OpcionesAvatares(){
        this.setBackground(Color.blue);
        a= new BotonGenerico(new ComandoMostrarOpciones(this),"Opciones de Avatares", 1000, 100);
        a.addActionListener(k->a.getComando().ejecutar());
        this.add(a);

        b= new BotonGenerico(null, "Humano", "/16bit.png", 64, 64);
        b.setComando(new ComandoOcultarOpciones(this, b));
        b.addActionListener(k->b.getComando().ejecutar());
        c= new BotonGenerico(null, "Cavernario", "/16bit.png", 64, 64);
        c.setComando(new ComandoOcultarOpciones(this, c));
        c.addActionListener(k->c.getComando().ejecutar());
        d= new BotonGenerico(null, "Caballero", "/16bit.png", 64, 64);
        d.setComando(new ComandoOcultarOpciones(this, d));
        d.addActionListener(k->d.getComando().ejecutar());
        e= new BotonGenerico(null, "No-Muerto", "/16bit.png", 64, 64);
        e.setComando(new ComandoOcultarOpciones(this, e));
        e.addActionListener(k->e.getComando().ejecutar());

        botones = new ArrayList<>(); botones.add(b); botones.add(c); botones.add(d); botones.add(e);

        avatares = new ArrayList<>();
    }

    public void MostrarOpciones(){
        avatares.clear();
        this.remove(a);
        this.setLayout(new GridLayout(1,4,0,0));
        this.add(botones.get(0)); this.add(botones.get(1)); this.add(botones.get(2)); this.add(botones.get(3));
        this.revalidate();
        this.repaint();
    }

    public void OcultarOpciones(String tipo){
        if(tipo.equals("Humano")){
            avatares.add(TipoPersonaje.HUMANO);
        }
        else if(tipo.equals("Cavallero")){
            avatares.add(TipoPersonaje.CABALLERO);
        }
        else if(tipo.equals("Cavernario")){
            avatares.add(TipoPersonaje.CAVERNARIO);
        }
        else{avatares.add(TipoPersonaje.NOMUERTO);}
        this.remove(botones.get(0)); this.remove(botones.get(1)); this.remove(botones.get(2)); this.remove(botones.get(3));
        this.setLayout(new GridLayout(1,1,0,0));
        this.add(a);
        this.revalidate();
        this.repaint();
        VentanaJuego.getInstancia().getPanelActual().revalidate();
        VentanaJuego.getInstancia().getPanelActual().repaint();
    }

    public ArrayList<TipoPersonaje> getAvatares() {
        return avatares;
    }

    public BotonGenerico geta(){
        return a;
    }
    public ArrayList<BotonGenerico> getBotones(){
        return botones;
    }
}
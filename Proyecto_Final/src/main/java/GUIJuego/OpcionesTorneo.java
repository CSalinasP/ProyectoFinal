package GUIJuego;

import LogicaTorneo.TipoTorneo;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OpcionesTorneo extends JPanel {
    private TipoTorneo tipoTorneo;
    private BotonGenerico a, b, c, d;
    private ArrayList<BotonGenerico> botones;

    public OpcionesTorneo(){
        this.setBackground(Color.blue);
        a= new BotonGenerico(new ComandoMostrarOpciones(this),"Modalidad de Torneo", 1000, 100);
        a.addActionListener(e->a.getComando().ejecutar());
        this.add(a);

        b= new BotonGenerico(null, "Eliminatoria Simple");
        b.setComando(new ComandoOcultarOpciones(this, b));
        b.addActionListener(e->b.getComando().ejecutar());
        c= new BotonGenerico(null, "Eliminatoria Doble");
        c.setComando(new ComandoOcultarOpciones(this, c));
        c.addActionListener(e->c.getComando().ejecutar());
        d= new BotonGenerico(null, "Liga Simple");
        d.setComando(new ComandoOcultarOpciones(this, d));
        d.addActionListener(e->d.getComando().ejecutar());

        botones = new ArrayList<>(); botones.add(b); botones.add(c); botones.add(d);

        tipoTorneo = null;
    }

    public void OcultarOpciones(String tipo){
        if(tipo.equals("Eliminatoria Simple")){
            this.setTipoTorneo(TipoTorneo.ELIMINATORIA_SIMPLE);
        }
        else if(tipo.equals("Eliminatoria Doble")){
            this.setTipoTorneo(TipoTorneo.ELIMINATORIA_DOBLE);
        }
        else{this.setTipoTorneo(TipoTorneo.LIGA_SIMPLE);}
        this.remove(botones.get(0)); this.remove(botones.get(1)); this.remove(botones.get(2));
        this.setLayout(new GridLayout(1,1,0,0));
        this.add(a);
        this.revalidate();
        this.repaint();
    }

    public void MostrarOpciones(){
        this.remove(a);
        this.setLayout(new GridLayout(1,3,0,0));
        this.add(botones.get(0)); this.add(botones.get(1)); this.add(botones.get(2));
        this.revalidate();
        this.repaint();
    }

    public TipoTorneo getTipoTorneo() {
        return tipoTorneo;
    }

    public void setTipoTorneo(TipoTorneo tipoTorneo){
        this.tipoTorneo=tipoTorneo;
    }

    public BotonGenerico geta(){
        return a;
    }
    public ArrayList<BotonGenerico> getBotones(){
        return botones;
    }
}

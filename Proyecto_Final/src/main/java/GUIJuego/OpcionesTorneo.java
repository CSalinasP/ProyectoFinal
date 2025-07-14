package GUIJuego;

import LogicaTorneo.TipoTorneo;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * La clase `OpcionesTorneo` es un `JPanel` que permite al usuario seleccionar
 * el tipo de torneo para el juego.
 */
public class OpcionesTorneo extends JPanel {
    private TipoTorneo tipoTorneo;
    private BotonGenerico a, b, c;
    private ArrayList<BotonGenerico> botones;

    /**
     * Constructor de la clase `OpcionesTorneo`. Configura el panel y sus componentes iniciales.
     */
    public OpcionesTorneo(){
        this.setBackground(Color.blue);
        a= new BotonGenerico(new ComandoMostrarOpciones(this),"Modalidad de Torneo", 1000, 100);
        a.addActionListener(e->a.getComando().ejecutar());
        this.add(a);

        b= new BotonGenerico(null, "Eliminatoria Simple");
        b.setComando(new ComandoOcultarOpciones(this, b));
        b.addActionListener(e->b.getComando().ejecutar());
        c= new BotonGenerico(null, "Liga Simple");
        c.setComando(new ComandoOcultarOpciones(this, c));
        c.addActionListener(e->c.getComando().ejecutar());

        botones = new ArrayList<>(); botones.add(b); botones.add(c);

        tipoTorneo = null;
    }

    /**
     * Oculta las opciones de torneo individuales y vuelve a mostrar el botón principal `a`.
     * También establece el tipo de torneo seleccionado según el parámetro `tipo`.
     * @param tipo La cadena que representa el tipo de torneo seleccionado ("Eliminatoria Simple" o "Liga Simple").
     */
    public void OcultarOpciones(String tipo){
        if(tipo.equals("Eliminatoria Simple")){
            this.setTipoTorneo(TipoTorneo.ELIMINATORIA_SIMPLE);
        }
        else{this.setTipoTorneo(TipoTorneo.LIGA_SIMPLE);}

        this.remove(botones.get(0)); this.remove(botones.get(1));
        this.setLayout(new GridLayout(1,1,0,0));
        this.add(a);
    }

    /**
     * Oculta el botón principal `a` y muestra las opciones de torneo individuales (`b` y `c`).
     */
    public void MostrarOpciones(){
        this.remove(a);
        this.setLayout(new GridLayout(1,2,0,0));
        this.add(botones.get(0)); this.add(botones.get(1));
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

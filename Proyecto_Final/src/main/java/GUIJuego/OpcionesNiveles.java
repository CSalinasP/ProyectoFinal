package GUIJuego;

import LogicaTorneo.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Esta clase `OpcionesNiveles` extiende `JPanel` y representa un componente de la interfaz gráfica
 * que permite al usuario seleccionar el numero de niveles para el juego. Inicialmente muestra
 * un botón para "Opciones de Niveles" y, al hacer clic, despliega una serie de botones
 * numerados del 1 al 10 para elegir el nivel.
 */
public class OpcionesNiveles extends JPanel {
    private BotonGenerico niveles;
    private ArrayList<BotonGenerico> botones;

    /**
     * Constructor de `OpcionesNiveles`. Configura el panel y sus componentes iniciales.
     */
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

    /**
     * Este método se encarga de cambiar la visualización del panel:
     * remueve el botón principal "Opciones de Niveles" y muestra
     * en su lugar los botones individuales para seleccionar cada nivel.
     */
    public void MostrarOpciones(){
        this.remove(niveles);
        if(((MenuInicial) VentanaJuego.getInstancia().getPanelActual()).getTipoTorneo().getTipoTorneo().equals(TipoTorneo.ELIMINATORIA_SIMPLE)) {
            this.setLayout(new GridLayout(1, 4, 0, 0));
            for (int i=0; i<4; i++) {
                this.add(botones.get(i));
            }
        }
        else{
            this.setLayout(new GridLayout(1, 10, 0, 0));
            for (int i=0; i<10; i++) {
                this.add(botones.get(i));
            }
        }
        this.revalidate();
        this.repaint();
    }

    /**
     * Este método se encarga de cambiar la visualización del panel de vuelta:
     * remueve los botones individuales de selección de nivel y vuelve a mostrar
     * el botón principal "Opciones de Niveles". También actualiza el número
     * de niveles seleccionado en el `MenuInicial`.
     * @param numNiveles El número del nivel seleccionado, pasado como una cadena de texto.
     */
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

    public void setNiveles(BotonGenerico niveles) {
        this.niveles = niveles;
    }

    public ArrayList<BotonGenerico> getBotones(){
        return botones;
    }

    public void setBotones(ArrayList<BotonGenerico> botones) {
        this.botones = botones;
    }

    @Override
    public String toString() {
        return "OpcionesNiveles{" +
                "niveles=" + (niveles != null ? niveles.toString() : "null") +
                ", botones=" + (botones != null ? botones.size() + " botones" : "null") +
                '}';
    }
}
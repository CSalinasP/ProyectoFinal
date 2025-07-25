package GUIJuego;
import javax.swing.*;
import java.awt.*;

/**
 * Clase que sirve de primer menu que permite al usuario escoger el tipo de torneo
 * en el que quiere participar y 2 avatares basicos de entre 4 opciones.
 * @author Francisco Arentsen
 */
public class MenuInicial extends JPanel {
    private JPanel panelCentral;
    private OpcionesTorneo tipoTorneo;
    private OpcionesNiveles tipoAvatares;
    private JPanel comienzoOsalida;
    private BotonGenerico comenzar, salir;
    private JPanel fondoSur, fondoNorte, fondoEste, fondoOeste;
    private int numNiveles;

    /**Constructor de la clase que configura sus dimensiones, color y la disposición
     * de los subpaneles ademas de inicializarlos y agregarlos. Tambien incializa los botones para
     * las opciones de Salir y Continuar, les aagrega los ActionListeners corresondientes
     * y los añade a sus respectivos subpaneles.
     * */
    public MenuInicial(){
        this.setLayout(new BorderLayout());
        numNiveles = 0;
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3,1,0,10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelCentral.setBackground(Color.blue);

        tipoTorneo = new OpcionesTorneo();
        tipoAvatares = new OpcionesNiveles();
        comienzoOsalida = new JPanel(); comienzoOsalida.setLayout(new GridLayout(1,2,10,0));
        comienzoOsalida.setBackground(Color.blue);
        comenzar = new BotonGenerico(new ComandoComenzar(tipoTorneo), "Comenzar");
        comenzar.addActionListener(e -> comenzar.getComando().ejecutar());
        salir = new BotonGenerico(new ComandoSalir(), "Salir");
        salir.addActionListener(e -> salir.getComando().ejecutar());
        comienzoOsalida.add(salir);
        comienzoOsalida.add(comenzar);
        panelCentral.add(tipoTorneo); panelCentral.add(tipoAvatares); panelCentral.add(comienzoOsalida);
        fondoSur = new JPanel();
        fondoSur.setPreferredSize(new Dimension(0,200));
        fondoSur.setBackground(Color.blue);
        fondoNorte = new JPanel();
        fondoNorte.setPreferredSize(new Dimension(0,200));
        fondoNorte.setBackground(Color.blue);
        fondoEste = new JPanel();
        fondoEste.setPreferredSize(new Dimension(200,0));
        fondoEste.setBackground(Color.blue);
        fondoOeste = new JPanel();
        fondoOeste.setPreferredSize(new Dimension(200,0));
        fondoOeste.setBackground(Color.blue);

        this.add(panelCentral, BorderLayout.CENTER);
        this.add(fondoNorte, BorderLayout.NORTH);
        this.add(fondoSur, BorderLayout.SOUTH);
        this.add(fondoEste, BorderLayout.EAST);
        this.add(fondoOeste, BorderLayout.WEST);
    }

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public void setPanelCentral(JPanel panelCentral) {
        this.panelCentral = panelCentral;
    }

    public OpcionesTorneo getTipoTorneo() {
        return tipoTorneo;
    }

    public void setTipoTorneo(OpcionesTorneo tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }

    public JPanel getComienzoOsalida() {
        return comienzoOsalida;
    }

    public void setComienzoOsalida(JPanel comienzoOsalida) {
        this.comienzoOsalida = comienzoOsalida;
    }

    public BotonGenerico getComenzar() {
        return comenzar;
    }

    public void setComenzar(BotonGenerico comenzar) {
        this.comenzar = comenzar;
    }

    public BotonGenerico getSalir() {
        return salir;
    }

    public void setSalir(BotonGenerico salir) {
        this.salir = salir;
    }

    public JPanel getFondoSur() {
        return fondoSur;
    }

    public void setFondoSur(JPanel fondoSur) {
        this.fondoSur = fondoSur;
    }

    public JPanel getFondoNorte() {
        return fondoNorte;
    }

    public void setFondoNorte(JPanel fondoNorte) {
        this.fondoNorte = fondoNorte;
    }

    public JPanel getFondoEste() {
        return fondoEste;
    }

    public void setFondoEste(JPanel fondoEste) {
        this.fondoEste = fondoEste;
    }

    public JPanel getFondoOeste() {
        return fondoOeste;
    }

    public void setFondoOeste(JPanel fondoOeste) {
        this.fondoOeste = fondoOeste;
    }

    public int getNumNiveles() {
        return numNiveles;
    }

    public void setNumNiveles(int numNiveles){
        this.numNiveles = numNiveles;
    }

    @Override
    public String toString(){
        return "MenuInicial[" +
                "panelCentral=" + (panelCentral != null ? panelCentral.toString() : "null") +
                ", tipoTorneo=" + (tipoTorneo != null ? tipoTorneo.toString() : "null") +
                ", tipoAvatares=" + (tipoAvatares != null ? tipoAvatares.toString() : "null") +
                ", comenzarButton=" + (comenzar != null ? "'" + comenzar.toString() + "'" : "null") +
                ", salirButton=" + (salir != null ? "'" + salir.toString() + "'" : "null") +
                ']';
    }
}
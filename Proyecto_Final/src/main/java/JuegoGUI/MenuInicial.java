package JuegoGUI;
import Lógica.Torneo;
import javax.swing.*;
import java.awt.*;

/**
 * Clase que sirve de primer menu que permite al usuario escoger el tipo de torneo
 * en el que quiere participar y 2 avatares basicos de entre 4 opciones.
 * @author Francisco Arentsen
 */
public class MenuInicial extends JPanel {
    private VentanaJuego ventanaJuego;
    private JPanel panelCentral;
    private OpcionesTorneo tipoTorneo;
    private OpcionesAvatares tipoAvatares;
    private JPanel comienzoOsalida;
    private BotonGenerico comenzar, salir;
    private JPanel fondo;

    /**Constructor de la clase que configura sus dimensiones y la disposición
     * de los subpaneles ademas de inicializarlos y agregarlos. Tambien incializa los botones para
     * las opciones de Salir y Continuar, les aagrega los ActionListeners corresondientes
     * y los añade a sus respectivos subpaneles
     * @param ventanaJuego corresponde a una instancia de ventana que perimite invocar a los
     * metodos declarados en esta.
     * */
    public MenuInicial(VentanaJuego ventanaJuego){
        this.ventanaJuego = ventanaJuego;
        this.setLayout(new BorderLayout());
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3,1,0,0));

        tipoTorneo = new OpcionesTorneo();
        tipoAvatares = new OpcionesAvatares();
        comienzoOsalida = new JPanel(); comienzoOsalida.setLayout(new GridLayout(1,2,0,0));
        comenzar = new BotonGenerico(new ComandoComenzar(ventanaJuego, tipoTorneo, tipoAvatares), "Comenzar");
        comenzar.addActionListener(e -> comenzar.getComando().ejecutar());
        salir = new BotonGenerico(new ComandoSalir(ventanaJuego), "Salir");
        salir.addActionListener(e -> salir.getComando().ejecutar());
        comienzoOsalida.add(salir);
        comienzoOsalida.add(comenzar);
        panelCentral.add(tipoTorneo); panelCentral.add(tipoAvatares); panelCentral.add(comienzoOsalida);
        fondo = new JPanel();

        this.add(panelCentral, BorderLayout.CENTER);
        this.add(fondo, BorderLayout.NORTH);
        this.add(fondo, BorderLayout.SOUTH);
        this.add(fondo, BorderLayout.EAST);
        this.add(fondo, BorderLayout.WEST);
    }

    /**Este metodo remueve el MenuInicial de la VentanaJuego y agrega otro en su lugar.
     * @param panel es el nuevo JPanel que se quiere agregar a VentanaJuego.
     * */
    public void removerPanel(JPanel panel){
        ventanaJuego.cambiarPanel(panel);
    }

    public VentanaJuego getVentanaJuego() {
        return ventanaJuego;
    }

    public void setVentanaJuego(VentanaJuego ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
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

    public OpcionesAvatares getTipoAvatares() {
        return tipoAvatares;
    }

    public void setTipoAvatares(OpcionesAvatares tipoAvatares) {
        this.tipoAvatares = tipoAvatares;
    }

    public JPanel getComienzoOsalida() {
        return comienzoOsalida;
    }

    public void setComienzoOsalida(JPanel comienzoOsalida) {
        this.comienzoOsalida = comienzoOsalida;
    }

    public JPanel getFondo() {
        return fondo;
    }

    public void setFondo(JPanel fondo) {
        this.fondo = fondo;
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

    public String toSring(){
        return "Clase que sirve de primer menu que permite al usuario escoger el tipo de torneo " +
                "en el que quiere participar y 2 avatares basicos de entre 4 opciones";
    }
}
package GUIJuego;
import javax.swing.*;

import LogicaJuego.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * JPanel que el usuario puede activar cuando desee detener el juego.
 * Este panel representa el menú de pausa que aparece durante un combate,
 * ofreciendo opciones para continuar el juego, volver al menú principal o ver el estado del bracket.
 */
public class MenuPausa extends JPanel {
    private Combate combate;
    private JPanel panelCentral;
    private JPanel fondoSur, fondoNorte, fondoEste, fondoOeste;
    private BotonGenerico continuar, volverMenuInicial, status;

    /**
     * Constructor de la clase MenuPausa.
     * Configura el diseño, color y componentes del menú de pausa.
     * @param combate La instancia del combate que se está pausando.
     */
    public MenuPausa(Combate combate){
        this.combate = combate;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.yellow);
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1,2,0,0));
        panelCentral.setBackground(Color.yellow);

        fondoSur = new JPanel();
        fondoSur.setPreferredSize(new Dimension(0,300));
        fondoSur.setBackground(Color.yellow);
        fondoNorte = new JPanel();
        fondoNorte.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fondoNorte.setPreferredSize(new Dimension(0,300));
        fondoNorte.setBackground(Color.yellow);
        fondoEste = new JPanel();
        fondoEste.setPreferredSize(new Dimension(400,0));
        fondoEste.setBackground(Color.yellow);
        fondoOeste = new JPanel();
        fondoOeste.setPreferredSize(new Dimension(400,0));
        fondoOeste.setBackground(Color.yellow);

        this.add(fondoSur, BorderLayout.SOUTH);
        this.add(fondoEste, BorderLayout.EAST);
        this.add(fondoOeste, BorderLayout.WEST);

        status = new BotonGenerico(new ComandoMostrarStatus(), "Bracket");
        status.addActionListener(e -> status.getComando().ejecutar());
        fondoNorte.add(status);
        this.add(fondoNorte, BorderLayout.NORTH);

        continuar = new BotonGenerico(new ComandoContinuarCombate(combate), "Continuar Combate");
        continuar.addActionListener(e -> continuar.getComando().ejecutar());

        volverMenuInicial = new BotonGenerico(new ComandoVolverMenuInicial(), "Volver al Menu Inicial");
        volverMenuInicial.addActionListener(e -> volverMenuInicial.getComando().ejecutar());


        panelCentral.add(continuar); panelCentral.add(volverMenuInicial);
        this.add(panelCentral, BorderLayout.CENTER);
    }

    public Combate getCombate() {
        return combate;
    }

    public void setCombate(Combate combate) {
        this.combate = combate;
    }

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public void setPanelCentral(JPanel panelCentral) {
        this.panelCentral = panelCentral;
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

    public BotonGenerico getContinuar() {
        return continuar;
    }

    public void setContinuar(BotonGenerico continuar) {
        this.continuar = continuar;
    }

    public BotonGenerico getVolverMenuInicial() {
        return volverMenuInicial;
    }

    public void setVolverMenuInicial(BotonGenerico volverMenuInicial) {
        this.volverMenuInicial = volverMenuInicial;
    }

    public BotonGenerico getStatus() {
        return status;
    }

    public void setStatus(BotonGenerico status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MenuPausa{" +
                "combate=" + (combate != null ? combate.toString() : "null") +
                ", panelCentral=" + (panelCentral != null ? panelCentral.toString() : "null") +
                ", fondoSur=" + (fondoSur != null ? fondoSur.toString() : "null") +
                ", fondoNorte=" + (fondoNorte != null ? fondoNorte.toString() : "null") +
                ", fondoEste=" + (fondoEste != null ? fondoEste.toString() : "null") +
                ", fondoOeste=" + (fondoOeste != null ? fondoOeste.toString() : "null") +
                ", continuar=" + (continuar != null ? continuar.toString() : "null") +
                ", volverMenuInicial=" + (volverMenuInicial != null ? volverMenuInicial.toString() : "null") +
                ", status=" + (status != null ? status.toString() : "null") +
                '}';
    }
}
package GUIJuego;
import javax.swing.*;

import LogicaJuego.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * JPanel que el usuario puede activar cuando desee detener el juego.
 */
public class MenuPausa extends JPanel {
    private Combate combate;
    private JPanel panelCentral;
    private JPanel fondoSur, fondoNorte, fondoEste, fondoOeste;
    private BotonGenerico continuar, volverMenuInicial, status;

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
}
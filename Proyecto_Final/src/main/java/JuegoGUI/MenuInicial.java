package JuegoGUI;
import Lógica.Torneo;
import javax.swing.*;
import java.awt.*;

public class MenuInicial extends JPanel {
    private Torneo torneo;
    private VentanaJuego ventanaJuego;
    private JPanel panelCentral;
    private OpcionesTorneo tipoTorneo;
    private OpcionesAvatares tipoAvatares;
    private JPanel comienzoOsalida;
    private BotonGenerico comenzar, salir;
    private JPanel fondo;

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
        fondo = new JPanel(); fondo.setBackground(Color.green);

        this.add(panelCentral, BorderLayout.CENTER);
        this.add(fondo, BorderLayout.NORTH);
        this.add(fondo, BorderLayout.SOUTH);
        this.add(fondo, BorderLayout.EAST);
        this.add(fondo, BorderLayout.WEST);
    }

    public void removerPanel(JPanel panel){
        ventanaJuego.cambiarPanel(panel);
    }
}
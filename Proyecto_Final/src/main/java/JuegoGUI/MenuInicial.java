package JuegoGUI;
import javax.swing.*;
import java.awt.*;

public class MenuInicial extends JPanel {
    private JPanel panelCentral;
    private OpcionesTorneo tipoTorneo;
    private OpcionesAvatares tipoAvatares;
    private JPanel comienzoOsalida;
    private JPanel fondo;

    public MenuInicial(){
        this.setLayout(new BorderLayout());
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3,1,0,0));

        tipoTorneo = new OpcionesTorneo(this);
        tipoAvatares = new OpcionesAvatares(this);
        comienzoOsalida = new JPanel(); comienzoOsalida.setLayout(new GridLayout(1,2,0,0));
        comienzoOsalida.add(new BotonGenerico(new ComandoEjemplo(), "Salir"));
        comienzoOsalida.add(new BotonGenerico(new ComandoEjemplo(), "Comenzar"));
        panelCentral.add(tipoTorneo); panelCentral.add(tipoAvatares); panelCentral.add(comienzoOsalida);
        fondo = new JPanel(); fondo.setBackground(Color.green);

        this.add(panelCentral, BorderLayout.CENTER);
        this.add(fondo, BorderLayout.NORTH);
        this.add(fondo, BorderLayout.SOUTH);
        this.add(fondo, BorderLayout.EAST);
        this.add(fondo, BorderLayout.WEST);
    }
}
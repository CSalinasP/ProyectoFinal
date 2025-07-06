package GUIMenu;

import javax.swing.*;
import java.awt.*;

/*
Panle para la ventana
 */
public class Ventana extends JFrame {
    public JPanel EliminarSimple;
    public JPanel EliminarDoble;
    public JPanel LigaSimple;
    public Ventana(){
        this.setTitle("Ventana principal");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

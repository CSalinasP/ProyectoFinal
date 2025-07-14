package GUIMenu;

import javax.swing.*;
import java.awt.*;

/*
Panle para la ventana
 */
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JPanel EliminatoriaSimple;
    private JPanel EliminatoriaDoble;
    private JPanel LigaSimple;

    public Ventana() {
        setTitle("🏆 Gestor de Torneos");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Brackets
        BraketES bracketES = new BraketES();
        BraketED bracketED = new BraketED();
        BracketLS bracketLS = new BracketLS();

        EliminatoriaSimple = bracketES.getPanel();
        EliminatoriaDoble = bracketED.getPanel();
        LigaSimple = bracketLS.getPanel();

        // Panel de Tabs
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Eliminatoria Simple", EliminatoriaSimple);
        tabs.add("Eliminatoria Doble", EliminatoriaDoble);
        tabs.add("Liga Simple", LigaSimple);

        add(tabs, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }
}

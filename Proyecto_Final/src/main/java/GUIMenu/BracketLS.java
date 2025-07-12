package GUIMenu;
import javax.swing.*;
public class BracketLS extends BracketTorneo {
    private JPanel LigaSimple;

    public BracketLS() {
        LigaSimple = new JPanel();
        panel.add(LigaSimple);
    }

    @Override
    protected void configurarPanel() {
        panel.setBorder(BorderFactory.createTitledBorder("Liga Simple"));
    }

    @Override
    protected void agregarListeners() {}

    @Override
    public void actualizarPanel() {
        System.out.println("Actualizando Liga Simple...");
    }
}

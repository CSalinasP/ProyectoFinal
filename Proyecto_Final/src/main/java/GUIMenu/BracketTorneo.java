package GUIMenu;

import javax.swing.*;

public abstract class BracketTorneo {
    protected JPanel panel;

    public BracketTorneo() {
        panel = new JPanel();
        configurarPanel();
        agregarListeners();
    }

    protected abstract void configurarPanel();
    protected abstract void agregarListeners();

    public abstract void actualizarPanel();

    public JPanel getPanel() {
        return panel;
    }
}

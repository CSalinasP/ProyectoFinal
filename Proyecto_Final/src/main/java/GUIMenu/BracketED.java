package GUIMenu;
import javax.swing.*;
/*
Tabla para generar una tabla de eliminatoria simple
 */
public class BracketED extends BracketTorneo {
    private JPanel EliminatoriaDoble;

    public BracketED() {
        EliminatoriaDoble = new JPanel();
        panel.add(EliminatoriaDoble);
    }

    @Override
    protected void configurarPanel() {
        panel.setBorder(BorderFactory.createTitledBorder("Eliminatoria Doble"));
    }

    @Override
    protected void agregarListeners() {}

    @Override
    public void actualizarPanel() {
        System.out.println("Actualizando Eliminatoria Doble...");
    }
}

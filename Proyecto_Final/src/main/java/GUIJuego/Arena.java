package GUIJuego;
import javax.swing.*;
import LogicaJuego.*;

import java.awt.*;

public class Arena extends JPanel{
    private Combate combate;
    private BotonGenerico pausa;

    public Arena(Combate combate){
        this.setBackground(Color.red);
        pausa = new BotonGenerico(new ComandoPausa(combate), "Pausar Juego");
        pausa.addActionListener(e -> pausa.getComando().ejecutar());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        this.add(pausa, gbc);

        this.combate = combate;
    }

    public Combate getCombate() {
        return combate;
    }
}

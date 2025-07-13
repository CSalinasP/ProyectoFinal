package GUIJuego;
import javax.swing.*;
import LogicaJuego.*;

import java.awt.*;

public class Arena extends JPanel{
    private Combate combate;
    private BotonGenerico pausa, resultado;

    public Arena(Combate combate){
        this.setBackground(Color.red);
        pausa = new BotonGenerico(new ComandoPausa(combate), "Pausar Juego");
        pausa.addActionListener(e -> pausa.getComando().ejecutar());

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.anchor = GridBagConstraints.NORTHEAST;
        gbc1.insets = new Insets(10, 10, 10, 10);
        gbc1.weightx = 1.0;
        gbc1.weighty = 0.0;
        this.add(pausa, gbc1);

        resultado = new BotonGenerico(new ComandoFinalizarCombate(combate), "Resultado del Combate");
        resultado.addActionListener(e -> resultado.getComando().ejecutar());

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.anchor = GridBagConstraints.SOUTHEAST;
        gbc2.insets = new Insets(10, 10, 10, 10);
        gbc2.weightx = 0.0;
        gbc2.weighty = 1.0;
        this.add(resultado, gbc2);

        this.combate = combate;
    }

    public Combate getCombate() {
        return combate;
    }
}

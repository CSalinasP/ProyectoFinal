package GUIJuego;
import javax.swing.*;
import LogicaJuego.*;
import java.awt.*;

/**
 * La clase Arena representa el panel visual donde se desarrolla un combate en el juego.
 * Este panel contiene elementos interactivos como botones para pausar el juego
 * y ver el resultado del combate.
 */
public class Arena extends JPanel{
    private Combate combate;
    private BotonGenerico pausa, resultado;

    /**Constructor de la clase que configura sus dimensiones, color y la disposición
     * de los subpaneles ademas de inicializarlos y agregarlos. Tambien incializa los botones para
     * las opciones de pausar el combate, ver el resultado del mismo, les aagrega los ActionListeners corresondientes
     * y los añade a sus respectivos subpaneles
     * @param combate La instancia de la clase Combate que esta Arena representará visualmente.
     */
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

    public void setCombate(Combate combate) {
        this.combate = combate;
    }

    public BotonGenerico getPausa() {
        return pausa;
    }

    public void setPausa(BotonGenerico pausa) {
        this.pausa = pausa;
    }

    public BotonGenerico getResultado() {
        return resultado;
    }

    public void setResultado(BotonGenerico resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "combate=" + (combate != null ? "initialized" : "null") +
                ", pausa=" + (pausa != null ? pausa.toString(): "null") +
                ", resultado=" + (resultado != null ? resultado.toString() : "null") +
                '}';
    }
}

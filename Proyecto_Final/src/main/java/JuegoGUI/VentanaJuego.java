package JuegoGUI;
import Lógica.Torneo;
import javax.swing.*;

public class VentanaJuego extends JFrame {
    private static VentanaJuego instancia;
    private Torneo torneo;
    private JPanel panelActual;

    /**Constructor de la clase que configura el tamao de la ventana, la posisiona en pantalla,
     * establece el termino de la aplicación cuando se presiona el icono de cerrar ventana,
     * agrega una instancia de MenuInicial al JFrame y lo hace visible.*/
    private VentanaJuego(){
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        panelActual = new MenuInicial(this);
        this.add(panelActual);
        this.setVisible(true);
    }

    /**Este metodo crea la única instancia de VentanaJuego que se usara en el juego si no existe
     * o retorna esta misma instancia si ya fue creaada.
     * @return instancia es la única instancia de esta clase que sera usado en el juego.
     * */
    public static VentanaJuego getInstance(){
        if(instancia==null){
            instancia = new VentanaJuego();
        }
        return instancia;
    }

    /**Este metodo remueve el JPanel que se encuetra contenido en VentanaJuego en el momento y agrega otro en su lugar.
     * @param panel es el nuevo JPanel que se quiere agregar a VentanaJuego.
     * */
    public void cambiarPanel(JPanel panel){
        this.remove(panelActual);
        panelActual = panel;
        this.add(panelActual);
    }

    public void cerrarVantanaJuego (){
        this.dispose();
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public JPanel getPanelActual() {
        return panelActual;
    }

    public void setPanelActual(JPanel panelActual) {
        this.panelActual = panelActual;
    }

    public String toString(){
        return "Esta clase sirve de contenedor para los paneles que que constituyen la GUI del juego";
    }
}

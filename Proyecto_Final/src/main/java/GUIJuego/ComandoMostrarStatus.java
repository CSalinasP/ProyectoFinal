// Nuevo archivo: GUIJuego/ComandoMostrarStatus.java
package GUIJuego;
import GUITorneo.BracketES;
import GUITorneo.BracketLS;
import GUITorneo.BracketTorneo;
import GUITorneo.VentanaTorneo;
import LogicaTorneo.EliminatoriaSimple;

public class ComandoMostrarStatus implements Comando {

    public ComandoMostrarStatus() {
    }
    @Override
    public void ejecutar() {
        if(VentanaJuego.getInstancia().getTorneoActual() instanceof EliminatoriaSimple){
            VentanaTorneo statusFrame = VentanaTorneo.getInstancia(new BracketES(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados()));
        }
        else{
            VentanaTorneo statusFrame = VentanaTorneo.getInstancia(new BracketLS());
        }
    }
}
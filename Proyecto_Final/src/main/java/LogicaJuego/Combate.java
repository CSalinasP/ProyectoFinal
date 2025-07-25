package LogicaJuego;

import GUIJuego.MenuEntreCombates;
import GUIJuego.MenuInicial;
import GUIJuego.VentanaJuego;
import GUIJuego.Victoria;
import GUITorneo.BracketES;
import GUITorneo.BracketLS;
import GUITorneo.VentanaTorneo;
import LogicaTorneo.EliminatoriaSimple;
import LogicaTorneo.LigaSimple;
import LogicaTorneo.Torneo;

import javax.swing.*;
import java.util.Random;

/**
 * Clase que representa el combate entre Avatar y el enemigo.
 * @author CSalinasP
 * @version 1.3
 * @since 2025-07-13
 */
public class Combate {
    /** El personaje que se usará para combatir. */
    private Personaje avatar;
    /** El personaje enemigo. */
    private Personaje contendiente;
    /** Referencia al torneo en el que se hace el combate. */
    private Torneo torneoActual;
    /** Indica si Avatar ganó el combate */
    private Boolean ganador;

    /**
     * Constructor que declara a los personajes que estarán en el combate,
     * @param torneo La instancia del torneo en el que se está haciendo el combate.
     */
    public Combate(Torneo torneo){
        torneoActual = torneo;
        this.avatar = torneoActual.getEnfrentamientos().getFirst();
        this.contendiente = torneoActual.getEnfrentamientos().get(1);
    }

    /**
     * Metodo que calcula automáticamente el resultado del combate.
     * La probabilidad de que Avatar gane depende de su comparación de sus características con las de Contendiente.
     * Para la comparación usamos la división entre las características.
     * En el caso del daño y la curación, sacamos los promedios de los daños y curaciones de todas las habilidades.
     * Como queremos que cada variable de probabilidad sea entre 0 y 0.2, después de la división multiplicamos por 0.1,
     * si el número llega a ser mayor a 0.2, lo igualamos a 0.2.
     * Al final, sumamos las 5 variables de probabilidad que nos dará la probabilidad de que Avatar gane.
     * Luego generamos un número aleatorio entre 0 y 1,
     * si el número generado aleatoriamente es menor o igual a la probabilidad de ganar, gana Avatar,
     * en caso contrario, gana Contendiente.
     */
    public Personaje calcularResultado(Personaje avatar, Personaje contendiente){
        double probVida;
        double probResistencia;
        double probRegeneracion;
        double probDamage;
        double probCuracion;
        double probGanador;
        Random rand = new Random();

        probVida = 0.1 * ((double) avatar.getVida() /contendiente.getVida());
        if (probVida>0.2)
        {
            probVida=0.2;
        }
        probResistencia = 0.1 * ((double) avatar.getResistencia() /contendiente.getResistencia());
        if (probResistencia>0.2)
        {
            probResistencia=0.2;
        }
        probRegeneracion = 0.1 * ((double) avatar.getRegeneracion() /contendiente.getRegeneracion());
        if (probRegeneracion>0.2)
        {
            probRegeneracion=0.2;
        }
        probDamage = 0.1 * (avatar.getPromedioDamageHabilidades() /contendiente.getPromedioDamageHabilidades());
        if (probDamage>0.2)
        {
            probDamage=0.2;
        }
        probCuracion = 0.1 * (avatar.getPromedioCuracionHabilidades() /contendiente.getPromedioCuracionHabilidades());
        if (probCuracion>0.2)
        {
            probCuracion=0.2;
        }

        probGanador = probVida + probResistencia + probRegeneracion + probDamage + probCuracion;
        Double auxRandom = rand.nextDouble();
        if (auxRandom <= probGanador){
            this.Resultado(true);
            return avatar;
        }
        else {
            this.Resultado(false);
            return contendiente;
        }
    }

    public void finalizarCombate(){
        if(VentanaJuego.getInstancia().getTorneoActual() instanceof EliminatoriaSimple) {
            if (VentanaJuego.getInstancia().getTorneoActual().getNivelesRestantes() > 1) {
                calcularResultado(avatar, contendiente);
                if (ganador) {
                    VentanaJuego.getInstancia().getTorneoActual().actualizarEnfrentamientos();
                    VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().addFirst(avatar);
                    VentanaJuego.getInstancia().getTorneoActual().getHistorialEnfrentamientos().get(1+(VentanaJuego.getInstancia().getTorneoActual()).getNivelesCompletados()).addFirst(avatar);
                    VentanaJuego.getInstancia().getTorneoActual().actualizarFechas();
                    VentanaJuego.getInstancia().getTorneoActual().setNivelesRestantes(VentanaJuego.getInstancia().getTorneoActual().getNivelesRestantes() - 1);
                    VentanaJuego.getInstancia().getTorneoActual().setNivelesCompletados(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados() + 1);
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Haz Ganado Esta Ronda", new MenuEntreCombates()));
                } else {
                    VentanaJuego.getInstancia().getTorneoActual().actualizarEnfrentamientos();
                    VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().addFirst(avatar);
                    VentanaJuego.getInstancia().getTorneoActual().getHistorialEnfrentamientos().get(1+(VentanaJuego.getInstancia().getTorneoActual()).getNivelesCompletados()).addFirst(avatar);
                    VentanaJuego.getInstancia().getTorneoActual().actualizarFechas();
                    VentanaJuego.getInstancia().getTorneoActual().setNivelesRestantes(VentanaJuego.getInstancia().getTorneoActual().getNivelesRestantes() - 1);
                    VentanaJuego.getInstancia().getTorneoActual().setNivelesCompletados(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados() + 1);
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Haz Ganado Esta Ronda", new MenuEntreCombates()));
                   /** VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().removeFirst();
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Haz Perdido", new MenuInicial()));*/
                }
            } else {
                calcularResultado(avatar, contendiente);
                if (ganador) {
                    VentanaJuego.getInstancia().getTorneoActual().setNivelesRestantes(VentanaJuego.getInstancia().getTorneoActual().getNivelesRestantes() - 1);
                    VentanaJuego.getInstancia().getTorneoActual().setNivelesCompletados(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados() + 1);
                    VentanaJuego.getInstancia().getTorneoActual().actualizarEnfrentamientos();
                    VentanaJuego.getInstancia().getTorneoActual().actualizarFechas();
                    VentanaJuego.getInstancia().getTorneoActual().getHistorialEnfrentamientos().get(1+(VentanaJuego.getInstancia().getTorneoActual()).getNivelesCompletados()).addFirst(avatar);
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Haz Ganado", new MenuInicial()));
                    JFrame V = VentanaTorneo.getInstancia(new BracketES(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados()+1));
                } else {
                    VentanaJuego.getInstancia().getTorneoActual().actualizarEnfrentamientos();
                    VentanaJuego.getInstancia().getTorneoActual().actualizarFechas();
                    VentanaJuego.getInstancia().getTorneoActual().getHistorialEnfrentamientos().get(1+(VentanaJuego.getInstancia().getTorneoActual()).getNivelesCompletados()).addFirst(contendiente);
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Haz Perdido", new MenuInicial()));
                    JFrame V = VentanaTorneo.getInstancia(new BracketES(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados()+1));
                }
            }
        }
        else{
            if (VentanaJuego.getInstancia().getTorneoActual().getNivelesRestantes() > 1) {
                calcularResultado(avatar, contendiente);
                VentanaJuego.getInstancia().getTorneoActual().actualizarEnfrentamientos();
                VentanaJuego.getInstancia().getTorneoActual().actualizarFechas();
                VentanaJuego.getInstancia().getTorneoActual().setNivelesRestantes(VentanaJuego.getInstancia().getTorneoActual().getNivelesRestantes() - 1);
                VentanaJuego.getInstancia().getTorneoActual().setNivelesCompletados(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados() + 1);
                if (ganador) {
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Haz Ganado Esta Ronda", new MenuEntreCombates()));
                } else {
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Haz Perdido Esta Ronda", new MenuEntreCombates()));
                }
            } else {
                calcularResultado(avatar, contendiente);
                VentanaJuego.getInstancia().getTorneoActual().actualizarEnfrentamientos();
                VentanaJuego.getInstancia().getTorneoActual().actualizarFechas();
                VentanaJuego.getInstancia().getTorneoActual().setNivelesRestantes(VentanaJuego.getInstancia().getTorneoActual().getNivelesRestantes() - 1);
                VentanaJuego.getInstancia().getTorneoActual().setNivelesCompletados(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados() + 1);
                ((LigaSimple)VentanaJuego.getInstancia().getTorneoActual()).posisionar();
                if (ganador) {
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Llegaste al puesto "+VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().getFirst().getPosision(), new MenuInicial()));
                    JFrame V = VentanaTorneo.getInstancia(new BracketLS());
                } else {
                    VentanaJuego.getInstancia().cambiarPanel(new Victoria("Llegaste al puesto "+VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().getFirst().getPosision(), new MenuInicial()));
                    JFrame V = VentanaTorneo.getInstancia(new BracketLS());
                }
            }
        }

    }

    /**
     * Metodo que declara el ganador del combate.
     * @param Ganador Si avatar ganó el combate.
     */
    public void Resultado(Boolean Ganador){
        ganador = Ganador;
    }

    /**
     * Metodo getter que retorna si Avatar ganó.
     */
    public Boolean getGanador() {
        return ganador;
    }

    /**
     * Metodo getter que retorna al personaje Avatar.
     */
    public Personaje getAvatar() {
        return avatar;
    }

    @Override
    public String toString(){
        return "Avatar: " + avatar.toString() + ", Contendiente: " + contendiente.toString();
    }
}
package LogicaJuego;

import LogicaTorneo.Torneo;
import java.util.Random;

/**
 * Clase que representa el combate,
 * gestiona los ataques entre personajes, así como también los turnos.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */
public class Combate {
    /** El personaje que se usará para combatir. */
    private Personaje avatar;
    /** El personaje enemigo. */
    private Personaje contendiente;
    /** Referencia al torneo en el que se hace el combate. */
    private Torneo torneoActual;
    /** El personaje que gana el combate. */
    private Personaje ganador;
    /** turnoActual=0 es el turno del Avatar y turnoActual=1 es el turno del contendiente. */
    private int turnoActual;

    /**
     * Constructor que declara a los personajes que estarán en el combate,
     * siempre empieza el personaje Avatar el combate (turnoActual = 0).
     * @param Avatar El personaje con el que se combate.
     * @param Torneo La instancia del torneo en el que se está haciendo el combate.
     */
    public Combate(Personaje Avatar, Torneo Torneo){
        avatar = Avatar;
        torneoActual = Torneo;
        turnoActual = 0;
    }

    /**
     * Metodo que en el turno de Avatar usa su habilidad.
     * Avatar hace daño y se cura a sí mismo dependiendo de la curación y daño de la habilidad.
     * Antes de usar la habilidad Avatar regenera vida.
     * Si después de usar la habilidad la vida de contendiente es 0: se declara Avatar como el ganador.
     * Después de usar la habilidad será el turno de Contendiente.
     * @param habilidad la habilidad que Avatar quiere usar.
     */
    public void usarHabilidadAvatar(Habilidad habilidad){
        avatar.regenerarVida();
        int damage = habilidad.usar(avatar);
        contendiente.quitarVida(damage);

        if (contendiente.getVida() <= 0){
            this.Resultado(avatar);
        }
        turnoActual = 1;
    }

    /**
     * Metodo que en el turno de Contendiente usa su habilidad.
     * Contendiente hace daño y se cura a sí mismo dependiendo de la curación y daño de la habilidad.
     * Antes de usar la habilidad, Contendiente regenera vida.
     * Si después de usar la habilidad, la vida de Avatar es 0, se declara Contendiente como el ganador.
     * Después de usar la habilidad, será el turno de Avatar.
     * @param habilidad la habilidad que Contendiente quiere usar.
     */
    public void usarHabilidadContendiente(Habilidad habilidad){
        contendiente.regenerarVida();
        int damage = habilidad.usar(contendiente);
        avatar.quitarVida(damage);

        if (avatar.getVida() <= 0){
            this.Resultado(contendiente);
        }
        turnoActual = 0;
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
    public void calcularResultado(){
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
            this.Resultado(avatar);
        }
        else {
            this.Resultado(contendiente);
        }
    }

    /**
     * Metodo que declara el ganador del combate.
     * @param Ganador quien ganó el combate.
     */
    public void Resultado(Personaje Ganador){
        ganador = Ganador;
    }

    @Override
    public String toString(){
        return "Avatar: " + avatar.toString() + ", Contendiente: " + contendiente.toString();
    }
}
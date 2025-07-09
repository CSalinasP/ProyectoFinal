package LogicaJuego;

import LogicaTorneo.Torneo;
import java.util.Random;

/**
 * Clase que representa el combate
 * Gestiona los ataques entre personajes, así como también los turnos
 *
 * @author CSalinasP
 * @version 1.1
 * @since 2025-07-05
 */
public class Combate {
    /** El 1er Personaje que estará en el combate */
    private Personaje avatar;
    /** El 2do Personaje que estará en el combate */
    private Personaje contendiente;
    /** Referencia al Torneo en el que se hace el combate */
    private Torneo torneoActual;
    /** El Personaje que gana el Combate */
    private Personaje ganador;
    /** turnoActual=0 es el turno del Avatar y turnoActual=1 es el turno del contendiente */
    private int turnoActual;
    /** Las siguientes 5 variables son probabilidades de que Avatar gane contra Contendiente,
    * cada una compara las características de cada Personaje, tienen un rango entre 0 y 0.2,
    * el valor aumenta si la característica de Avatar es mayor a la de Contendiente
    * Ej: probVida compara la vida de Avatar con la de Contendiente, aumenta conforme la vida de Avatar es mayor
     */
    private double probVida;
    private double probResistencia;
    private double probRegeneracion;
    private double probDamage;
    private double probCuracion;
    /** Al tener todas las probabilidades, se suman todas en probGanador, que tiene un rango entre 0 y 1,
    * el cual es la probabilidad de que Avatar gane el combate */
    private double probGanador;
    /** Variable usada para generar números aleatorios entre 0 y 1 para calcular las probabilidades */
    private Random rand;

    /**
     * Constructor que declara a los personajes que estarán en el combate
     *
     * @param Avatar 1.° Personaje del combate
     * @param Contendiente 2.° Personaje del combate
     * @param Torneo La instancia del Torneo en el que se está haciendo el combate
     * Siempre empieza el Personaje Avatar el combate (turnoActual = 0)
     * Se instancia con Random para generar los números aleatorios
     */
    public Combate(Personaje Avatar, Personaje Contendiente, Torneo Torneo){
        avatar = Avatar;
        contendiente = Contendiente;
        torneoActual = Torneo;
        turnoActual = 0;
        rand = new Random();
    }

    /**
     * Metodo que en el turno de Avatar, usa su habilidad
     *
     * @param habilidad la habilidad que Avatar quiere usar
     * Avatar hace daño y se cura a sí mismo dependiendo de la curación y daño de la habilidad
     * Antes de usar la habilidad, Avatar regenera vida
     * Si después de usar la habilidad, la vida del contendiente es 0, se declara Avatar como el ganador
     * Después de usar la habilidad, será el turno de Contendiente
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
     * Metodo que en el turno de Contendiente, usa su habilidad
     *
     * @param habilidad la habilidad que Contendiente quiere usar
     * Contendiente hace daño y se cura a sí mismo dependiendo de la curación y daño de la habilidad
     * Antes de usar la habilidad, Contendiente regenera vida
     * Si después de usar la habilidad, la vida de Avatar es 0, se declara Contendiente como el ganador
     * Después de usar la habilidad, será el turno de Avatar
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
     * Metodo que calcula automáticamente el resultado del combate
     *
     * La probabilidad de que Avatar gane depende de su comparación de sus características con las de Contendiente,
     * Para la comparación usamos la división entre las características,
     * en el caso del daño y la curación, sacamos los promedios de los daños y curaciones de todas las habilidades,
     * como queremos que cada variable de probabilidad sea entre 0 y 0.2, después de la división multiplicamos por 0.1,
     * si el número llega a ser mayor a 0.2, lo igualamos a 0.2,
     * al final, sumamos las 5 variables de probabilidad que nos dará la probabilidad de que Avatar gane,
     * Luego generamos un número aleatorio entre 0 y 1,
     * Si el número generado aleatoriamente es menor o igual a la probabilidad de ganar, gana Avatar
     * en caso contrario, gana Contendiente
     */
    public void calcularResultado(){
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
     * Metodo que declara el ganador del combate
     *
     * @param Ganador quien ganó el combate
     */
    public void Resultado(Personaje Ganador){
        ganador = Ganador;
    }

    @Override
    public String toString(){
        return "Avatar: " + avatar.getNombre() + ", Contendiente: " + contendiente.getNombre();
    }
}
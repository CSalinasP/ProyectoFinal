package org.LogicaJuego;

/**
 * Clase que representa el combate
 * Gestiona los ataques entre personajes, así como también los turnos
 *
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-05
 */

public class Combate {
    /** El 1er Personaje que estará en el combate */
    private Personaje avatar;
    /** El 2do Personaje que estará en el combate */
    private Personaje contendiente;
    /** El Personaje que gana el Combate */
    private Personaje ganador;
    /** turnoActual=0 es el turno del Avatar y turnoActual=1 es el turno del contendiente */
    private int turnoActual;

    /**
     * Constructor que declara a los personajes que estarán en el combate
     *
     * @param Avatar 1.° Personaje del combate
     * @param Contendiente 2.º Personaje del combate
     * Siempre empieza el Personaje Avatar el combate (turnoActual = 0)
     */
    public Combate(Personaje Avatar, Personaje Contendiente){
        avatar = Avatar;
        contendiente = Contendiente;
        turnoActual = 0;
    }

    /**
     * Metodo que en el turno de Avatar, usa su habilidad
     *
     * @param habilidad la habilidad que Avatar quiere usar
     * Avatar hace daño y se cura a sí mismo dependiendo de la curacion y daño de la habilidad
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
     * Contendiente hace daño y se cura a sí mismo dependiendo de la curacion y daño de la habilidad
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
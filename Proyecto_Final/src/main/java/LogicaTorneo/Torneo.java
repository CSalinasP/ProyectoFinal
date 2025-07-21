package LogicaTorneo;

import LogicaJuego.Personaje;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Random;

/**
 * Clase que representa un torneo deportivo/competitivo.
 * Gestiona toda la lógica y creación de torneos, incluyendo fechas, participantes
 * y desarrollo del mismo.
 *
 * @author Tu Nombre
 * @version 1.0
 * @since 2025-07-02
 * implementar patron singleton a torneo, desimplementar el patron en planilla, modificar ventana,
 * modificar subpaneles
 */
public abstract class Torneo {
    protected int niveles;
    protected ArrayList<Personaje> competidores;
    protected ArrayList<Personaje> enfrentamientos;
    protected LocalDate fechaReferencia;
    protected ArrayList<LocalDate> fechasEnfrentamientos;

    public Torneo(int niveles) {}

    /**Actualiza los pares enfrentados conforme vayan quedando menos*/
    public abstract void actualizarEnfrentamientos();

    public abstract void actualizarFechas();

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
     *
     * @return
     */
    public Personaje determinarGanador(Personaje avatar, Personaje contendiente){
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
            return avatar;
        }
        else {
            return contendiente;
        }
    }

    public int getNiveles() {
        return niveles;
    }

    public ArrayList<Personaje> getCompetidores(){
        return competidores;
    }

    public ArrayList<Personaje> getEnfrentamientos() {
        return enfrentamientos;
    }

    public LocalDate getFechaReferencia() {
        return fechaReferencia;
    }

    public ArrayList<LocalDate> getFechasEnfrentamientos() {
        return fechasEnfrentamientos;
    }
}
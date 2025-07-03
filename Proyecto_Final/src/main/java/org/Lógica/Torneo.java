package org.Lógica;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Clase que representa un torneo deportivo/competitivo.
 * Gestiona toda la lógica y creación de torneos, incluyendo fechas, participantes
 * y desarrollo del mismo.
 *
 * @author Tu Nombre
 * @version 1.0
 * @since 2025-07-02
 */
public class Torneo extends ArrayList {
    
    /** Fecha en la que se realizará el torneo */
    private LocalDate fechaInicio;
    
    /** Hora prevista para el inicio del torneo */
    private LocalDateTime FechaTermino;
    
    /** Nombre identificativo del torneo */
    private String nombreTorneo;
    private ArrayList<Equipo> Equipos;

    /**
     * Constructor que crea un nuevo torneo con los parámetros especificados.
     *
     * @param nombreTorneo el nombre del torneo
     * @param fecha la fecha del torneo
     * @param horaPrevista la hora prevista de inicio
     * @throws IllegalArgumentException si el nombre está vacío o la fecha es anterior a la actual
     */
    public Torneo(String nombreTorneo, LocalDate fecha, LocalDateTime horaPrevista) {
        this.nombreTorneo = nombreTorneo;
        this.fechaInicio = fecha;
        this.FechaTermino = horaPrevista;
    }

    /**
     * Establece la fecha de realización del torneo.
     *
     * @param año el año del torneo
     * @param mes el mes del torneo (1-12)
     * @param dia el día del torneo (1-31)
     * @throws IllegalArgumentException si la fecha es anterior a la actual
     */
    public void establecerFecha(int año, int mes, int dia) {

    }

    /**
     * Calcula los días restantes hasta el inicio del torneo.
     *
     * @return el número de días hasta el torneo, o -1 si el torneo ya ha pasado
     */
    public long diasHastaTorneo() {
        // código del método
        return 0;
    }

    /**
     * Verifica si un participante cumple los requisitos para el torneo.
     *
     */

}
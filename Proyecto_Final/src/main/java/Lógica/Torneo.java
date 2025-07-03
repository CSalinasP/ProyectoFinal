package Lógica;
import JuegoGUI.*;
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
    private ArrayList<Object> avatares;
    
    /** Fecha en la que se realizará el torneo */
    private LocalDate fechaInicio;
    
    /** Hora prevista para el inicio del torneo */
    private LocalDateTime FechaTermino;
    
    /** Nombre identificativo del torneo */
    private String nombreTorneo;
    private ArrayList<Equipo> Equipos;


    public Torneo(TipoTorneo tipoTorneo, ArrayList<TipoPersonaje> avatares) {
        avatares = new ArrayList<>();
    }

    public Torneo() {

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
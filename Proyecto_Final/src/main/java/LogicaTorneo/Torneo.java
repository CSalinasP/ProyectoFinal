package LogicaTorneo;
import GUIJuego.*;
import GUIJuego.TipoTorneo;
import LogicaJuego.PlanillaPersonajes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

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
    protected Disciplina disciplina;
    protected ArrayList<Inscribible> competidores;
    protected ArrayList<LocalDate> fechaReferencia;
    protected ArrayList<Date> fechasEnfrentamientos;

    /**Establece pares enfrentados, establece fechas*/
    public Torneo() {}

    /**Actualiza los pares enfrentados conforme vayan quedando menos*/
    public void resultadosEnfrentamientos(ArrayList<ArrayList<Inscribible>> enfrentamientos){

    }

    public ArrayList<Inscribible> getCompetidores(){
        return competidores;
    }
}
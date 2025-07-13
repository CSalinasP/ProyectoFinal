package LogicaTorneo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import LogicaJuego.Personaje;

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
    protected Disciplina disciplina;
    protected ArrayList<Personaje> competidores;
    protected ArrayList<LocalDate> fechaReferencia;
    protected ArrayList<Date> fechasEnfrentamientos;

    /**Actualiza los pares enfrentados conforme vayan quedando menos*/
    public abstract void resultadosEnfrentamientos();

    public int getNiveles() {
        return niveles;
    }
    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public ArrayList<Personaje> getCompetidores(){
        return competidores;
    }
}
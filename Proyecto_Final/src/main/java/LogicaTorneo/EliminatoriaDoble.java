package LogicaTorneo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public class EliminatoriaDoble extends Torneo {
    private static  EliminatoriaDoble instancia;

    /**
     *
     */
    @Override
    public void actualizarFechas() {

    }

    private ArrayList<Inscribible> competidores;
    private ArrayList<Inscribible> enfrentamientosGanadores;
    private ArrayList<Inscribible> enfrentamientosPededores;
    private LocalDate fechaReferencia;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    private EliminatoriaDoble(){
        fechaReferencia = LocalDate.now();
        fechasEnfrentamientos = new ArrayList<>();
        LocalDate proximoLunes = fechaReferencia.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate proximoMiercoles = fechaReferencia.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
        for (int i = 0; i < 4; i++) {
            fechasEnfrentamientos.add(proximoLunes);
            fechasEnfrentamientos.add(proximoMiercoles);
            proximoLunes = proximoLunes.plusWeeks(1);
            proximoLunes = proximoMiercoles.plusWeeks(1);
        }
        fechasEnfrentamientos.add(proximoLunes);
    }

    public static EliminatoriaDoble getInstance(){
        if(instancia==null){
            instancia = new EliminatoriaDoble();
        }
        return instancia;
    }

    @Override
    public void actualizarEnfrentamientos() {
    }

    @Override
    public ArrayList<Inscribible> getCompetidores() {
        return competidores;
    }

    public ArrayList<Inscribible> getEnfrentamientosGanadores() {
        return enfrentamientosGanadores;
    }

    public ArrayList<Inscribible> getEnfrentamientosPededores() {
        return enfrentamientosPededores;
    }
}
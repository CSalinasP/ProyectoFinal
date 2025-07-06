package LogicaTorneo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class EliminatoriaDoble extends Torneo {
    private static  EliminatoriaDoble instancia;
    private Disciplina disciplina;
    private ArrayList<Inscribible> competidores;
    private ArrayList<ArrayList<Inscribible>> enfrentamientos;
    private ArrayList<ArrayList<Inscribible>> enfrentamientosGanadores;
    private ArrayList<ArrayList<Inscribible>> enfrentamientosPededores;
    private ArrayList<LocalDate> fechaReferencia;
    private ArrayList<Date> fechasEnfrentamientos;

    private EliminatoriaDoble(){
    }

    public static EliminatoriaDoble getInstance(){
        if(instancia==null){
            instancia = new EliminatoriaDoble();
        }
        return instancia;
    }
}
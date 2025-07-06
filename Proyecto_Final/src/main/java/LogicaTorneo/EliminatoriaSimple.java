package LogicaTorneo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class EliminatoriaSimple extends Torneo {
    private static  EliminatoriaSimple instancia;
    private Disciplina disciplina;
	private ArrayList<Inscribible> competidores;
    private ArrayList<ArrayList<Inscribible>> enfrentamientos;
    private ArrayList<LocalDate> fechaReferencia;
    private ArrayList<Date> fechasEnfrentamientos;

    private EliminatoriaSimple(){
    }

    public static EliminatoriaSimple getInstance(){
        if(instancia==null){
            instancia = new EliminatoriaSimple();
        }
        return instancia;
    }
}

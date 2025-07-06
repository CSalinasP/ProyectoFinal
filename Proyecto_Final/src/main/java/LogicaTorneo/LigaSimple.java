package LogicaTorneo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class LigaSimple extends Torneo{
    private static LigaSimple instancia;
    private Disciplina disciplina;
    private ArrayList<Inscribible> competidores;
    private ArrayList<ArrayList<Inscribible>> enfrentamientos;
    private ArrayList<ArrayList<Object>> estadisticas;
    private ArrayList<LocalDate> fechaReferencia;
    private ArrayList<Date> fechasEnfrentamientos;

    private LigaSimple(){
    }

    public static LigaSimple getInstance(){
        if(instancia==null){
            instancia = new LigaSimple();
        }
        return instancia;
    }
}

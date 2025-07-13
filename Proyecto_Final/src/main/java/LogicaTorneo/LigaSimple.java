package LogicaTorneo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class LigaSimple extends Torneo{
    /**
     * Actualiza los pares enfrentados conforme vayan quedando menos
     */
    @Override
    public void resultadosEnfrentamientos() {

    }

    private static LigaSimple instancia;
    private Disciplina disciplina;
    private int niveles;
    private ArrayList<Inscribible> competidores;
    private ArrayList<ArrayList<Inscribible>> enfrentamientos;
    private ArrayList<ArrayList<Object>> estadisticas;
    private ArrayList<LocalDate> fechaReferencia;
    private ArrayList<Date> fechasEnfrentamientos;

    private LigaSimple(int niveles){
        this.niveles = niveles;
    }

    public static LigaSimple getInstance(int niveles){
        if(instancia==null){
            instancia = new LigaSimple(niveles);
        }
        return instancia;
    }

    public void resultadosEnfrentamientos(ArrayList<Inscribible> enfrentamientos) {

    }
}

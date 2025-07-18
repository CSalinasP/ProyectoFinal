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
    public void actualizarEnfrentamientos() {

    }

    /**
     *
     */
    @Override
    public void actualizarFechas() {

    }

    private static LigaSimple instancia;
    private ArrayList<Inscribible> competidores;
    private ArrayList<Inscribible> enfrentamientos;
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

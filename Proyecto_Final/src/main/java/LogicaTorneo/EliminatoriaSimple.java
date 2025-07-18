package LogicaTorneo;

import LogicaJuego.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

//Reducir a 1 sola opcion, incluir modo aventura, añadir atributos para obtener resultadoos

public class EliminatoriaSimple extends Torneo {
    private static  EliminatoriaSimple instancia;
    private ArrayList<Inscribible> competidores;
    private ArrayList<Inscribible>enfrentamientos;
    private ArrayList<Inscribible>enfrentamientos2;
    private ArrayList<Inscribible>enfrentamientos3;
    private ArrayList<Inscribible>enfrentamientos4;
    private LocalDate fechaReferencia;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    private EliminatoriaSimple(){
        Set<Personaje> competidoresUnicosOrdenados = new LinkedHashSet<>();
        /**competidoresUnicosOrdenados.add(PlanillaPersonajes.getInstance().getPersonajes().getFirst());*/
        competidoresUnicosOrdenados.add(new Personaje_Humano());
        competidoresUnicosOrdenados.add(new Personaje_Cavernario());
        competidoresUnicosOrdenados.add(new Personaje_Caballero());
        competidoresUnicosOrdenados.add(new Personaje_NoMuerto());
        competidoresUnicosOrdenados.add(new Personaje_Gigante());
        competidoresUnicosOrdenados.add(new Personaje_Hombre_Montruo());
        competidoresUnicosOrdenados.add(new Personaje_Sindri());
        competidoresUnicosOrdenados.add(new Personaje_Helado());
        competidoresUnicosOrdenados.add(new Personaje_Acuatico());
        competidoresUnicosOrdenados.add(new Personaje_Surtur());
        competidoresUnicosOrdenados.add(new Personaje_Eolo());
        competidoresUnicosOrdenados.add(new Personaje_Amazona());
        competidoresUnicosOrdenados.add(new Personaje_Momia());
        competidoresUnicosOrdenados.add(new Personaje_Fantasma());
        competidoresUnicosOrdenados.add(new Personaje_Mago());
        competidoresUnicosOrdenados.add(new Personaje_Nigromante());
        competidores = new ArrayList<>(competidoresUnicosOrdenados);
        enfrentamientos = new ArrayList<>(competidoresUnicosOrdenados);
        enfrentamientos2 = new ArrayList<>(competidoresUnicosOrdenados);
        for(int i=0 ; i < 8; i++){
        enfrentamientos2.remove(i);}
        enfrentamientos3 =  new ArrayList<>(enfrentamientos2);
        for(int i=0 ; i < 4; i++){
            enfrentamientos3.remove(i);}
        enfrentamientos4 =  new ArrayList<>(enfrentamientos3);
        for(int i=0 ; i < 2; i++){
            enfrentamientos4.remove(i);}

        fechaReferencia = LocalDate.now();
        fechasEnfrentamientos = new ArrayList<>();
        LocalDate proximoDomingo = fechaReferencia.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        for (int i = 0; i < enfrentamientos.size()/2; i++) {
            fechasEnfrentamientos.add(proximoDomingo);
            proximoDomingo = proximoDomingo.plusWeeks(1);
        }
    }

    public static EliminatoriaSimple getInstance(){
        if(instancia==null){
            instancia = new EliminatoriaSimple();
        }
        return instancia;
    }

    @Override
    public void actualizarEnfrentamientos() {
        ArrayList<Inscribible> ganadores = new ArrayList<>();
        //despues gestionar los primeros con logica externa
        for(int i = 0; i<enfrentamientos.size()-1; i++){
            ganadores.add(determinarGanador(enfrentamientos.get(i), enfrentamientos.get(i+1)));
            ganadores.getLast().aumentarVictorias();
        }
        enfrentamientos=ganadores;
    }

    @Override
    public void actualizarFechas(){
        LocalDate proximoDomingo = fechasEnfrentamientos.getLast().plusWeeks(2);
        fechasEnfrentamientos.clear();
        if(enfrentamientos.size()/2>0) {
            for (int i = 0; i < enfrentamientos.size() / 2; i++) {
                fechasEnfrentamientos.add(proximoDomingo);
                proximoDomingo = proximoDomingo.plusWeeks(1);
            }
        }
    }

    @Override
    public ArrayList<LocalDate> getFechasEnfrentamientos() {
        return fechasEnfrentamientos;
    }

    @Override
    public ArrayList<Inscribible> getCompetidores() {
        return competidores;
    }

    @Override
    public ArrayList<Inscribible> getEnfrentamientos() {
        return enfrentamientos;
    }

    public ArrayList<Inscribible> getEnfrentamientos2() {
        return enfrentamientos2;
    }

    public ArrayList<Inscribible> getEnfrentamientos3() {
        return enfrentamientos3;
    }

    public ArrayList<Inscribible> getEnfrentamientos4() {
        return enfrentamientos4;
    }
}

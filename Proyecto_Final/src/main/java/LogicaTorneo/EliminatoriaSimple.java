package LogicaTorneo;
import LogicaJuego.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Random;

public class EliminatoriaSimple extends Torneo {
	private ArrayList<Personaje> competidores;

    /**
     *
     */

    private ArrayList<Personaje>enfrentamientos;
    private LocalDate fechaReferencia;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    public EliminatoriaSimple(){
        competidores = new ArrayList<>();
        Random random = new Random();
        competidores.add(PlanillaPersonajes.getInstance().getPersonajes().getFirst());
        for (int i = 0; i < 15; i++) {
            int tipoPersonaje = random.nextInt(4);
            switch (tipoPersonaje) {
                case 0:
                    competidores.add(FabricaHumanos.crearPersonaje(1));
                    break;
                case 1:
                    competidores.add(FabricaCaballeros.crearPersonaje(1));
                    break;
                case 2:
                    competidores.add(FabricaCavernarios.crearPersonaje(1));
                    break;
                case 3:
                    competidores.add(FabricaNoMuertos.crearPersonaje(1));
                    break;
            }
            enfrentamientos = new ArrayList<>(competidores);
        }

        fechaReferencia = LocalDate.now();
        fechasEnfrentamientos = new ArrayList<>();
        LocalDate proximoDomingo = fechaReferencia.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        for (int i = 0; i < enfrentamientos.size()/2; i++) {
            fechasEnfrentamientos.add(proximoDomingo);
            proximoDomingo = proximoDomingo.plusWeeks(1);
        }
    }

    @Override
    public void actualizarEnfrentamientos() {
        ArrayList<Personaje> ganadores = new ArrayList<>();
        //despues gestionar los primeros con logica externa
        for(int i = 0; i<enfrentamientos.size()-1; i++){
            ganadores.add(determinarGanador(enfrentamientos.get(i), enfrentamientos.get(i+1)));
            ganadores.getLast().subirNivel();
        }
        enfrentamientos=ganadores;
    }

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

    public ArrayList<Personaje> getCompetidores() {
        return competidores;
    }

    @Override
    public ArrayList<Personaje> getEnfrentamientos() {
        return enfrentamientos;
    }
}

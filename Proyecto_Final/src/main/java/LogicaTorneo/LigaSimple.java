package LogicaTorneo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import java.util.Random;

import LogicaJuego.*;

public class LigaSimple extends Torneo{
    private int niveles;
    private ArrayList<Personaje> competidores;
    private ArrayList<ArrayList<Double>> estadisticas;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    public LigaSimple(int niveles){
        super(niveles);
        this.niveles = niveles;
        competidores = new ArrayList<>();
        Random random = new Random();
        competidores.add(PlanillaPersonajes.getInstance().getPersonajes().getFirst());
        for (int i = 0; i < niveles-1; i++) {
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
        }

        enfrentamientos = new ArrayList<>(competidores);
        System.out.println(enfrentamientos.size());

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
        for (int i = 0; i < enfrentamientos.size() - 1; i += 2) {
            Personaje comp1 = enfrentamientos.get(i);
            Personaje comp2 = enfrentamientos.get(i + 1);
            Personaje ganador = determinarGanador(comp1, comp2);
            if(ganador == comp1){
                comp1.disminuirPuntaje();
                comp2.aumentarPuntaje();
            }
            else {
                comp2.disminuirPuntaje();
                comp1.aumentarPuntaje();
            }
            competidores.getFirst().subirNivel();
        }
        Personaje aux = enfrentamientos.removeFirst();
        enfrentamientos.add(aux);
    }

    @Override
    public void actualizarFechas(){
        System.out.println(fechasEnfrentamientos.size());
        if(enfrentamientos.size()>1){
            LocalDate proximoDomingo = null;
            if (fechasEnfrentamientos.isEmpty()) {
                // If for some reason dates are empty, start from today/next Sunday
                proximoDomingo = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            } else {
                proximoDomingo = fechasEnfrentamientos.getLast().plusWeeks(2); // Use existing last date
            }

            fechasEnfrentamientos.clear();
            for (int i = 0; i < enfrentamientos.size() / 2; i++) {
                fechasEnfrentamientos.add(proximoDomingo);
                proximoDomingo = proximoDomingo.plusWeeks(1);
            }
        }
    }


    @Override
    public ArrayList<Personaje> getCompetidores() {
        return competidores;
    }
}

package LogicaTorneo;
import LogicaJuego.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Random;

public class EliminatoriaSimple extends Torneo {
    private int niveles;
	private ArrayList<Personaje> competidores;
    private ArrayList<Personaje>enfrentamientos;
    private LocalDate fechaReferencia;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    public EliminatoriaSimple(int niveles){
        super(niveles);
        this.niveles = niveles;
        competidores = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < Math.pow(2,niveles)-1; i++) {
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
        if(enfrentamientos.size()>1) {
            ArrayList<Personaje> ganadores = new ArrayList<>();
            for (int i = 0; i < enfrentamientos.size() - 1; i++) {
                if (i%2==0) {
                    ganadores.add(determinarGanador(enfrentamientos.get(i), enfrentamientos.get(i + 1)));
                    ganadores.getLast().subirNivel();
                }
            }
            enfrentamientos = ganadores;
            System.out.println(enfrentamientos.size());
        }
    }

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

    @Override
    public ArrayList<Personaje> getEnfrentamientos() {
        return enfrentamientos;
    }

    @Override
    public LocalDate getFechaReferencia() {
        return fechaReferencia;
    }

    @Override
    public ArrayList<LocalDate> getFechasEnfrentamientos() {
        return fechasEnfrentamientos;
    }

    @Override
    public int getNiveles() {
        return niveles;
    }
}

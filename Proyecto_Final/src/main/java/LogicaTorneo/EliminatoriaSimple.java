package LogicaTorneo;
import LogicaJuego.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Random;

public class EliminatoriaSimple extends Torneo {
    private int nivelesRestantes;
    private int nivelesCompletados;
	private ArrayList<Personaje> competidores;
    private ArrayList<Personaje>enfrentamientos;
    private ArrayList<ArrayList<Personaje>> historialEnfrentamientos;
    private ArrayList<ArrayList<LocalDate>> historialFechas;
    private LocalDate fechaReferencia;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    public EliminatoriaSimple(int nivelesRestantes){
        super(nivelesRestantes);
        this.nivelesRestantes = nivelesRestantes;
        this.nivelesCompletados = 0;
        competidores = new ArrayList<>();
        Random random = new Random();
        competidores.add(FabricaHumanos.crearPersonaje(1));
        for (int i = 0; i < Math.pow(2, nivelesRestantes)-1; i++) {
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


        fechaReferencia = LocalDate.now();
        fechasEnfrentamientos = new ArrayList<>();
        LocalDate proximoDomingo = fechaReferencia.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        for (int i = 0; i < enfrentamientos.size()/2; i++) {
            fechasEnfrentamientos.add(proximoDomingo);
            proximoDomingo = proximoDomingo.plusWeeks(1);
        }

        historialEnfrentamientos = new ArrayList<>();
        ArrayList<Personaje> e = new ArrayList<>(enfrentamientos);
        historialEnfrentamientos.add(e);

        historialFechas = new ArrayList<>();
        ArrayList<LocalDate> f = new ArrayList<>(fechasEnfrentamientos);
        historialFechas.add(f);
    }

    @Override
    public void actualizarEnfrentamientos() {
        if(!enfrentamientos.isEmpty()) {
            ArrayList<Personaje> ganadores = new ArrayList<>();
            for (int i = 1; i < enfrentamientos.size()-1; i++) {
                if (i%2==0) {
                    ganadores.add(determinarGanador(enfrentamientos.get(i), enfrentamientos.get(i + 1)));
                    ganadores.getLast().subirNivel();
                }
            }
            enfrentamientos = ganadores;
            ArrayList<Personaje> e = new ArrayList<>(enfrentamientos);
            historialEnfrentamientos.add(e);
        }
    }

    public void actualizarFechas(){
        if(!enfrentamientos.isEmpty()){
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
            ArrayList<LocalDate> f = new ArrayList<>(fechasEnfrentamientos);
            historialFechas.add(f);
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
    public int getNivelesRestantes() {
        return nivelesRestantes;
    }

    @Override
    public void setNivelesRestantes(int nivelesRestantes) {
        this.nivelesRestantes = nivelesRestantes;
    }

    public ArrayList<ArrayList<Personaje>> getHistorialEnfrentamientos() {
        return historialEnfrentamientos;
    }

    public ArrayList<ArrayList<LocalDate>> getHistorialFechas() {
        return historialFechas;
    }

    @Override
    public int getNivelesCompletados() {
        return nivelesCompletados;
    }

    @Override
    public void setNivelesCompletados(int nivelesCompletados) {
        this.nivelesCompletados = nivelesCompletados;
    }
}

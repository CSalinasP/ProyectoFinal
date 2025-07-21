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
    private ArrayList<ArrayList<Object>> estadisticas;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    public LigaSimple(int niveles){
        super(niveles);
        competidores = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
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

        LocalDate fechaReferencia = LocalDate.now();
        LocalDate proximoLunes = fechaReferencia.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        this.fechasEnfrentamientos = new ArrayList<LocalDate>();
        for (int i = 0; i < 10; i++) {
            fechasEnfrentamientos.add(proximoLunes);
            proximoLunes = proximoLunes.plusWeeks(1);
        }
    }

    public void actualizarEnfrentamientos() {
        Personaje aux = competidores.removeFirst();
        ArrayList<Personaje> perdedores = new ArrayList<>();
        for (int i = 0; i < competidores.size() - 1; i += 2) {
            Personaje comp1 = competidores.get(i);
            Personaje comp2 = competidores.get(i + 1);
            Personaje perdedor = determinarGanador(comp1, comp2);
            if(perdedor == comp1){
                comp1.disminuirPuntaje();
                comp2.aumentarPuntaje();
            }
            competidores.getFirst().subirNivel();
        }
        competidores.add(aux);
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


    @Override
    public ArrayList<Personaje> getCompetidores() {
        return competidores;
    }
}

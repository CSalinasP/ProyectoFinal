package LogicaTorneo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import java.util.Random;

import LogicaJuego.*;

public class LigaSimple extends Torneo{
    private int nivelesRestantes;
    private int nivelesCompletados;
    private ArrayList<Personaje> competidores;
    private ArrayList<LocalDate> fechasEnfrentamientos;
    private ArrayList<ArrayList<Personaje>> historialEnfrentamientos;
    private ArrayList<ArrayList<LocalDate>> historialFechas;

    public LigaSimple(int nivelesRestantes){
        super(nivelesRestantes);
        this.nivelesRestantes = nivelesRestantes;
        competidores = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < nivelesRestantes+1; i++) {
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

        historialEnfrentamientos = new ArrayList<>();
        ArrayList<Personaje> e = new ArrayList<>(enfrentamientos);
        historialEnfrentamientos.add(e);

        historialFechas = new ArrayList<>();
        ArrayList<LocalDate> f = new ArrayList<>(fechasEnfrentamientos);
        historialFechas.add(f);
    }

    @Override
    public void actualizarEnfrentamientos() {
        if(!enfrentamientos.isEmpty()){
            for (int i = 0; i < enfrentamientos.size() - 1; i += 2) {
                Personaje comp1 = enfrentamientos.get(i);
                Personaje comp2 = enfrentamientos.get(i + 1);
                if (comp1 == null || comp2 == null) {
                    continue;
                }
                Personaje ganador = determinarGanador(comp1, comp2);
                comp1.subirNivel();
                comp2.subirNivel();
                if(ganador == comp1){
                   comp1.setVictorias(comp1.getVictorias()+1);
                   comp2.setDerrotas(comp2.getDerrotas()+1);
                }
                else {
                    comp2.setVictorias(comp2.getVictorias()+1);
                    comp1.setDerrotas(comp1.getDerrotas()+1);
                }
            }
            if(!enfrentamientos.isEmpty()){
                Personaje aux = enfrentamientos.removeFirst();
                enfrentamientos.add(aux);}
            ArrayList<Personaje> e = new ArrayList<>(enfrentamientos);
            historialEnfrentamientos.add(e);}
    }

    @Override
    public void actualizarFechas(){
        System.out.println(fechasEnfrentamientos.size());
        if(enfrentamientos.size()>1){
            LocalDate proximoDomingo = null;
            if (fechasEnfrentamientos.isEmpty()) {
                proximoDomingo = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            } else {
                proximoDomingo = fechasEnfrentamientos.getLast().plusWeeks(2);
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


    public void posisionar() {
        for (int i = 0; i < competidores.size() - 1; i++) {
            for (int j = 0; j < competidores.size() - i - 1; j++) {
                if (competidores.get(j).ratioVictoriaDerrota() > competidores.get(j + 1).ratioVictoriaDerrota()) {
                    Personaje aux = competidores.get(j);
                    competidores.set(j, competidores.get(j + 1));
                    competidores.set(j + 1, aux);
                }
            }
        }

        if (!competidores.isEmpty()) {
            int posicionActual = 1;
            for (int i = competidores.size() - 1; i >= 0; i--) {
                competidores.get(i).setPosision(posicionActual);
                if (i > 0 && competidores.get(i).ratioVictoriaDerrota() != competidores.get(i - 1).ratioVictoriaDerrota()) {
                    posicionActual++;
                }
            }
        }
    }

    @Override
    public ArrayList<LocalDate> getFechasEnfrentamientos() {
        return fechasEnfrentamientos;
    }

    @Override
    public ArrayList<Personaje> getEnfrentamientos() {
        return super.getEnfrentamientos();
    }

    @Override
    public ArrayList<Personaje> getCompetidores() {
        return competidores;
    }

    @Override
    public int getNivelesRestantes() {
        return nivelesRestantes;
    }

    @Override
    public void setNivelesRestantes(int nivelesRestantes) {
        this.nivelesRestantes = nivelesRestantes;
    }

    @Override
    public int getNivelesCompletados() {
        return nivelesCompletados;
    }

    @Override
    public void setNivelesCompletados(int nivelesCompletados) {
        this.nivelesCompletados = nivelesCompletados;
    }

    @Override
    public ArrayList<ArrayList<Personaje>> getHistorialEnfrentamientos() {
        return historialEnfrentamientos;
    }

    public void setHistorialEnfrentamientos(ArrayList<ArrayList<Personaje>> historialEnfrentamientos) {
        this.historialEnfrentamientos = historialEnfrentamientos;
    }

    @Override
    public ArrayList<ArrayList<LocalDate>> getHistorialFechas() {
        return historialFechas;
    }

    public void setHistorialFechas(ArrayList<ArrayList<LocalDate>> historialFechas) {
        this.historialFechas = historialFechas;
    }
}

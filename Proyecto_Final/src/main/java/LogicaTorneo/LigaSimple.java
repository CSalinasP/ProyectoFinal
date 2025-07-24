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

    public LigaSimple(int nivelesRestantes){
        super(nivelesRestantes);
        this.nivelesRestantes = nivelesRestantes;
        competidores = new ArrayList<>();
        Random random = new Random();
        //**competidores.add(null);*/
        for (int i = 0; i < nivelesRestantes; i++) {
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


    public void posisionar(){
        for (int i = 0; i < competidores.size() - 1; i++) {
            for (int j = 0; j < competidores.size() - i - 1; j++) {
                if (enfrentamientos.get(i).ratioVictoriaDerrota() > enfrentamientos.get(i+1).ratioVictoriaDerrota()) {
                    Personaje aux = enfrentamientos.get(j);
                    enfrentamientos.set(j,enfrentamientos.get(i+1));
                    enfrentamientos.set(i+1, aux);
                }
            }
        }
        enfrentamientos.getLast().setPosision(1);
        for(int i = -2; i>-competidores.size(); i--) {
            if(enfrentamientos.get(i).ratioVictoriaDerrota()==(enfrentamientos.get(i+1).ratioVictoriaDerrota())){
                enfrentamientos.get(i).setPosision(enfrentamientos.get(i+1).getPosision());
            }
            else{enfrentamientos.get(i).setPosision(enfrentamientos.get(i+1).getPosision()+1);}
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
}

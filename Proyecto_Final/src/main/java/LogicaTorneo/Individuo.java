package LogicaTorneo;

import LogicaJuego.FabricaCavernarios;
import LogicaJuego.Personaje;

public class Individuo implements Inscribible{
    private String nombre;
    private int numeroIndividuo;

    public Individuo(){}

    @Override
    public void inscribir(Torneo torneo) {
        torneo.getCompetidores().add(FabricaCavernarios.crearPersonaje(3));
    }
}

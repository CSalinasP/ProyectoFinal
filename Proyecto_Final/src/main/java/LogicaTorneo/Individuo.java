package LogicaTorneo;

public class Individuo implements Inscribible{
    private String nombre;
    private int numeroIndividuo;

    public Individuo(){}

    @Override
    public void inscribir(Torneo torneo) {
        torneo.getCompetidores().add(this);
    }
}

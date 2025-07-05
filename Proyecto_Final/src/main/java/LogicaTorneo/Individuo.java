package LogicaTorneo;

public class Individuo implements Inscribible{
    private String nombre;
    private int numeroIndividuo;
    private Equipo equipo;

    public Individuo(String nombre, int numeroIndividuo, Equipo equipo ){
        this.nombre = nombre;
        this.numeroIndividuo = numeroIndividuo;
        
    }

    @Override
    public void inscribir(Torneo torneo) {
        torneo.getCompetidores().add(this);
    }
}

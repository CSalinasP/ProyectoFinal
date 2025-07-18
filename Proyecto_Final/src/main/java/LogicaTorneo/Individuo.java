package LogicaTorneo;

public class Individuo extends Inscribible{
    private String nombre;
    private int numeroIndividuo;
    private int victorias;
    private int derrotas;

    public Individuo(){}

    @Override
    public void inscribir(Torneo torneo) {
        torneo.getCompetidores().add(this);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void aumentarVictorias(){
        victorias+=1;
    }
    public int getVictorias() {
        return victorias;
    }
    public int getDerrotas() {
        return derrotas;
    }
}




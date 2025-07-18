package LogicaTorneo;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends Inscribible {
    private String nombreEquipo;
    private int numeroEquipo;
    private int victorias;
    private int derrotas;
    private List<Inscribible> competidores;

    public Equipo(String nombreEquipo, int numeroEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.numeroEquipo = numeroEquipo;
        this.competidores = new ArrayList<>();
    }

    public void aumentarVictorias(){
        victorias+=1;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    @Override
    public void setDerrotas(int derrotas) {
        super.setDerrotas(derrotas);
    }

    @Override
    public void inscribir(Torneo torneo){
        torneo.getCompetidores().add(this);
    }

    /**
    public void agregarJugador(Jugador jugador) {
        if (jugador.getEquipo() != this) {
            // Si el jugador ya tiene un equipo, eliminarlo del equipo anterior
            if (jugador.getEquipo() != null) {
                jugador.getEquipo().eliminarJugador(jugador);
            }
            jugadores.add(jugador);
            jugador.setEquipo(this);
        }
    }

    public void eliminarJugador(Jugador jugador) {
        if (jugadores.remove(jugador)) {
            jugador.setEquipo(null);
        }
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public int getNumeroEquipo() {
        return numeroEquipo;
    }

    public int getCantidadDeJugadores() {
        return jugadores.size();
    }

    @Override
    public String toString() {
        return "Equipo " + nombreEquipo + " (#" + numeroEquipo + ") con " + jugadores.size() + " jugadores";
    }*/
}
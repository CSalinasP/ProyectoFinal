import LogicaJuego.Personaje;
import LogicaTorneo.Torneo;

import java.util.ArrayList;

// Subclase de Torneo solo para test
class TorneoDummy extends Torneo {
    public TorneoDummy(int niveles) {
        super(niveles);
        this.competidores = new ArrayList<>();
        this.enfrentamientos = new ArrayList<>();
    }

    // Setter auxiliar para pruebas, si hace falta:
    public void setCompetidores(ArrayList<Personaje> lista) {
        this.competidores = lista;
    }

    /**
     * Actualiza los pares enfrentados conforme vayan quedando menos
     */
    @Override
    public void actualizarEnfrentamientos() {

    }

    /**
     *
     */
    @Override
    public void actualizarFechas() {

    }

    @Override
    public ArrayList<Personaje> getEnfrentamientos() {
        return super.getEnfrentamientos();
    }

    @Override
    public void setEnfrentamientos(ArrayList<Personaje> enfrentamientos) {
        super.setEnfrentamientos(enfrentamientos);
    }
}
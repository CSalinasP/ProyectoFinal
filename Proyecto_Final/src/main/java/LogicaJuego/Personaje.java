package LogicaJuego;

import LogicaTorneo.Individuo;
import LogicaTorneo.Inscribible;
import LogicaTorneo.Torneo;

import java.util.ArrayList;

public abstract class Personaje extends Individuo {
    private String nombre;
    private int vida;
    private int fuerza;
    private int invulnerabilidad; //en contra en caso de debilidad
    private int regeneración;
    private int victorias;
    private int derrotas;
    private ArrayList<Habilidad> habilidades;
    // private RecursosGraficos sprites; //

    public Personaje(){
        habilidades = new ArrayList<>();
    }

    public void setSprites(){
    }

    @Override
    public void inscribir(Torneo torneo) {
        torneo.getCompetidores().add(this);
    }

    public void añadirHabilidad(Habilidad habilidad){
        habilidades.add(habilidad);
    }

    public String getNombre(){
        return nombre;
    }

    public int getVida(){
        return vida;
    }

    @Override
    public int getVictorias() {
        return victorias;
    }

    @Override
    public int getDerrotas() {
        return derrotas;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInvulnerabilidad() {
        return invulnerabilidad;
    }

    public int getRegeneracion() {
        return regeneración;
    }

    public ArrayList<Habilidad> getHabilidades(){
        return habilidades;
    }

    public void modificarVida(int numero){
        vida = vida + numero;
    }

    @Override
    public String toString(){
        return "Nombre: "+getNombre()+", Vida: "+getVida();
    }
}

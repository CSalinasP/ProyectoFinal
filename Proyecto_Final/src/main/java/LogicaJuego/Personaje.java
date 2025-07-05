package LogicaJuego;

import LogicaTorneo.Inscribible;
import LogicaTorneo.Torneo;

import java.util.ArrayList;

public abstract class Personaje implements Inscribible{
    private String nombre;
    private int vida;
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

package org.LogicaJuego;
import java.util.ArrayList;

/**
 * Clase que representa a los Personajes y sus caracteristicas
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-05
 */
public class Personaje {
    /** El nombre del Personaje */
    private String nombre;
    /** La vida total o máxima del Personaje */
    private int vidaTotal;
    /** La vida actual del Personaje */
    private int vida;
    /** La resistencia al daño del Personaje */
    private int resistencia;
    /** La regeneracion de vida por turno del Personaje */
    private int regeneracion;
    /** La lista de habilidades del Personaje */
    private ArrayList<Habilidad> habilidades;
    // private RecursosGraficos sprites; //

    /**
     * Constructor que declara al Personaje con sus caracteristicas
     *
     * @param Nombre El nombre del Personaje
     * @param Vida La vida máxima del Personaje
     * @param Resistencia La resistencia al daño del Personaje
     * @param Regeneracion La regeneracion por turno del Personaje
     * Se crea también el Arraylist con la lista de Habilidades
     */
    public Personaje(String Nombre, int Vida, int Resistencia, int Regeneracion){
        nombre = Nombre;
        vidaTotal = Vida;
        vida = Vida;
        resistencia = Resistencia;
        regeneracion = Regeneracion;
        habilidades = new ArrayList<>();
    }
    // por hacer
    public void setSprites(){
    }

    /**
     * Metodo que añade una habilidad a la lista de habilidades del Personaje
     *
     * @param habilidad La habilidad que se agrega
     */
    public void addHabilidad(Habilidad habilidad){
        habilidades.add(habilidad);
    }

    /**
     * Metodo getter que retorna el nombre del Personaje
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter que retorna la vida total o máxima del Personaje
     */
    public int getVidaTotal(){
        return vidaTotal;
    }

    /**
     * Metodo getter que retorna la vida actual del Personaje
     */
    public int getVida(){
        return vida;
    }

    /**
     * Metodo getter que retorna la lista de habilidades del Personaje
     */
    public ArrayList<Habilidad> getHabilidades(){
        return habilidades;
    }

    /**
     * Metodo que cura al Personaje
     *
     * @param numero La cantidad que se va a curar
     * Si después de curar, la vida actual sobrepasa la vida máxima del Personaje:
     * Se iguala la vida actual con la vida máxima
     */
    public void curarVida(int numero){
        vida = vida + numero;
        if (vida > vidaTotal){
            vida = vidaTotal;
        }
    }

    /**
     * Metodo que le quita vida al Personaje
     *
     * @param numero La cantidad de daño que va a recibir el Personaje
     * El daño se reducirá dependiendo de la resistencia al daño del Personaje
     * Si después de recibir daño, la vida actual es menor a 0, se iguala a 0
     */
    public void quitarVida(int numero){
        vida = vida - ((1-resistencia)*numero);
        if (vida<0){
            vida = 0;
        }
    }

    /**
     * Metodo que cura al Personaje en cada turno
     * Depende de la cantidad de regeneracion que tiene el Personaje
     * Si después de curar, la vida actual sobrepasa la vida máxima del Personaje:
     * Se iguala la vida actual con la vida máxima
     */
    public void regenerarVida(){
        vida = vida + regeneracion;
        if (vida>vidaTotal){
            vida = vidaTotal;
        }
    }

    @Override
    public String toString(){
        return "Nombre: "+getNombre()+", Vida: "+getVida();
    }
}

package org.LogicaJuego;
import java.util.ArrayList;

/**
 * Clase que representa la planilla de Personajes del jugador
 *
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-05
 */

class PlanillaPersonajes {
    /** La lista que contiene a los personajes */
    ArrayList<Personaje> personajes;
    /** La instancia de esta clase */
    static PlanillaPersonajes instancia;

    /**
     * Constructor que solo crea el Arraylist con los Personajes
     */
    public PlanillaPersonajes(){
        personajes = new ArrayList<>();
    }

    /**
     * Metodo que añade un Personaje a la lista de Personajes
     *
     * @param personaje Personaje que se añade
     */
    public void addPersonaje(Personaje personaje){
        personajes.add(personaje);
    }

    /**
     * Metodo que retorna la instancia de la clase
     */
    public PlanillaPersonajes getInstancia(){
        return instancia;
    }

    /**
     * Metodo que retorna la lista de Personajes
     */
    public ArrayList<Personaje> getPersonajes(){
        return personajes;
    }

    @Override
    public String toString(){
        String aux = new String();
        for (int i=0;i<personajes.size();i++){
            Personaje aux2 = personajes.get(i);
            aux = aux + "Personaje "+(i+1)+": "+aux2.getNombre()+". ";
        }
        return aux;
    }
}
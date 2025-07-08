package LogicaJuego;
import GUIJuego.VentanaJuego;
import LogicaTorneo.Inscribible;

import java.util.ArrayList;


/**
 * Clase que representa la planilla de Personajes del jugador
 *
 * @author CSalinasP
 * @version 1.1
 * @since 2025-07-07
 */
public class PlanillaPersonajes {
    /** La lista que contiene a los personajes */
    ArrayList<Personaje> personajes;
    /** La instancia de esta clase */
    static PlanillaPersonajes instancia;

    /**
     * Constructor que crea el Arraylist para la lista de Personajes
     */
    private PlanillaPersonajes(){
        personajes = new ArrayList<>();
    }

    /**
     * Metodo static que retorna la instancia actual de la clase
     */
    public static PlanillaPersonajes getInstance(){
        if(instancia==null){
            instancia = new PlanillaPersonajes();
        }
        return instancia;
    }

    /**
     * Metodo que añade un Personaje a la lista de Personajes
     *
     * @param tipoPersonaje El tipo de Personaje que se quiere añadir
     * @param Nivel El nivel del Personaje deseado
     */
    public void añadirPersonaje(TipoPersonaje tipoPersonaje, int Nivel){
        personajes.add(FabricaPersonajes.crearPersonaje(tipoPersonaje, Nivel));
    }

    // por definir...
    public Personaje seleccionarPersonaje(TipoPersonaje tipoPersonaje){
        return personajes.get(0);
    }

    /**
     * Metodo getter que retorna la lista de Personajes
     */
    public ArrayList<Personaje> getPersonajes(){
        return personajes;
    }

    @Override
    public String toString(){
        StringBuilder aux = new StringBuilder();
        for (int i=0;i<personajes.size();i++){
            Personaje aux2 = personajes.get(i);
            aux.append("Personaje ").append(i + 1).append(": ").append(aux2.toString()).append(". ");
        }
        return aux.toString();
    }
}
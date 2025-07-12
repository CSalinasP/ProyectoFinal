package LogicaJuego;
import GUIJuego.VentanaJuego;
import LogicaTorneo.Inscribible;

import java.util.ArrayList;


/**
 * Clase que representa la planilla de Personajes del jugador
 *
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-05
 */
public class PlanillaPersonajes {
    /** La lista que contiene a los personajes */
    ArrayList<Personaje> personajes;
    /** La instancia de esta clase */
    static PlanillaPersonajes instancia;

    private PlanillaPersonajes(){
        personajes = new ArrayList<>();
    }

    public static PlanillaPersonajes getInstance(){
        if(instancia==null){
            instancia = new PlanillaPersonajes();
        }
        return instancia;
    }

    /**
     * Metodo que añade un Personaje a la lista de Personajes
     *
     * @param tipoPersonaje Personaje que se añade
     */
    public void añadirPersonaje(TipoPersonaje tipoPersonaje){
        personajes.add(FabricaPersonajes.crearPersonaje(tipoPersonaje));
    }

    public Personaje seleccionarPersonaje(TipoPersonaje tipoPersonaje){
        return personajes.get(0);
    }


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
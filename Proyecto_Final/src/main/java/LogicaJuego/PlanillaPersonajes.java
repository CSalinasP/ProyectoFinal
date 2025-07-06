package LogicaJuego;
import GUIJuego.VentanaJuego;
import LogicaTorneo.Inscribible;

import java.util.ArrayList;

public class PlanillaPersonajes {
    private static PlanillaPersonajes instancia;
    private ArrayList<Personaje> personajes;

    private PlanillaPersonajes(){
        personajes = new ArrayList<>();
    }

    public static PlanillaPersonajes getInstance(){
        if(instancia==null){
            instancia = new PlanillaPersonajes();
        }
        return instancia;
    }

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
package org.LogicaJuego;
import java.util.ArrayList;

class PlanillaPersonajes {
    ArrayList<Personaje> personajes;
    static PlanillaPersonajes instancia;

    public PlanillaPersonajes(){
        personajes = new ArrayList<>();
    }

    public void añadirPersonaje(Personaje personaje){
        personajes.add(personaje);
    }

    public PlanillaPersonajes getInstancia(){
        return instancia;
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
package org.LogicaJuego;

public class FabricaPersonajes {

    public FabricaPersonajes(){
    }

    static Personaje crearPersonaje(String Nombre, int Vida){
        return new Personaje(Nombre, Vida);
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes";
    }
}

package GUIJuego;

import javax.swing.*;

public class ComandoOcultarOpciones implements Comando {
    private JPanel opciones;
    private BotonGenerico botonGenerico;

    public ComandoOcultarOpciones(JPanel opciones, BotonGenerico botonGenerico){
        this.opciones = opciones;
        this.botonGenerico = botonGenerico;
    }

    @Override
    public void ejecutar() {
        if(opciones instanceof OpcionesTorneo){
            OpcionesTorneo opcionesTorneo = (OpcionesTorneo) opciones;
            opcionesTorneo.OcultarOpciones(botonGenerico.getNombre());
        }
        else if(opciones instanceof OpcionesNiveles){
            OpcionesNiveles opcionesNiveles = (OpcionesNiveles) opciones;
            opcionesNiveles.OcultarOpciones(botonGenerico.getNombre());
        }
        else if(opciones instanceof MenuEntreCombates){
            MenuEntreCombates opcionesAvatar = (MenuEntreCombates) opciones;
            opcionesAvatar.OcultarOpciones(botonGenerico.getNombre());
        }
    }
}

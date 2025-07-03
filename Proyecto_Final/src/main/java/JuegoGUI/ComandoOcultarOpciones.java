package JuegoGUI;

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
        else{
            OpcionesAvatares opcionesAvatares = (OpcionesAvatares) opciones;
            opcionesAvatares.OcultarOpciones(botonGenerico.getNombre());
        }
    }
}

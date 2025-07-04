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
        else{
            OpcionesAvatares opcionesAvatares = (OpcionesAvatares) opciones;
            opcionesAvatares.OcultarOpciones(botonGenerico.getNombre());
        }
        if(opciones instanceof OpcionesTorneo){
            OpcionesTorneo opcionesTorneo = (OpcionesTorneo) opciones;
            opcionesTorneo.MostrarOpciones();
        } else if (opciones instanceof OpcionesAvatares) {
            OpcionesAvatares opcionesAvatares = (OpcionesAvatares) opciones;
            opcionesAvatares.MostrarOpciones();
        } else if (opciones instanceof MenuEntreCombates) { // <-- ¡Nueva sección!
            MenuEntreCombates menuEntreCombates = (MenuEntreCombates) opciones;
            menuEntreCombates.MostrarOpcionesAvatares(); // Muestra los 16 avatares
        }
    }
}

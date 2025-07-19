// Modificar este archivo
package GUIJuego;

import javax.swing.*;

public class ComandoMostrarOpciones implements Comando{
    private JPanel opciones;

    public ComandoMostrarOpciones(JPanel opciones){
        this.opciones = opciones;
    }

    @Override
    public void ejecutar() {
        if(opciones instanceof OpcionesTorneo){
            OpcionesTorneo opcionesTorneo = (OpcionesTorneo) opciones;
            opcionesTorneo.MostrarOpciones();
        } else if (opciones instanceof OpcionesNiveles) {
            OpcionesNiveles opcionesNiveles = (OpcionesNiveles) opciones;
            opcionesNiveles.MostrarOpciones();
        } else if (opciones instanceof MenuEntreCombates) {
            MenuEntreCombates menuEntreCombates = (MenuEntreCombates) opciones;
            menuEntreCombates.MostrarOpciones();
        }
    }
}
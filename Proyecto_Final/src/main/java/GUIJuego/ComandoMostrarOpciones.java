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
        } else if (opciones instanceof OpcionesAvatares) {
            OpcionesAvatares opcionesAvatares = (OpcionesAvatares) opciones;
            opcionesAvatares.MostrarOpciones();
        } else if (opciones instanceof MenuEntreCombates) { // <-- ¡Nueva sección!
            MenuEntreCombates menuEntreCombates = (MenuEntreCombates) opciones;
            menuEntreCombates.MostrarOpcionesAvatares(); // Muestra los 16 avatares
        }
    }
}
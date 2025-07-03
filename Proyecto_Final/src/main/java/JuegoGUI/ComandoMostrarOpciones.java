package JuegoGUI;

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
        }
        else{
            OpcionesAvatares opcionesAvatares = (OpcionesAvatares) opciones;
            opcionesAvatares.MostrarOpciones();
        }
    }

}

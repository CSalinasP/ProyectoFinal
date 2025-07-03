package JuegoGUI;
import javax.swing.*;

public class BotonGenerico extends JButton{
    private Comando comando;
    private String nombre;

    public BotonGenerico(Comando comando, String nombre){
        this.comando = comando;
        this.nombre = nombre;
        super(nombre);
    }

    public Comando getComando(){
        return comando;
    }

    public void setComando(Comando comando){this.comando = comando;}

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

package LogicaJuego;
import java.util.ArrayList;

public class Personaje {
    private String nombre;
    private int vida;
    private ArrayList<Habilidad> habilidades;
    // private RecursosGraficos sprites; //

    public Personaje(String Nombre, int Vida){
        nombre = Nombre;
        vida = Vida;
        habilidades = new ArrayList<>();
    }

    public void setSprites(){
    }

    public void añadirHabilidad(Habilidad habilidad){
        habilidades.add(habilidad);
    }

    public String getNombre(){
        return nombre;
    }

    public int getVida(){
        return vida;
    }

    public ArrayList<Habilidad> getHabilidades(){
        return habilidades;
    }

    public void modificarVida(int numero){
        vida = vida + numero;
    }

    @Override
    public String toString(){
        return "Nombre: "+getNombre()+", Vida: "+getVida();
    }
}

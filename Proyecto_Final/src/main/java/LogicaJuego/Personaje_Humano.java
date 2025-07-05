package LogicaJuego;

public class Personaje_Humano extends Personaje{
    private String nombre;
    public Personaje_Humano(){
        nombre = "Humano";
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

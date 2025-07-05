package LogicaJuego;

public class Personaje_Caballero extends Personaje{
    private String nombre;
    public Personaje_Caballero(){
        nombre = "Caballero";
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

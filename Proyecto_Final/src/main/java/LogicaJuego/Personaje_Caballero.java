package LogicaJuego;

public class Personaje_Caballero extends Personaje{
    private String nombre;
    private String tipo;
    public Personaje_Caballero(){
        nombre = "Caballero";
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

package LogicaJuego;

public class Personaje_NoMuerto extends Personaje{
    private String nombre;
    public Personaje_NoMuerto(){
        nombre = "No-Muerto";
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

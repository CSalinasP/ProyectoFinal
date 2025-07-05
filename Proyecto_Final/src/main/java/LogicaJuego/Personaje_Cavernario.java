package LogicaJuego;

public class Personaje_Cavernario extends Personaje{
    private String nombre;
    public Personaje_Cavernario(){
        nombre = "Cavernario";
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

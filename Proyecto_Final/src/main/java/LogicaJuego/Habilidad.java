package LogicaJuego;

abstract class Habilidad {
    private String nombre;
    private int damage; // daño del ataque
    private int curacion;

    public Habilidad(String Nombre, int Damage, int Curacion){
        nombre = Nombre;
        damage = Damage;
        curacion = Curacion;
    }

    public String getNombre(){
        return nombre;
    }

    public int getDamage(){
        return damage;
    }

    public int getCuracion(){
        return curacion;
    }

    public int usar(Personaje personaje){
        personaje.modificarVida(curacion);
        return damage;
    } //contiene una referencia sobre un personaje y tiene un efecto sobre el

    @Override
    public String toString(){
        return "Habilidad: "+getNombre()+", Daño: "+getDamage()+", Curacion: "+getCuracion();
    }
}

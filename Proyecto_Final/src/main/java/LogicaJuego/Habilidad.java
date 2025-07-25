package LogicaJuego;

/**
 * Clase que representa las habilidades de los personajes y gestiona sus características.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */

public class Habilidad {
    /** El nombre de la habilidad. */
    private String nombre;
    /** La cantidad de daño de la habilidad. */
    private int damage;
    /** La cantidad de curación de la habilidad. */
    private int curacion;

    /**
     * Constructor que declara las características de la habilidad.
     * @param Nombre Nombre de la habilidad.
     * @param Damage El daño de la habilidad.
     * @param Curacion La curación de la habilidad.
     */
    public Habilidad(String Nombre, int Damage, int Curacion){
        nombre = Nombre;
        damage = Damage;
        curacion = Curacion;
    }

    /**
     * Metodo que sube de nivel el daño y la curación de la habilidad.
     * Si uno de los atributos era 0, sabemos que es una habilidad que o solo hace daño o solo cura,
     * asi que no se aumenta tal atributo.
     */
    public void subirNivel(){
        if (damage>0){
            damage += 5;
        }
        if (curacion>0){
            curacion += 5;
        }
    }

    /**
     * Metodo getter que retorna el nombre de la habilidad.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter que retorna el daño de la habilidad.
     */
    public int getDamage(){
        return damage;
    }

    /**
     * Metodo getter que retorna la curación de la habilidad.
     */
    public int getCuracion(){
        return curacion;
    }

    @Override
    public String toString(){
        return "Habilidad: "+getNombre()+", " +
                "Daño: "+getDamage()+", " +
                "Curacion: "+getCuracion();
    }
}
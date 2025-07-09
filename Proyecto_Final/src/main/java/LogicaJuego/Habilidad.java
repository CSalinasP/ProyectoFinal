package LogicaJuego;

/**
 * Clase que representa las habilidades de los Personajes y gestiona sus caracteristicas
 *
 * @author CSalinasP
 * @version 1.0
 * @since 2025-07-05
 */

abstract class Habilidad {
    /** El nombre de la habilidad */
    private String nombre;
    /** La cantidad de daño de la habilidad */
    private int damage;
    /** La cantidad de curacion de la habilidad */
    private int curacion;

    /**
     * Constructor que declara las caracteristicas de la habilidad
     *
     * @param Nombre Nombre de la habilidad
     * @param Damage El daño de la habilidad
     * @param Curacion La curacion de la habilidad
     */
    public Habilidad(String Nombre, int Damage, int Curacion){
        nombre = Nombre;
        damage = Damage;
        curacion = Curacion;
    }

    /**
     * Metodo getter que retorna el nombre de la habilidad
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter que retorna el daño de la habilidad
     */
    public int getDamage(){
        return damage;
    }

    /**
     * Metodo getter que retorna la curación de la habilidad
     */
    public int getCuracion(){
        return curacion;
    }

    /**
     * Metodo que usa la habilidad en un personaje
     *
     * @param personaje Personaje al que se le aplica los efectos de la habilidad
     */
    public int usar(Personaje personaje){
        personaje.curarVida(curacion);
        return damage;
    }

    @Override
    public String toString(){
        return "Habilidad: "+getNombre()+", Daño: "+getDamage()+", Curacion: "+getCuracion();
    }
}
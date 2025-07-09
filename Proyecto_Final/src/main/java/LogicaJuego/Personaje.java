package LogicaJuego;
import LogicaTorneo.Inscribible;
import LogicaTorneo.Torneo;
import java.util.ArrayList;

/**
 * Clase que representa a los Personajes y sus características
 *
 * @author CSalinasP
 * @version 1.1
 * @since 2025-07-07
 */
public class Personaje implements Inscribible{
    /** El nombre del Personaje asociado a tu Tipo de Personaje*/
    private String nombre;
    /** La vida total o máxima del Personaje */
    private int vidaTotal;
    /** La vida actual del Personaje */
    private int vida;
    /** La resistencia al daño del Personaje */
    private int resistencia;
    /** La regeneración de vida por turno del Personaje */
    private int regeneracion;
    /** La lista de habilidades del Personaje */
    private ArrayList<Habilidad> habilidades;
    // private RecursosGraficos sprites; //


    /**
    * Constructor que declara al Personaje con sus características
     *
     * @param Nombre El nombre del Personaje asociado a qué tipo de Personaje es
     * @param Vida La vida del Personaje
     * @param Resistencia La resistencia del Personaje
     * @param Regeneracion La regeneración del Personaje
     * También se crea el Arraylist para las habilidades
    */
    public Personaje(String Nombre, int Vida, int Resistencia, int Regeneracion){
        nombre = Nombre;
        vida = Vida;
        resistencia = Resistencia;
        regeneracion = Regeneracion;
        habilidades = new ArrayList<Habilidad>();
    }

    /**
     * Metodo que cura al Personaje
     *
     * @param numero La cantidad que se va a curar
     * Si después de curar, la vida actual sobrepasa la vida máxima del Personaje:
     * Se iguala la vida actual con la vida máxima
     */
    public void curarVida(int numero){
        vida = vida + numero;
        if (vida > vidaTotal){
            vida = vidaTotal;
        }
    }

    /**
     * Metodo que le quita vida al Personaje
     *
     * @param numero La cantidad de daño que va a recibir el Personaje
     * El daño se reducirá dependiendo de la resistencia al daño del Personaje
     * Si después de recibir daño, la vida actual es menor a 0, se iguala a 0
     */
    public void quitarVida(int numero){
        vida = vida - ((1-resistencia)*numero);
        if (vida<0){
            vida = 0;
        }
    }

    /**
     * Metodo que cura al Personaje en cada turno
     * Depende de la cantidad de regeneración que tiene el Personaje
     * Si después de curar, la vida actual sobrepasa la vida máxima del Personaje:
     * Se iguala la vida actual con la vida máxima
     */
    public void regenerarVida(){
        vida = vida + regeneracion;
        if (vida>vidaTotal){
            vida = vidaTotal;
        }
    }

    // por hacer
    public void setSprites(){
    }

    /**
     * Metodo que inscribe al Personaje en el Torneo
     *
     * @param torneo El torneo al cual se le quiere inscribir
     */
    @Override
    public void inscribir(Torneo torneo) {
        torneo.getCompetidores().add(this);
    }

    /**
     * Metodo que añade una habilidad a la lista de habilidades del Personaje
     *
     * @param habilidad La habilidad que se agrega
     */
    public void addHabilidad(Habilidad habilidad){
        habilidades.add(habilidad);
    }

    /**
     * Metodo getter que retorna el nombre del Personaje
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter que retorna la vida del Personaje
     */
    public int getVida(){
        return vida;
    }

    /**
     * Metodo getter que retorna la resistencia del Personaje
     */
    public int getResistencia(){
        return resistencia;
    }

    /**
     * Metodo getter que retorna la regeneración del Personaje
     */
    public int getRegeneracion(){
        return regeneracion;
    }

    /**
     * Metodo getter que retorna la lista de habilidades del Personaje
     */
    public ArrayList<Habilidad> getHabilidades(){
        return habilidades;
    }

    /**
     * Metodo que calcula el promedio del daño todas las habilidades del personaje
     * Se suman el daño de todas las habilidades y se divide por la cantidad de habilidades total
     */
    public double getPromedioDamageHabilidades(){
        double sumatoria = 0;
        Habilidad auxHabilidad;
        for (int i=0;i<habilidades.size();i++){
            auxHabilidad = habilidades.get(i);
            sumatoria += auxHabilidad.getDamage();
        }
        return sumatoria/(double)habilidades.size();
    }

    /**
     * Metodo que calcula el promedio de la curación de todas las habilidades del personaje
     * * Se suman la curación de todas las habilidades y se divide por la cantidad de habilidades total
     */
    public double getPromedioCuracionHabilidades(){
        double sumatoria = 0;
        Habilidad auxHabilidad;
        for (int i=0;i<habilidades.size();i++){
            auxHabilidad = habilidades.get(i);
            sumatoria += auxHabilidad.getCuracion();
        }
        return sumatoria/(double)habilidades.size();
    }

    /**
     * Metodo que modifica la cantidad de vida del Personaje
     *
     * @param numero Cantidad de vida que se quiere modificar
     */
    public void modificarVida(int numero){
        vida = vida + numero;
    }

    @Override
    public String toString(){
        return "Nombre: "+this.getNombre()+
                ", Vida: "+this.getVida()+
                ", Resistencia: "+this.getResistencia()+
                ", Regeneracion: "+this.getRegeneracion();
    }
}

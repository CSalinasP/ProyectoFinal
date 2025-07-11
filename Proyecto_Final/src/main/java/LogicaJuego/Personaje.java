package LogicaJuego;
import LogicaTorneo.Inscribible;
import LogicaTorneo.Torneo;
import java.util.ArrayList;

/**
 * Clase que representa a los personajes y sus características.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */
public class Personaje implements Inscribible{
    /** El nombre del Personaje asociado a tu tipo de personaje. */
    private String nombre;
    /** La vida total o máxima del personaje. */
    private int vidaTotal;
    /** La vida actual del personaje. */
    private int vida;
    /** La resistencia al daño del personaje. */
    private int resistencia;
    /** La regeneración de vida del personaje. */
    private int regeneracion;
    /** La lista de habilidades del personaje. */
    private ArrayList<Habilidad> habilidades;
    // private RecursosGraficos sprites; //


    /**
     * Constructor que declara al personaje con sus características.
     * @param Nombre El nombre del personaje asociado a qué tipo de personaje es.
     * @param Vida La vida del personaje.
     * @param Resistencia La resistencia del personaje.
     * @param Regeneracion La regeneración del personaje.
     * @param Habilidades La lista de habilidades del personaje.
    */
    public Personaje(String Nombre, int Vida, int Resistencia, int Regeneracion, ArrayList<Habilidad> Habilidades){
        nombre = Nombre;
        vida = Vida;
        resistencia = Resistencia;
        regeneracion = Regeneracion;
        habilidades = Habilidades;
    }

    /**
     * Metodo que sube de nivel los atributos del personaje y sus habilidades.
     */
    public void subirNivel(){
        vida += 10;
        resistencia += 5;
        regeneracion += 5;
        for (int i=0;i<3;i++){
            habilidades.get(i).subirNivel();
        }
    }

    /**
     * Metodo que cura al personaje.
     * Si después de curar, la vida actual sobrepasa la vida máxima del personaje:
     * se iguala la vida actual con la vida máxima.
     * @param numero La cantidad que se va a curar.
     */
    public void curarVida(int numero){
        vida = vida + numero;
        if (vida > vidaTotal){
            vida = vidaTotal;
        }
    }

    /**
     * Metodo que le quita vida al personaje.
     * El daño se reducirá dependiendo de la resistencia al daño del personaje.
     * Si después de recibir daño, la vida actual es menor a 0: se iguala a 0.
     * @param numero La cantidad de daño que va a recibir el personaje.
     */
    public void quitarVida(int numero){
        vida = vida - ((1-resistencia)*numero);
        if (vida<0){
            vida = 0;
        }
    }

    /**
     * Metodo que cura al personaje en cada turno.
     * Depende de la cantidad de regeneración que tiene el Personaje.
     * Si después de curar, la vida actual sobrepasa la vida máxima del Personaje:
     * se iguala la vida actual con la vida máxima.
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
     * Metodo que inscribe al personaje en el torneo.
     * @param torneo El torneo al cual se le quiere inscribir.
     */
    @Override
    public void inscribir(Torneo torneo) {
        torneo.getCompetidores().add(this);
    }

    /**
     * Metodo getter que retorna el nombre del personaje.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Metodo getter que retorna la vida del personaje.
     */
    public int getVida(){
        return vida;
    }

    /**
     * Metodo getter que retorna la resistencia del personaje.
     */
    public int getResistencia(){
        return resistencia;
    }

    /**
     * Metodo getter que retorna la regeneración del personaje.
     */
    public int getRegeneracion(){
        return regeneracion;
    }

    /**
     * Metodo getter que retorna la lista de habilidades del personaje.
     */
    public ArrayList<Habilidad> getHabilidades(){
        return habilidades;
    }

    /**
     * Metodo que calcula el promedio del daño todas las habilidades del personaje.
     * Se suman el daño de todas las habilidades y se divide por la cantidad de habilidades total.
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
     * Metodo que calcula el promedio de la curación de todas las habilidades del personaje.
     * * Se suman la curación de todas las habilidades y se divide por la cantidad de habilidades total.
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

    @Override
    public String toString(){
        return "Nombre: "+this.getNombre()+
                ", Vida: "+this.getVida()+
                ", Resistencia: "+this.getResistencia()+
                ", Regeneracion: "+this.getRegeneracion();
    }
}

package LogicaJuego;
import GUIJuego.VentanaJuego;

import java.util.ArrayList;

/**
 * Clase que representa a los personajes y sus características.
 * @author CSalinasP
 * @version 1.2
 * @since 2025-07-10
 */
public class Personaje {
    /** El nombre del Personaje asociado a tu tipo de personaje. */
    private String nombre;

    private int posision;

    private int nivel;
    /** La cantidad de vida actual del personaje. */
    private int vida;
    /** La resistencia al daño del personaje. */
    private int resistencia;
    /** La regeneración de vida del personaje. */
    private int regeneracion;
    /** La lista de habilidades del personaje. */
    private ArrayList<Habilidad> habilidades;
    /** La cantidad de victorias del personaje. */
    private int victorias;
    /** La cantidad de derrotas del personaje. */
    private int derrotas;
    /** La cantidad de puntaje del personaje. */
    private int puntaje;
    /** La direccion del sprite del personaje en la carpeta resources. */
    private String spritePath;


    /**
     * Constructor que declara al personaje con sus características.
     * @param Nombre El nombre del personaje asociado a qué tipo de personaje es.
     * @param nivel El nivel del personaje.
     * @param Vida La vida del personaje.
     * @param Resistencia La resistencia del personaje.
     * @param Regeneracion La regeneración del personaje.
     * @param Habilidades La lista de habilidades del personaje.
    */
    public Personaje(String Nombre, int nivel, int Vida, int Resistencia, int Regeneracion, String spritePath, ArrayList<Habilidad> Habilidades){
        nombre = Nombre;
        this.nivel = nivel;
        vida = Vida;
        resistencia = Resistencia;
        regeneracion = Regeneracion;
        this.spritePath = spritePath;
        habilidades = Habilidades;
        puntaje = 0;
        victorias = 0;
        derrotas = 0;
        posision = 0;
    }

    /**
     * Metodo que sube de nivel los atributos del personaje y sus habilidades.
     */
    public void subirNivel(){
        nivel +=1;
        vida += 10;
        resistencia += 5;
        regeneracion += 5;
        for (int i=0;i<3;i++){
            habilidades.get(i).subirNivel();
        }
    }

    public void setSprites(){
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

    public String getSpritePath(){
        return spritePath;
    }
    /**
     * Metodo getter que retorna la lista de habilidades del personaje.
     */
    public ArrayList<Habilidad> getHabilidades(){
        return habilidades;
    }

    public int getPosision() {
        return posision;
    }

    /**
     * Metodo que calcula el promedio del daño todas las habilidades del personaje.
     * Se suman el daño de todas las habilidades y se divide por la cantidad de habilidades total.
     */

    public double ratioVictoriaDerrota(){
        if(derrotas!=0){
            return victorias/derrotas;}
        else{
            return victorias;
        }
    }

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
     * Se suman la curación de todas las habilidades y se divide por la cantidad de habilidades total.
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
     * Metodo que aumenta el puntaje del personaje en 1.
     */
    public void aumentarPuntaje(){
        puntaje+=1;
    }
    /**
     * Metodo que disminuye el puntaje del personaje en 1.
     */
    public void disminuirPuntaje(){
        puntaje-=1;
    }

    /**
     * Metodo getter que retorna la cantidad ded victorias de personaje.
     */
    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPosision(int posision) {
        this.posision = posision;
    }


    @Override
    public String toString(){
        return "Nombre: "+this.getNombre()+
                ", Vida: "+this.getVida()+
                ", Resistencia: "+this.getResistencia()+
                ", Regeneracion: "+this.getRegeneracion();
    }

    public int getPuntaje() {
        return puntaje;
    }
}

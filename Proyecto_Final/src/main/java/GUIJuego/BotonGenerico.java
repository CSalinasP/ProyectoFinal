package GUIJuego;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BotonGenerico extends JButton{
    private Comando comando;
    private String nombre;
    private Image imagen;

    public BotonGenerico(Comando comando, String nombre){
        this.comando = comando;
        this.nombre = nombre;
        imagen = null;
        super(nombre);
    }

    public BotonGenerico(Comando comando, String nombre, int ancho, int alto) {
        super(nombre);
        this.comando = comando;
        this.nombre = nombre;
        this.setPreferredSize(new Dimension(ancho, alto));
    }

    public BotonGenerico(Comando comando, String nombre, String imagePath, int ancho, int alto) {
        super(nombre);
        this.comando = comando;
        this.nombre = nombre;
        setupImage(imagePath, ancho, alto); // Método para cargar y escalar la imagen
    }

    /**
     * Método privado para cargar y opcionalmente escalar la imagen, y luego establecerla como icono del botón.
     * @param imagePath La ruta de la imagen dentro de la carpeta 'resources'.
     * @param ancho es el Ancho deseado para la imagen (0 para no escalar).
     * @param alto es el Alto deseado para la imagen (0 para no escalar).
     */
    private void setupImage(String imagePath, int ancho, int alto) {
        this.setIcon(RecursosGraficos.cargarImagen(imagePath, ancho, alto));
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Comando getComando(){
        return comando;
    }

    public void setComando(Comando comando){this.comando = comando;}

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

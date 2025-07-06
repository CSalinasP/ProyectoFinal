package GUIJuego;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BotonGenerico extends JButton{
    private Comando comando;
    private String nombre;
    private ImageIcon imagen;

    public BotonGenerico(Comando comando, String nombre){
        super(nombre);  // Mover super(nombre) al principio
        this.comando = comando;
        this.nombre = nombre;
        imagen = null;
    }

    public BotonGenerico(Comando comando, String nombre, int scaledWidth, int scaledHeight) {
        super(nombre);
        this.comando = comando;
        this.nombre = nombre;
        this.setPreferredSize(new Dimension(scaledWidth, scaledHeight));
    }

    public BotonGenerico(Comando comando, String nombre, String imagePath, int scaledWidth, int scaledHeight) {
        super(nombre);
        this.comando = comando;
        this.nombre = nombre;
        setupImage(imagePath, scaledWidth, scaledHeight); // Método para cargar y escalar la imagen
    }

    /**
     * Método privado para cargar y opcionalmente escalar la imagen, y luego establecerla como icono del botón.
     * @param imagePath La ruta de la imagen dentro de la carpeta 'resources'.
     * @param scaledWidth Ancho deseado para la imagen (0 para no escalar).
     * @param scaledHeight Alto deseado para la imagen (0 para no escalar).
     */
    private void setupImage(String imagePath, int scaledWidth, int scaledHeight) {
        URL imageUrl = getClass().getResource(imagePath);
        if (imageUrl != null) {
            ImageIcon originalIcon = new ImageIcon(imageUrl);

            if (scaledWidth > 0 && scaledHeight > 0) {
                Image image = originalIcon.getImage();
                Image scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
                setIcon(new ImageIcon(scaledImage)); // Establece el ícono escalado
            } else {
                setIcon(originalIcon); // Establece el ícono original
            }
        } else {
            System.err.println("Error: No se pudo encontrar la imagen para BotonGenerico en: " + imagePath);
            // Opcional: podrías poner un icono de placeholder aquí
        }
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
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
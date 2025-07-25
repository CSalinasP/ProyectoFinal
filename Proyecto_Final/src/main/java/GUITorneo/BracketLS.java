package GUITorneo;

import GUIJuego.VentanaJuego;
import LogicaTorneo.EliminatoriaSimple;
import LogicaJuego.Personaje;
import LogicaTorneo.LigaSimple;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BracketLS extends BracketTorneo {
     private LigaSimple torneo;
    private ArrayList<Personaje> enfrentamientos;
    private ArrayList<LocalDate> fechasEnfrentamientos;
    private final int ANCHO_COMPETIDOR = 100;
    private final int ALTO_COMPETIDOR = 30;

    public BracketLS(){
        torneo = (LigaSimple) VentanaJuego.getInstancia().getTorneoActual();
        enfrentamientos = torneo.getEnfrentamientos();
        fechasEnfrentamientos = torneo.getFechasEnfrentamientos();
        this.setBackground(Color.WHITE); // Fondo del panel
        this.setPreferredSize(new Dimension(calcularAnchoIdeal(), calcularAltoIdeal()));
    }

    private int calcularAnchoIdeal() {
        return 6 * ANCHO_COMPETIDOR;
    }

    private int calcularAltoIdeal() {
        return 10 * ALTO_COMPETIDOR;
    }

    public void dibujarBracket(Graphics2D g2d, Stroke solidStroke, ArrayList<Personaje> enfrentamientos){
        for (int i = 0; i < 5; i++) {
            if(i==0){
                for(int j=0; j<enfrentamientos.size()/2; j++){
                    dibujarCompetidor(g2d, enfrentamientos.get(j), ANCHO_COMPETIDOR, (1+2*j)*ALTO_COMPETIDOR);
                }
            }
            else if (i==1){
                for(int j=0; j<enfrentamientos.size()-1; j++){
                    if(j%2==0){
                        g2d.drawLine(2*ANCHO_COMPETIDOR,((3+2*j)*ALTO_COMPETIDOR)/2, 3*ANCHO_COMPETIDOR,((3+2*j)*ALTO_COMPETIDOR)/2);
                        dibujarFecha(g2d,fechasEnfrentamientos.get(j/2) ,2*ANCHO_COMPETIDOR,(((1+2*j)*ALTO_COMPETIDOR)/2-5));
                    }
                }
            }
            else if(i==2){
                for(int j=0; j<enfrentamientos.size()/2; j++){
                    dibujarCompetidor(g2d, enfrentamientos.get(j+enfrentamientos.size()/2), 3*ANCHO_COMPETIDOR, (1+2*j)*ALTO_COMPETIDOR);
                }
            }
            else if(i==3){
                for(int j=0; j<enfrentamientos.size(); j++){
                    dibujarCompetidor(g2d, enfrentamientos.get(j), 6*ANCHO_COMPETIDOR, (1+j)*ALTO_COMPETIDOR);
                }
            }
            else {
                for (int j = 0; j < enfrentamientos.size(); j++) {
                    dibujarEstadistica(g2d, enfrentamientos.get(j), 7 * ANCHO_COMPETIDOR, (1 + j) * ALTO_COMPETIDOR);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Define el estilo de línea normal (sólida) para todas las conexiones
        Stroke solidStroke = new BasicStroke(4); // Grosor de 2 píxeles
        dibujarBracket(g2d, solidStroke, torneo.getEnfrentamientos());
    }

    private void dibujarCompetidor(Graphics2D g2d, Personaje personaje, int x, int y) {
        // Se dibuja el rectangulo del competidor
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, ANCHO_COMPETIDOR, ALTO_COMPETIDOR);

        // Se dibuja un borde para el rectangulo del competidor
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, ANCHO_COMPETIDOR, ALTO_COMPETIDOR);

        // Se dibuja el nombre del competidor
        g2d.setColor(Color.BLACK); // Color del texto
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(personaje.getNombre());
        int textX = x + (ANCHO_COMPETIDOR - textWidth) / 2;
        int textY = y + (ALTO_COMPETIDOR - fm.getHeight()) / 2 + fm.getAscent();
        g2d.drawString(personaje.getNombre(), textX, textY);
    }


    private void dibujarFecha(Graphics2D g2d, LocalDate fechaEnfrentamiento, int x, int y){
        // Se dibuja el rectangulo del competidor
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x, y, ANCHO_COMPETIDOR, ALTO_COMPETIDOR);

        // Se dibuja el nombre del competidor
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fecha = fechaEnfrentamiento.format(formatoFecha);
        g2d.setColor(Color.BLACK); // Color del texto
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(fecha);
        int textX = x + (ANCHO_COMPETIDOR - textWidth) / 2;
        int textY = y + (ALTO_COMPETIDOR - fm.getHeight()) / 2 + fm.getAscent();
        g2d.drawString(fecha, textX, textY);
    }

    private void dibujarEstadistica(Graphics2D g2d, Personaje personaje, int x, int y){
        // Se dibuja el rectangulo del competidor
        g2d.setColor(Color.BLUE);
        g2d.fillRect(x, y, 2*ANCHO_COMPETIDOR, ALTO_COMPETIDOR);

        // Se dibuja un borde para el rectangulo del competidor
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, 2*ANCHO_COMPETIDOR, ALTO_COMPETIDOR);

        // Se dibuja el nombre del competidor
        g2d.setColor(Color.BLACK); // Color del texto
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth("                        ");
        int textX1 = x + (ANCHO_COMPETIDOR - textWidth) / 2;
        int textY1 = y + (ALTO_COMPETIDOR - fm.getHeight()) / 2 + fm.getAscent();
        g2d.drawString("Victorias: "+String.valueOf(personaje.getVictorias()) + "     Derotas: " + String.valueOf(personaje.getDerrotas()), textX1, textY1);
    }
}

package GUITorneo;

import GUIJuego.VentanaJuego;
import LogicaTorneo.EliminatoriaSimple;
import LogicaJuego.Personaje;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BracketES extends BracketTorneo {
    private EliminatoriaSimple torneo;
    private ArrayList<Personaje> enfrentamientos;
    private ArrayList<LocalDate> fechasEnfrentamientos;
    private final int ANCHO_COMPETIDOR = 100;
    private final int ALTO_COMPETIDOR = 20;
    private ArrayList<Boolean> barreras;
    private Boolean a, b, c, d;

    public BracketES (){
        torneo = (EliminatoriaSimple) VentanaJuego.getInstancia().getTorneoActual();
        enfrentamientos = torneo.getEnfrentamientos();
        fechasEnfrentamientos = torneo.getFechasEnfrentamientos();
        barreras = new ArrayList<>();
        a = true; barreras.add(a);  b = true; barreras.add(b);
        c = false; barreras.add(c);  d = false; barreras.add(d);
        this.setBackground(Color.WHITE); // Fondo del panel
        this.setPreferredSize(new Dimension(calcularAnchoIdeal(), calcularAltoIdeal()));
    }

    private int calcularAnchoIdeal() {
        return 8*ANCHO_COMPETIDOR;
    }

    private int calcularAltoIdeal() {
        return 34 * ALTO_COMPETIDOR;
    }

    public void dibujarBracket(Graphics2D g2d, Stroke solidStroke, ArrayList<Personaje> enfrentamientos, int x, int y, int ronda){
        for (int i = 0; i < enfrentamientos.size(); i++) {
            double factor_aumento_espacio = Math.pow(2, ronda-1);
            int xCoordenada = x; // Posición X
            int yCoordenada = (int) (y + (2* factor_aumento_espacio *i*(ALTO_COMPETIDOR))); //Posición Y
            dibujarCompetidor(g2d, enfrentamientos.get(i), xCoordenada, yCoordenada);

            g2d.setColor(Color.BLACK); //color de las lineas
            g2d.setStroke(solidStroke); // Todas las líneas usarán el stroke sólido

            // Línea horizontal saliendo del competidor actual
            if(ronda<5) {
                int centroCompetidorInicioX = xCoordenada + ANCHO_COMPETIDOR; // Extremo derecho del competidor inicio
                int centroCompetidorFinX = centroCompetidorInicioX + ANCHO_COMPETIDOR / 2; //
                int centroCompetidorFijoY = yCoordenada + ALTO_COMPETIDOR / 2; //coordenada Y
                g2d.drawLine(centroCompetidorInicioX, centroCompetidorFijoY, centroCompetidorFinX, centroCompetidorFijoY);

                // Línea vertical (uniendo pares) y línea horizontal de ganador
                // Solo dibujar si es el primer competidor de un par (índice par: 0, 2, 4...)
                // y si hay un siguiente competidor para formar el par (i+1)
                if (i % 2 == 0 && (i + 1) < enfrentamientos.size()) {
                    // Calcular la yCoordenada del *siguiente* competidor (i+1)
                    int inicioLineaVertical = centroCompetidorFijoY;
                    int finLineaVertical = (int) ((inicioLineaVertical + 2 * factor_aumento_espacio * (ALTO_COMPETIDOR)));
                    g2d.drawLine(centroCompetidorFinX, inicioLineaVertical, centroCompetidorFinX, finLineaVertical);

                    // Línea horizontal desde el punto medio de la línea vertical hacia la siguiente ronda
                    int centroEntreCompetidoresY = (int) (inicioLineaVertical + (ALTO_COMPETIDOR) * factor_aumento_espacio);
                    int centroEntreCompetidoresFinX = centroCompetidorFinX + ANCHO_COMPETIDOR;
                    g2d.drawLine(centroCompetidorFinX, centroEntreCompetidoresY, centroEntreCompetidoresFinX, centroEntreCompetidoresY);

                    dibujarFecha(g2d, fechasEnfrentamientos.get(i / 2), centroCompetidorFinX + 5, centroEntreCompetidoresY - ALTO_COMPETIDOR);
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
        Stroke solidStroke = new BasicStroke(2); // Grosor de 2 píxeles
        dibujarBracket(g2d, solidStroke, torneo.getEnfrentamientos(), ANCHO_COMPETIDOR/2, ALTO_COMPETIDOR, 1);
        dibujarBracket(g2d, solidStroke, torneo.getEnfrentamientos(), 3 * ANCHO_COMPETIDOR, 2 * ALTO_COMPETIDOR, 2);
        dibujarBracket(g2d, solidStroke, torneo.getEnfrentamientos(), (11* ANCHO_COMPETIDOR)/2, 4 * ALTO_COMPETIDOR, 3);
        dibujarBracket(g2d, solidStroke, torneo.getEnfrentamientos(), 8 * ANCHO_COMPETIDOR, 8 * ALTO_COMPETIDOR, 4);
        dibujarBracket(g2d, solidStroke, torneo.getEnfrentamientos(), (21 * ANCHO_COMPETIDOR)/2, 16 * ALTO_COMPETIDOR, 5);
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

    public ArrayList<Boolean> getBarreras() {
        return barreras;
    }
}
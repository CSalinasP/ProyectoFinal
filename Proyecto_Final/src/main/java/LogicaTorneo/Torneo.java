package LogicaTorneo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import java.util.Random;

/**
 * Clase que representa un torneo deportivo/competitivo.
 * Gestiona toda la lógica y creación de torneos, incluyendo fechas, participantes
 * y desarrollo del mismo.
 *
 * @author Tu Nombre
 * @version 1.0
 * @since 2025-07-02
 * implementar patron singleton a torneo, desimplementar el patron en planilla, modificar ventana,
 * modificar subpaneles
 */
public abstract class Torneo {
    protected ArrayList<Inscribible> competidores;
    protected ArrayList<Inscribible> enfrentamientos;
    protected LocalDate fechaReferencia;
    protected ArrayList<LocalDate> fechasEnfrentamientos;

    public Torneo() {}

    /**Actualiza los pares enfrentados conforme vayan quedando menos*/
    public abstract void actualizarEnfrentamientos();

    public abstract void actualizarFechas();


    /**
     * Simula un combate entre dos instancias de Inscribible y determina cuál es más probable que gane.
     * La probabilidad se calcula en base a sus cualidades de combate y un factor aleatorio.
     *
     * @param inscribible1 La primera instancia de Inscribible.
     * @param inscribible2 La segunda instancia de Inscribible.
     * @return La instancia de Inscribible que tiene mayor probabilidad de ganar el combate.
     * Retorna null si ambos tienen exactamente la misma probabilidad ajustada.
     */
    public Inscribible determinarGanador(Inscribible inscribible1, Inscribible inscribible2) {
        if (inscribible1 == null || inscribible2 == null) {
            throw new IllegalArgumentException("Ambos inscribibles deben ser no nulos.");
        }

        // --- Ponderación de Cualidades ---
        // Asignamos un "peso" a cada cualidad. Puedes ajustar estos valores
        // para reflejar qué tan importantes son en tu lógica de combate.
        final int PESO_VICTORIAS = 2;
        final int PESO_DERROTAS = 3;

        // --- Calcular Puntuación Base para cada Inscribible ---
        // Calculamos una puntuación "base" que representa la fuerza teórica de cada combatiente.
        double puntuacionCombate1 = 0;
        puntuacionCombate1 += inscribible1.getVictorias() * PESO_VICTORIAS;
        puntuacionCombate1 += inscribible1.getDerrotas() * PESO_DERROTAS; // Resta por derrotas

        double puntuacionCombate2 = 0;
        puntuacionCombate2 += inscribible2.getVictorias() * PESO_VICTORIAS;
        puntuacionCombate2 += inscribible2.getDerrotas() * PESO_DERROTAS;

        // --- Introducir Incertidumbre (Aleatoriedad) ---
        // Multiplicamos cada puntuación base por un factor aleatorio cercano a 1.0.
        // Esto crea esa "incertidumbre" que pides.
        // nextGaussian() es útil porque genera números con una distribución normal (campana de Gauss)
        // centrada en 0.0, lo que significa que la mayoría de las veces el factor será cercano a 1.0.
        // Ajustamos la desviación estándar (0.1 en este caso) para controlar cuánto puede variar.
        // Factor = 1.0 + (número_gaussiano * desviación_estándar)
        final double DESVIACION_ALEATORIEDAD = 0.15; // Ajusta este valor para más o menos incertidumbre
        Random random = new Random();
        double puntuacionAjustada1 = puntuacionCombate1 * (1.0 + random.nextGaussian() * DESVIACION_ALEATORIEDAD);
        double puntuacionAjustada2 = puntuacionCombate2 * (1.0 + random.nextGaussian() * DESVIACION_ALEATORIEDAD);

        // Asegurarse de que las puntuaciones no sean negativas después de la aleatoriedad
        puntuacionAjustada1 = Math.max(0, puntuacionAjustada1);
        puntuacionAjustada2 = Math.max(0, puntuacionAjustada2);

        // --- Determinar el Ganador ---
        if (puntuacionAjustada1 > puntuacionAjustada2) {
            return inscribible1;
        }
        else if (puntuacionAjustada1 == puntuacionAjustada2){
            if(random.nextBoolean()){
                return inscribible1;
            }
            else {return inscribible2;
            }
        }
        else {
            return inscribible2;
        }
    }

    public ArrayList<LocalDate> getFechasEnfrentamientos() {
        return fechasEnfrentamientos;
    }

    public ArrayList<Inscribible> getCompetidores(){
        return competidores;
    }

    public ArrayList<Inscribible> getEnfrentamientos() {
        return enfrentamientos;
    }
}
package LogicaJuego;

import LogicaTorneo.Torneo;
import LogicaTorneo.Inscribible;

import java.util.Random;

public class Combate {
    private Personaje avatar;
    private Personaje contendiente;
    private Personaje ganador;

    public Combate(Personaje Avatar, Torneo torneo){
        avatar = Avatar;
    }

    public void usarHabilidadAvatar(Habilidad habilidad){
        int damage = habilidad.usar(avatar);
        contendiente.modificarVida(damage * -1);

        if (contendiente.getVida() <= 0){
            this.Resultado(avatar);
        }
    }

    public void usarHabilidadContendiente(Habilidad habilidad){
        int damage = habilidad.usar(contendiente);
        avatar.modificarVida(damage*-1);

        if (avatar.getVida() <= 0){
            this.Resultado(contendiente);
        }
    }

    private static final Random random = new Random();

    /**
     * Simula un combate entre dos instancias de Inscribible y determina cuál es más probable que gane.
     * La probabilidad se calcula en base a sus cualidades de combate y un factor aleatorio.
     *
     * @param personaje1 La primera instancia de Inscribible.
     * @param personaje2 La segunda instancia de Inscribible.
     * @return La instancia de Inscribible que tiene mayor probabilidad de ganar el combate.
     * Retorna null si ambos tienen exactamente la misma probabilidad ajustada.
     */
    public static Inscribible determinarGanadorProbable(Personaje personaje1, Personaje personaje2) {
        if (personaje1 == null || personaje2 == null) {
            throw new IllegalArgumentException("Ambos inscribibles deben ser no nulos.");
        }

        // --- Ponderación de Cualidades ---
        // Asignamos un "peso" a cada cualidad. Puedes ajustar estos valores
        // para reflejar qué tan importantes son en tu lógica de combate.
        final int PESO_VIDA = 3;
        final int PESO_RESISTENCIA = 2;
        final int PESO_FUERZA_ATAQUE = 3;
        final int PESO_VICTORIAS = 1;     // Un historial de victorias puede dar confianza
        final int PESO_DERROTAS = -1;    // Un historial de derrotas puede restar confianza
        final int PESO_REGENERACION = 2; // La regeneración puede extender la vida útil
        final int PESO_INVULNERABILIDAD = 10; // La invulnerabilidad es una gran ventaja

        // --- Calcular Puntuación Base para cada Inscribible ---
        // Calculamos una puntuación "base" que representa la fuerza teórica de cada combatiente.
        double puntuacionCombate1 = 0;
        puntuacionCombate1 += personaje1.getVida() * PESO_VIDA;
        puntuacionCombate1 += personaje1.getInvulnerabilidad() * PESO_RESISTENCIA;
        puntuacionCombate1 += personaje1.getFuerza() * PESO_FUERZA_ATAQUE;
        puntuacionCombate1 += personaje1.getVictorias() * PESO_VICTORIAS;
        puntuacionCombate1 += personaje1.getDerrotas() * PESO_DERROTAS; // Resta por derrotas
        puntuacionCombate1 += personaje1.getRegeneracion() * PESO_REGENERACION;
        puntuacionCombate1 += PESO_INVULNERABILIDAD;


        double puntuacionCombate2 = 0;
        puntuacionCombate2 += personaje2.getVida() * PESO_VIDA;
        puntuacionCombate2 += personaje2.getInvulnerabilidad() * PESO_RESISTENCIA;
        puntuacionCombate2 += personaje2.getFuerza() * PESO_FUERZA_ATAQUE;
        puntuacionCombate2 += personaje2.getVictorias() * PESO_VICTORIAS;
        puntuacionCombate2 += personaje2.getDerrotas() * PESO_DERROTAS;
        puntuacionCombate2 += personaje2.getRegeneracion() * PESO_REGENERACION;
        puntuacionCombate2 += PESO_INVULNERABILIDAD;

        // --- Introducir Incertidumbre (Aleatoriedad) ---
        // Multiplicamos cada puntuación base por un factor aleatorio cercano a 1.0.
        // Esto crea esa "incertidumbre" que pides.
        // nextGaussian() es útil porque genera números con una distribución normal (campana de Gauss)
        // centrada en 0.0, lo que significa que la mayoría de las veces el factor será cercano a 1.0.
        // Ajustamos la desviación estándar (0.1 en este caso) para controlar cuánto puede variar.
        // Factor = 1.0 + (número_gaussiano * desviación_estándar)
        final double DESVIACION_ALEATORIEDAD = 0.15; // Ajusta este valor para más o menos incertidumbre

        double puntuacionAjustada1 = puntuacionCombate1 * (1.0 + random.nextGaussian() * DESVIACION_ALEATORIEDAD);
        double puntuacionAjustada2 = puntuacionCombate2 * (1.0 + random.nextGaussian() * DESVIACION_ALEATORIEDAD);

        // Asegurarse de que las puntuaciones no sean negativas después de la aleatoriedad
        puntuacionAjustada1 = Math.max(0, puntuacionAjustada1);
        puntuacionAjustada2 = Math.max(0, puntuacionAjustada2);

        // --- Determinar el Ganador ---
        if (puntuacionAjustada1 >= puntuacionAjustada2) {
            return personaje2;
        } else {
            return personaje2;
        }
    }

    public void Resultado(Personaje Ganador){
        ganador = Ganador;
    }

    @Override
    public String toString(){
        return "Avatar: " + avatar.getNombre() + ", Contendiente: " + contendiente.getNombre();
    }

}
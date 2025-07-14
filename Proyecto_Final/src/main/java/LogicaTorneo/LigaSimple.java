package LogicaTorneo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import java.util.Random;

import LogicaJuego.*;

public class LigaSimple extends Torneo{
    private int niveles;
    private ArrayList<Personaje> competidores;
    private ArrayList<ArrayList<Object>> estadisticas;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    public LigaSimple(int niveles){
        this.niveles = niveles;

        competidores = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < niveles+1; i++) {
            int tipoPersonaje = random.nextInt(4);
            switch (tipoPersonaje) {
                case 0:
                    competidores.add(FabricaHumanos.crearPersonaje(1));
                    break;
                case 1:
                    competidores.add(FabricaCaballeros.crearPersonaje(1));
                    break;
                case 2:
                    competidores.add(FabricaCavernarios.crearPersonaje(1));
                    break;
                case 3:
                    competidores.add(FabricaNoMuertos.crearPersonaje(1));
                    break;
            }
        }

        LocalDate fechaReferencia = LocalDate.now();
        LocalDate proximoLunes = fechaReferencia.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        this.fechasEnfrentamientos = new ArrayList<LocalDate>();
        for (int i = 0; i < niveles; i++) {
            fechasEnfrentamientos.add(proximoLunes);
            proximoLunes = proximoLunes.plusWeeks(1);
        }
    }

    public void resultadosEnfrentamientos() {
        Personaje aux = competidores.removeFirst();
        ArrayList<Personaje> perdedores = new ArrayList<>();
        for (int i = 0; i < competidores.size() - 1; i += 2) {
            Personaje comp1 = competidores.get(i);
            Personaje comp2 = competidores.get(i + 1);
            Personaje perdedor = calcularPerdedor(comp1, comp2);
            if(perdedor == comp1){
                comp1.disminuirPuntaje();
                comp2.aumentarPuntaje();
            }
            competidores.getFirst().subirNivel();
        }
        competidores.add(aux);
    }

    public Personaje calcularPerdedor(Personaje p1, Personaje p2){
        double probVida;
        double probResistencia;
        double probRegeneracion;
        double probDamage;
        double probCuracion;
        double probGanador;
        Random rand = new Random();

        probVida = 0.1 * ((double) p1.getVida() /p2.getVida());
        if (probVida>0.2)
        {
            probVida=0.2;
        }
        probResistencia = 0.1 * ((double) p1.getResistencia() /p2.getResistencia());
        if (probResistencia>0.2)
        {
            probResistencia=0.2;
        }
        probRegeneracion = 0.1 * ((double) p1.getRegeneracion() /p2.getRegeneracion());
        if (probRegeneracion>0.2)
        {
            probRegeneracion=0.2;
        }
        probDamage = 0.1 * (p1.getPromedioDamageHabilidades() /p2.getPromedioDamageHabilidades());
        if (probDamage>0.2)
        {
            probDamage=0.2;
        }
        probCuracion = 0.1 * (p1.getPromedioCuracionHabilidades() /p2.getPromedioCuracionHabilidades());
        if (probCuracion>0.2)
        {
            probCuracion=0.2;
        }

        probGanador = probVida + probResistencia + probRegeneracion + probDamage + probCuracion;
        Double auxRandom = rand.nextDouble();
        if (auxRandom <= probGanador){
            return p2;
        }
        else {
            return p1;
        }
    }

    @Override
    public ArrayList<Personaje> getCompetidores() {
        return competidores;
    }

    @Override
    public int getNiveles() {
        return niveles;
    }
}

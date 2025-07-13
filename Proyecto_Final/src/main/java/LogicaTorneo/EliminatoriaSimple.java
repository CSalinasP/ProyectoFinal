package LogicaTorneo;

import LogicaJuego.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Random;

public class EliminatoriaSimple extends Torneo {
    private static  EliminatoriaSimple instancia;
    private Disciplina disciplina;
    private int niveles;
	private ArrayList<Personaje> competidores;
    private LocalDate fechaReferencia;
    private ArrayList<LocalDate> fechasEnfrentamientos;

    private EliminatoriaSimple(int niveles){
        this.niveles = niveles;

        competidores = new ArrayList<>();
        int numeroCompetidores = (int) Math.pow(2, niveles-1);
        Random random = new Random();
        for (int i = 0; i < numeroCompetidores; i++) {
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

    public static EliminatoriaSimple getInstance(int niveles){
        if(instancia==null){
            instancia = new EliminatoriaSimple(niveles);
        }
        return instancia;
    }

    @Override
    public void resultadosEnfrentamientos() {
        competidores.removeFirst();
        for(int i = 0; i<competidores.size(); i--){
            competidores.remove(calcularPerdedor(competidores.get(i), competidores.get(i+1)));
        }
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
        probCuracion = 0.1 * (p1.getPromedioCuracionHabilidades() /p1.getPromedioCuracionHabilidades());
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
}

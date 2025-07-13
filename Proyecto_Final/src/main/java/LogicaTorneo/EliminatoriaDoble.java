package LogicaTorneo;

import LogicaJuego.Personaje;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import LogicaJuego.Personaje;

public class EliminatoriaDoble extends Torneo {
    private static  EliminatoriaDoble instancia;
    private Disciplina disciplina;
    private int niveles;
    private ArrayList<Personaje> competidores;
    private ArrayList<Personaje> competidoresGanadores;
    private ArrayList<Personaje> competidoresPerdedores;
    private ArrayList<LocalDate> fechaReferencia;
    private ArrayList<Date> fechasEnfrentamientos;

    private EliminatoriaDoble(int niveles){
        this.niveles = niveles;
    }

    public static EliminatoriaDoble getInstance(int niveles){
        if(instancia==null){
            instancia = new EliminatoriaDoble(niveles);
        }
        return instancia;
    }

    @Override
    public void resultadosEnfrentamientos() {
        if(competidores.isEmpty()){
            competidores.removeFirst();
            for(int i = 0; i<competidores.size(); i--){
                competidores.remove(calcularPerdedor(competidores.get(i), competidores.get(i+1)));
            }
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
}
import LogicaJuego.Combate;
import LogicaJuego.Personaje;
import LogicaTorneo.Torneo;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;



import LogicaTorneo.Torneo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;



import LogicaTorneo.Torneo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import LogicaJuego.Combate;
import LogicaJuego.Personaje;
import LogicaJuego.Habilidad;
import LogicaTorneo.Torneo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;



public class CombateTest {

    private Personaje avatar;
    private Personaje enemigo;
    private TorneoDummy torneo; // Cambiar a TorneoDummy

    @BeforeEach
    public void setUp() {
        // Crear habilidades avatar
        ArrayList<Habilidad> habilidadesAvatar = new ArrayList<>();
        habilidadesAvatar.add(new Habilidad("Ataque fuerte", 40, 0));
        habilidadesAvatar.add(new Habilidad("Curación básica", 0, 20));

        avatar = new Personaje("Avatar", 100, 50, 30, 50,"avatar.png", habilidadesAvatar);

        // Crear habilidades enemigo
        ArrayList<Habilidad> habilidadesEnemigo = new ArrayList<>();
        habilidadesEnemigo.add(new Habilidad("Golpe débil", 10, 0));
        habilidadesEnemigo.add(new Habilidad("Curación mínima", 0, 5));

        enemigo = new Personaje("Enemigo", 50, 20, 10, 30,"enemigo.png", habilidadesEnemigo);

        // Crear el torneo e insertar al enemigo
        torneo = new TorneoDummy(1);
        ArrayList<Personaje> lista = new ArrayList<>();
        lista.add(avatar);
        lista.add(enemigo);
        torneo.setCompetidores(lista);
        torneo.setEnfrentamientos(lista);
    }

    @Test
    public void testCombateConAvatarFuerte() {
        Combate combate = new Combate(torneo);
        combate.calcularResultado(avatar,enemigo);

        // Imprimir para ver el resultado
        System.out.println("Resultado del combate: " + combate.getGanador());

        // Como el avatar es muy superior, debería ganar la mayoría de veces
        assertNotNull(combate.getGanador(), "El resultado no puede ser nulo");
    }

    @Test
    public void testToStringCombate() {
        Combate combate = new Combate(torneo);
        String resultado = combate.toString();

        assertTrue(resultado.contains("Avatar"), "El toString debe contener información del avatar");
        assertTrue(resultado.contains("Contendiente"), "El toString debe contener información del contendiente");
    }
}
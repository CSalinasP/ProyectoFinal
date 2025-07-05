import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import GUIJuego.*;

public class Test_MenuEntreCombates_PosiciónPaneles {
    private VentanaJuego ventanaJuego;
    private MenuEntreCombates menuEntreCombates;

    @BeforeEach
    void setUp(){
        ventanaJuego = VentanaJuego.getInstancia();
        menuEntreCombates = new MenuEntreCombates();
    }

    @Test
    void test(){
        ventanaJuego.cambiarPanel(menuEntreCombates);
    }

}

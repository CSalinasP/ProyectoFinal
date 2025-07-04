// Nuevo archivo: GUIJuego/ComandoSeleccionarAvatar.java
package GUIJuego;

public class ComandoSeleccionarAvatar implements Comando {
    private MenuEntreCombates menuEntreCombates;
    // Podrías almacenar la información del avatar seleccionado aquí si la necesitas
    // private Personaje avatarSeleccionado;

    public ComandoSeleccionarAvatar(MenuEntreCombates menuEntreCombates /*, Personaje avatar*/) {
        this.menuEntreCombates = menuEntreCombates;
        // this.avatarSeleccionado = avatar;
    }

    @Override
    public void ejecutar() {
        // LogicaTorneo para registrar el avatar seleccionado (si es necesario)
        System.out.println("Avatar seleccionado. Habilitando botón Comenzar Combate.");

        // Habilitar el botón "Comenzar Combate"
        menuEntreCombates.habilitarComenzarCombate(true);

        // Volver al panel de 3 botones
        menuEntreCombates.MostrarOpcionesPrincipales();
    }
}
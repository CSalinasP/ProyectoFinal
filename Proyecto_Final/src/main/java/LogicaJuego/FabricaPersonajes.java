package LogicaJuego;

public class FabricaPersonajes {
    public static Personaje crearPersonaje(TipoPersonaje tipoPersonaje){
        switch (tipoPersonaje) {
            case HUMANO:
                return new Personaje_Humano();
            case CABALLERO:
                return new Personaje_Caballero();
            case CAVERNARIO:
                return new Personaje_Cavernario();
            case NOMUERTO:
                return new Personaje_NoMuerto();
            case GIGANTE:
                return new Personaje_Gigante();
            case HOMBRE_MONSTRUO:
                return new Personaje_Hombre_Montruo();
            case TERRANO:
                return new Personaje_Sindri();
            case HELADO:
                return new Personaje_Helado();
            case ACUATICO:
                return new Personaje_Acuatico();
            case FUEGO:
                return new Personaje_Surtur();
            case AIRE:
                return new Personaje_Eolo();
            case NATURALEZA:
                return new Personaje_Amazona();
            case MOMIA:
                return new Personaje_Momia();
            case FANTASMA:
                return new Personaje_Fantasma();
            case MAGO:
                return new Personaje_Mago();
            case NIGROMANTE:
                return new Personaje_Nigromante();
            default:
                return null;
        }
    }

    @Override
    public String toString(){
        return "Clase encargada de fabricar personajes";
    }
}

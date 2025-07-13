package LogicaTorneo;

public class FabricaTorneos {

    public FabricaTorneos(){
    }

    public static Torneo crearTorneo(TipoTorneo tipoTorneo, int niveles) {
        switch (tipoTorneo) {
            case ELIMINATORIA_SIMPLE:
                return EliminatoriaSimple.getInstance(niveles);
            case ELIMINATORIA_DOBLE:
                return EliminatoriaDoble.getInstance(niveles);
            case LIGA_SIMPLE:
                return LigaSimple.getInstance(niveles);
            default: return null;
        }
    }
}


package LogicaTorneo;

public class FabricaTorneos {

    public FabricaTorneos(){
    }

    public static Torneo crearTorneo(TipoTorneo tipoTorneo) {
        switch (tipoTorneo) {
            case ELIMINATORIA_SIMPLE:
                return EliminatoriaSimple.getInstance();
            case ELIMINATORIA_DOBLE:
                return EliminatoriaDoble.getInstance();
            case LIGA_SIMPLE:
                return LigaSimple.getInstance();
            default: return null;
        }
    }
}


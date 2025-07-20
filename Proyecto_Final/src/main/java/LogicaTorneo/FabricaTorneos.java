package LogicaTorneo;

public class FabricaTorneos {

    public FabricaTorneos(){
    }

    public static Torneo crearTorneo(TipoTorneo tipoTorneo) {
        switch (tipoTorneo) {
            case ELIMINATORIA_SIMPLE:
                return new EliminatoriaSimple();
            case LIGA_SIMPLE:
                return new LigaSimple();
            default: return null;
        }
    }
}


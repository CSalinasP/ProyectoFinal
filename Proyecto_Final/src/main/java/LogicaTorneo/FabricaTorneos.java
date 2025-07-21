package LogicaTorneo;

public class FabricaTorneos {

    public FabricaTorneos(){
    }

    public static Torneo crearTorneo(TipoTorneo tipoTorneo, int niveles) {
        switch (tipoTorneo) {
            case ELIMINATORIA_SIMPLE:
                return new EliminatoriaSimple(niveles);
            case LIGA_SIMPLE:
                return new LigaSimple(niveles);
            default: return null;
        }
    }
}


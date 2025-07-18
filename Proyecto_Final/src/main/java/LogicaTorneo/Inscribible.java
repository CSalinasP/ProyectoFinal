package LogicaTorneo;
/*
Crear
 */
public abstract class Inscribible {
    private String nombre;
    private int victorias;
    private int derrotas;

    public abstract void inscribir(Torneo torneo);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void aumentarVictorias(){
        victorias+=1;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}



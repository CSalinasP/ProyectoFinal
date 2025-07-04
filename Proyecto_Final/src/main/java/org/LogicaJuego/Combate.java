package org.LogicaJuego;

public class Combate {
    private Personaje avatar;
    private Personaje contendiente;
    private Personaje ganador;

    public Combate(Personaje Avatar, Personaje Contendiente){
        avatar = Avatar;
        contendiente = Contendiente;
    }

    public void usarHabilidadAvatar(Habilidad habilidad){
        int damage = habilidad.usar(avatar);
        contendiente.modificarVida(damage * -1);

        if (contendiente.getVida() <= 0){
            this.Resultado(avatar);
        }
    }

    public void usarHabilidadContendiente(Habilidad habilidad){
        int damage = habilidad.usar(contendiente);
        avatar.modificarVida(damage*-1);

        if (avatar.getVida() <= 0){
            this.Resultado(contendiente);
        }
    }

    public void Resultado(Personaje Ganador){
        ganador = Ganador;
    }

    @Override
    public String toString(){
        return "Avatar: " + avatar.getNombre() + ", Contendiente: " + contendiente.getNombre();
    }

}
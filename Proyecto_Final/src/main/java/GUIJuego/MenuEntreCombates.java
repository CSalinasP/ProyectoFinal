package GUIJuego;

import LogicaJuego.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * JPanel que representa el menu que aparece entre los combates.
 * Permite gestionar avatares, comenzar el siguiente combate,
 * volver al menú inicial o ver el estado del juego.
 * @author Francisco Arentsen
 */
public class MenuEntreCombates extends JPanel {
    private TipoPersonaje personajeSeleccionado;
    private JPanel panelCentral;
    private ArrayList<BotonGenerico> botonesAvatares;
    private BotonGenerico avatares, comenzarCombate, volverMenuInicial, status;
    private JPanel fondoSur, fondoNorte, fondoEste, fondoOeste;
    private JPanel avatar, oponente;
    private JLabel imgAvatar, imgOponente;

     /**Constructor de la clase que configura sus dimensiones, color y la disposición
     * de los subpaneles ademas de inicializarlos y agregarlos. Tambien incializa los botones para
     * ver las opciones de avateres, comenzar el combate, volver al menu inical o ver el setatus,
     * les aagrega los ActionListeners corresondientes
     * y los añade a sus respectivos subpaneles.
     * */
    public MenuEntreCombates(){
        personajeSeleccionado=null;
        this.setLayout(new BorderLayout());
        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3,10,0,0));

        fondoSur = new JPanel();
        fondoSur.setPreferredSize(new Dimension(0,200));
        fondoSur.setBackground(Color.GREEN);
        fondoNorte = new JPanel();
        fondoNorte.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fondoNorte.setPreferredSize(new Dimension(0,200));
        fondoNorte.setBackground(Color.green);
        fondoEste = new JPanel();
        fondoEste.setPreferredSize(new Dimension(400,0));
        fondoEste.setBackground(Color.GREEN);
        fondoOeste = new JPanel();
        fondoOeste.setPreferredSize(new Dimension(400,0));
        fondoOeste.setBackground(Color.GREEN);
        this.add(fondoSur, BorderLayout.SOUTH);

        avatar = new JPanel();
        avatar.add(new JLabel("Avatar Actual"));
        ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/16bit.png", 100, 150));
        imgAvatar = new JLabel(iconAvatar);
        avatar.add(imgAvatar);
        fondoOeste.add(avatar);
        this.add(fondoOeste, BorderLayout.WEST);

        oponente = new JPanel();
        oponente.add(new JLabel("Oponente Actual"));
        ImageIcon iconOponente = RecursosGraficos.cargarImagen("/16bit.png", 100, 150);
        imgOponente = new JLabel(iconOponente);
        oponente.add(imgOponente);
        fondoEste.add(oponente);
        this.add(fondoEste, BorderLayout.EAST);


        status = new BotonGenerico(new ComandoMostrarStatus(), "Bracket");
        status.addActionListener(e -> status.getComando().ejecutar());
        fondoNorte.add(status);
        this.add(fondoNorte, BorderLayout.NORTH);

        avatares = new BotonGenerico(new ComandoMostrarOpciones(this), "Avatares");
        avatares.addActionListener(e -> avatares.getComando().ejecutar());

        comenzarCombate = new BotonGenerico(new ComandoComenzarCombate(this), "Comenzar Combate");
        comenzarCombate.addActionListener(e -> comenzarCombate.getComando().ejecutar());

        volverMenuInicial = new BotonGenerico(new ComandoVolverMenuInicial(), "Volver al Menu Inicial");
        volverMenuInicial.addActionListener(e -> volverMenuInicial.getComando().ejecutar());

        botonesAvatares = new ArrayList<>();

        for(int i=0; i<PlanillaPersonajes.getInstance().getPersonajes().size(); i++){
            BotonGenerico btnAvatar = new BotonGenerico(null, PlanillaPersonajes.getInstance().getPersonajes().get(i).getNombre(), "/16bit.png", 64, 64);
            btnAvatar.setComando(new ComandoOcultarOpciones(this, btnAvatar));
            btnAvatar.addActionListener(e-> btnAvatar.getComando().ejecutar());
            botonesAvatares.add(btnAvatar);
        }

        panelCentral.add(avatares); panelCentral.add(comenzarCombate); panelCentral.add(volverMenuInicial);
        this.add(panelCentral, BorderLayout.CENTER);
    }

    /**Este metodo remueve los Jpaneles contenidos en el panel central, configura la disposision de
     * sus elementos y
     * */
    public void MostrarOpciones(){
        panelCentral.removeAll();
        panelCentral.setLayout(new GridLayout(2,2,10,10));
        panelCentral.setLayout(new FlowLayout(FlowLayout.LEFT));
        for(JButton avatar : botonesAvatares){
            panelCentral.add(avatar);
        }
        this.repaint();
        this.revalidate();
    }

    public void OcultarOpciones(String tipo){
        if(tipo.equals("Humano")){
            personajeSeleccionado=TipoPersonaje.HUMANO;
            avatar.remove(imgAvatar);
            ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/16bit.png", 100, 150));
            imgAvatar = new JLabel(iconAvatar);
        }
        else if(tipo.equals("Cavallero")){
            personajeSeleccionado=TipoPersonaje.CABALLERO;
            avatar.remove(imgAvatar);
            ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/16bit.png", 100, 150));
            imgAvatar = new JLabel(iconAvatar);
        }
        else if(tipo.equals("Cavernario")){
            personajeSeleccionado=TipoPersonaje.CAVERNARIO;
            avatar.remove(imgAvatar);
            ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/16bit.png", 100, 150));
            imgAvatar = new JLabel(iconAvatar);
        }
        else{personajeSeleccionado=TipoPersonaje.NOMUERTO;
            avatar.remove(imgAvatar);
            ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/16bit.png", 100, 150));
            imgAvatar = new JLabel(iconAvatar);
        }
        panelCentral.removeAll();
        panelCentral.setLayout(new GridLayout(3,1,0,0));
        panelCentral.add(avatares);
        panelCentral.add(comenzarCombate);
        panelCentral.add(volverMenuInicial);
        this.repaint();
        this.revalidate();
    }
    public TipoPersonaje getPersonajeSeleccionado() {
        return personajeSeleccionado;
    }
}
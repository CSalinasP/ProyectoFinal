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
    private int nivelActual;
    private Personaje personajeSeleccionado;
    private JPanel panelCentral;
    private ArrayList<BotonGenerico> botonesAvatares;
    private BotonGenerico avatares, comenzarCombate, volverMenuInicial, status;
    private BotonGenerico a, b, c, d;
    private JPanel fondoSur, fondoNorte, fondoEste, fondoOeste;
    private JPanel avatar, oponente;
    private JLabel imgAvatar, imgOponente;

     /**Constructor de la clase que configura sus dimensiones, color y la disposición
     * de los subpaneles ademas de inicializarlos y agregarlos. Tambien incializa los botones para
     * ver las opciones de avateres, comenzar el combate, volver al menu inical o ver el status,
     * les agrega los ActionListeners corresondientes
     * y los añade a sus respectivos subpaneles.
     * */
    public MenuEntreCombates(){
        personajeSeleccionado = FabricaHumanos.crearPersonaje(VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados()+1);
        nivelActual = VentanaJuego.getInstancia().getTorneoActual().getNivelesCompletados()+1;
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
        ImageIcon iconAvatar = RecursosGraficos.cargarImagen(VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().get(0).getSpritePath(), 100, 150);
        imgAvatar = new JLabel(iconAvatar);
        avatar.add(imgAvatar);
        fondoOeste.add(avatar);
        this.add(fondoOeste, BorderLayout.WEST);

        oponente = new JPanel();
        oponente.add(new JLabel("Oponente Actual"));
        ImageIcon iconOponente = RecursosGraficos.cargarImagen(VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().get(1).getSpritePath(), 100, 150);
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
        a = new BotonGenerico(null, PlanillaPersonajes.getInstance().getPersonajes().get(0).getNombre(), "/humano.jpg", 64, 64);
        a.setComando(new ComandoOcultarOpciones(this, a));
        a.addActionListener(e-> a.getComando().ejecutar());
        botonesAvatares.add(a);
        b = new BotonGenerico(null, PlanillaPersonajes.getInstance().getPersonajes().get(1).getNombre(), "/caballero.jpg", 64, 64);
        b.setComando(new ComandoOcultarOpciones(this, b));
        b.addActionListener(e-> b.getComando().ejecutar());
        botonesAvatares.add(b);
        c = new BotonGenerico(null, PlanillaPersonajes.getInstance().getPersonajes().get(2).getNombre(), "/cavernario.jpg", 64, 64);
        c.setComando(new ComandoOcultarOpciones(this, c));
        c.addActionListener(e-> c.getComando().ejecutar());
        botonesAvatares.add(c);
        d = new BotonGenerico(null, PlanillaPersonajes.getInstance().getPersonajes().get(3).getNombre(), "/nomuerto.jpg", 64, 64);
        d.setComando(new ComandoOcultarOpciones(this, d));
        d.addActionListener(e-> d.getComando().ejecutar());
        botonesAvatares.add(d);


        panelCentral.add(avatares); panelCentral.add(comenzarCombate); panelCentral.add(volverMenuInicial);
        this.add(panelCentral, BorderLayout.CENTER);
    }

    /**Este metodo remueve los Jpaneles contenidos en el panel central, configura la disposision de
     * sus elementos y añade los botones para elegir a los personajes
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

    /**Este metodo retorna el panel central a su disposición original una vez se ha escogido un avatar
     * */
    public void OcultarOpciones(String tipo){
        if(tipo.equals("NoMuerto")){
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().removeFirst();
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().set(0,FabricaHumanos.crearPersonaje(nivelActual));
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().addFirst(FabricaHumanos.crearPersonaje(nivelActual));
            personajeSeleccionado = VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().getFirst();
            VentanaJuego.getInstancia().getTorneoActual().getHistorialEnfrentamientos().get(nivelActual-1).addFirst(personajeSeleccionado);
            avatar.remove(imgAvatar);
            ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/nomuerto.jpg", 100, 150));
            imgAvatar = new JLabel(iconAvatar);
            avatar.add(imgAvatar);
        }
        else if(tipo.equals("Caballero")){
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().removeFirst();
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().set(0,FabricaHumanos.crearPersonaje(nivelActual));
            personajeSeleccionado = VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().getFirst();
            VentanaJuego.getInstancia().getTorneoActual().getHistorialEnfrentamientos().get(nivelActual-1).addFirst(personajeSeleccionado);
            avatar.remove(imgAvatar);
            ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/caballero.jpg", 100, 150));
            imgAvatar = new JLabel(iconAvatar);
            avatar.add(imgAvatar);
        }
        else if(tipo.equals("Cavernarios")){
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().removeFirst();
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().set(0, FabricaHumanos.crearPersonaje(nivelActual));
            personajeSeleccionado = VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().getFirst();
            VentanaJuego.getInstancia().getTorneoActual().getHistorialEnfrentamientos().get(nivelActual-1).addFirst(personajeSeleccionado);
            avatar.remove(imgAvatar);
            ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/cavernario.jpg", 100, 150));
            imgAvatar = new JLabel(iconAvatar);
            avatar.add(imgAvatar);
        }
        else{
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().removeFirst();
            VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().set(0,FabricaHumanos.crearPersonaje(nivelActual));
            personajeSeleccionado = VentanaJuego.getInstancia().getTorneoActual().getEnfrentamientos().getFirst();
            VentanaJuego.getInstancia().getTorneoActual().getHistorialEnfrentamientos().get(nivelActual-1).addFirst(personajeSeleccionado);
            avatar.remove(imgAvatar);
            ImageIcon iconAvatar = (RecursosGraficos.cargarImagen("/humano.jpg", 100, 150));
            imgAvatar = new JLabel(iconAvatar);
            avatar.add(imgAvatar);
        }
        panelCentral.removeAll();
        panelCentral.setLayout(new GridLayout(3,1,0,0));
        panelCentral.add(avatares);
        panelCentral.add(comenzarCombate);
        panelCentral.add(volverMenuInicial);
        this.repaint();
        this.revalidate();
    }

    public Personaje getPersonajeSeleccionado() {
        return personajeSeleccionado;
    }

    public void setPersonajeSeleccionado(Personaje personajeSeleccionado) {
        this.personajeSeleccionado = personajeSeleccionado;
    }

    public JPanel getPanelCentral() {
        return panelCentral;
    }

    public void setPanelCentral(JPanel panelCentral) {
        this.panelCentral = panelCentral;
    }

    public ArrayList<BotonGenerico> getBotonesAvatares() {
        return botonesAvatares;
    }

    public void setBotonesAvatares(ArrayList<BotonGenerico> botonesAvatares) {
        this.botonesAvatares = botonesAvatares;
    }

    public BotonGenerico getAvatares() {
        return avatares;
    }

    public void setAvatares(BotonGenerico avatares) {
        this.avatares = avatares;
    }

    public BotonGenerico getComenzarCombate() {
        return comenzarCombate;
    }

    public void setComenzarCombate(BotonGenerico comenzarCombate) {
        this.comenzarCombate = comenzarCombate;
    }

    public BotonGenerico getVolverMenuInicial() {
        return volverMenuInicial;
    }

    public void setVolverMenuInicial(BotonGenerico volverMenuInicial) {
        this.volverMenuInicial = volverMenuInicial;
    }

    public BotonGenerico getStatus() {
        return status;
    }

    public void setStatus(BotonGenerico status) {
        this.status = status;
    }

    public BotonGenerico getA() {
        return a;
    }

    public void setA(BotonGenerico a) {
        this.a = a;
    }

    public BotonGenerico getB() {
        return b;
    }

    public void setB(BotonGenerico b) {
        this.b = b;
    }

    public BotonGenerico getC() {
        return c;
    }

    public void setC(BotonGenerico c) {
        this.c = c;
    }

    public BotonGenerico getD() {
        return d;
    }

    public void setD(BotonGenerico d) {
        this.d = d;
    }

    public JPanel getFondoSur() {
        return fondoSur;
    }

    public void setFondoSur(JPanel fondoSur) {
        this.fondoSur = fondoSur;
    }

    public JPanel getFondoNorte() {
        return fondoNorte;
    }

    public void setFondoNorte(JPanel fondoNorte) {
        this.fondoNorte = fondoNorte;
    }

    public JPanel getFondoEste() {
        return fondoEste;
    }

    public void setFondoEste(JPanel fondoEste) {
        this.fondoEste = fondoEste;
    }

    public JPanel getFondoOeste() {
        return fondoOeste;
    }

    public void setFondoOeste(JPanel fondoOeste) {
        this.fondoOeste = fondoOeste;
    }

    public JPanel getAvatar() {
        return avatar;
    }

    public void setAvatar(JPanel avatar) {
        this.avatar = avatar;
    }

    public JPanel getOponente() {
        return oponente;
    }

    public void setOponente(JPanel oponente) {
        this.oponente = oponente;
    }

    public JLabel getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(JLabel imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public JLabel getImgOponente() {
        return imgOponente;
    }

    public void setImgOponente(JLabel imgOponente) {
        this.imgOponente = imgOponente;
    }

    @Override
    public String toString() {
        return "MenuEntreCombates{" +
                "personajeSeleccionado=" + (personajeSeleccionado != null ? personajeSeleccionado.toString() + " botones" : "null")+
                ", panelCentral=" + (panelCentral != null ? "initialized" : "null") +
                ", botonesAvatares=" + (botonesAvatares != null ? botonesAvatares.toString() + " botones" : "null") +
                ", avatares=" + (avatares != null ? avatares.toString() : "null") +
                ", comenzarCombate=" + (comenzarCombate != null ? comenzarCombate.toString() : "null") +
                ", volverMenuInicial=" + (volverMenuInicial != null ? volverMenuInicial.toString() : "null") +
                ", status=" + (status != null ? status.toString() : "null") +
                ", fondoSur=" + (fondoSur != null ? "initialized" : "null") +
                ", fondoNorte=" + (fondoNorte != null ? "initialized" : "null") +
                ", fondoEste=" + (fondoEste != null ? "initialized" : "null") +
                ", fondoOeste=" + (fondoOeste != null ? "initialized" : "null") +
                ", avatar=" + (avatar != null ? "initialized" : "null") +
                ", oponente=" + (oponente != null ? "initialized" : "null") +
                ", imgAvatar=" + (imgAvatar != null ? "initialized" : "null") +
                ", imgOponente=" + (imgOponente != null ? "initialized" : "null") +
                '}';
    }
}
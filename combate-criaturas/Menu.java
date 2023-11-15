import greenfoot.*;

public class Menu extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private int contadorSeleccion = 0;
    GreenfootSound sound = new GreenfootSound("MusicaMenu.wav");
    GreenfootSound selected_sfx = new GreenfootSound("click-sfx_2.mp3");
    public int counter = 0;

    public Menu() {
        //Dimensión en pixeles de la imagen de la pantalla
        super(800, 500, 1);
        //Agrega la imagen menuinicio.png
        MyGreenfootImage fondoSeleccion = new MyGreenfootImage(new GreenfootImage("menuinicio.png"));
        //Dimension en pixeles de la imagen de la pantalla
        fondoSeleccion.scale(800,500);
        getBackground().drawImage(fondoSeleccion, 0, 0);
        agregarImagenesSeleccion();
        //Agrega el sonido de fondo MusicaMenu.wav
        this.sound=sound;
        sound.play(); 
        sound.setVolume(70);
        sound.playLoop();
    }

    public void pausarMusica() {

        this.sound.pause();

    }

    private void agregarImagenesSeleccion() {

        //Agrega el Boton Duelo a la pantalla menu
        GreenfootImage botonPlay = new GreenfootImage("BotonLuchar.png");
        botonPlay.scale(231,48);
        addObject(new BotonPlay("BotonDuelo", botonPlay),139,93);

    }
}

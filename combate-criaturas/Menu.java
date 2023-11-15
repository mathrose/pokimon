import greenfoot.*;

public class Menu extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private BotonCriatura[] criaturasSeleccion = new BotonCriatura[4];
    private BotonCriatura[] criaturasSeleccionMenu = new BotonCriatura[4];
    private Criatura[] criaturas = new Criatura[4];
    private int contadorSeleccion = 0;
    GreenfootSound sound = new GreenfootSound("MusicaMenu.wav");
    GreenfootSound batallasound = new GreenfootSound("batalla.wav");
    GreenfootSound finsound = new GreenfootSound("menufin.wav");
    GreenfootSound letsfightsound = new GreenfootSound("lets-fight.wav");
    GreenfootSound selected_sfx = new GreenfootSound("click-sfx_2.mp3");
    public int counter = 0;


    public Menu() {
        super(800, 500, 1);
        MyGreenfootImage fondoSeleccion = new MyGreenfootImage(new GreenfootImage("menuinicio.png"));
        fondoSeleccion.scale(800,500);
        getBackground().drawImage(fondoSeleccion, 0, 0);
        agregarImagenesSeleccion();
        this.sound=sound;
        sound.play(); 
        sound.setVolume(70);
        sound.playLoop();
        counter++;

    }
    
    public void pausarMusica() {
    
        this.sound.pause();
    
    }

    private void agregarImagenesSeleccion() {

 

        //Boton duelo
        GreenfootImage botonPlay = new GreenfootImage("BotonLuchar.png");
        botonPlay.scale(231,48);
        addObject(new BotonPlay("BotonDuelo", botonPlay),139,93);

    }
    // public void finMenu() {
         // if (counter > 1) {
             // sound.pause();
        
    // }

  
// }
}

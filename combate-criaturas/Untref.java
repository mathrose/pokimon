import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Untref here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Untref extends World
{

    /**
     * Constructor for objects of class PopCap.
     * 
     */
    public int counter = 0;
    public GreenfootSound menutheme = new GreenfootSound("PlayStation.wav");
    public Untref()
    {    
        // Crea un nuevo mundo 800x500
        super(800, 500, 1, false); 
        setPaintOrder(EndTransition.class, Transition.class);

    }
    // Duracion y final de la pantalla
    public void act() {
        //Reproduccion de la musica
        if (!menutheme.isPlaying()) {
            menutheme.setVolume(80);

            menutheme.playLoop();

        }
        counter++;
        //Si el contador es mayor a 130 se pausa la musica y agrega la pantalla Menu
        if (counter > 130) {
            menutheme.pause();
            Greenfoot.setWorld(new Menu());
        }
    }
}
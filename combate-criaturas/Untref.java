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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1, false); 
        setPaintOrder(EndTransition.class, Transition.class);
        
    }
    // Duracion y final de la pantalla
    public void act() {
        if (!menutheme.isPlaying()) {
            menutheme.setVolume(80);
          
            menutheme.playLoop();
             
        }
        counter++;
        if (counter > 130) {
             menutheme.pause();
            Greenfoot.setWorld(new Menu());
        }
    }
}
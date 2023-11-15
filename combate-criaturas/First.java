import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class First here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class First extends World
{

    /**
     * Constructor for objects of class First.
     * 
     */
    public First()
    {    
        // Crea un nuevo mundo con 800x500 
        super(800, 500, 1, false); 
        //Agrega la imagen fondoNegro
        setBackground(new GreenfootImage("fondoNegro.png"));
        //Agrega el objeto Transition (para hacer la animación de transición) 
        //Agrega el objeto UNTREF
        addObject(new Transition(true, new Untref(),10),288, 215);
        setPaintOrder(EndTransition.class, Transition.class);
    }
}


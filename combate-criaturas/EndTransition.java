import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndTransition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndTransition extends Actor
{

    public int alpha = 255;
    //Se configura la transparencia con el valor 255
    public EndTransition() {
        getImage().setTransparency(255);
    }

    public void act()
    {
        //Disminuye la transparencia de 10 en 10
        alpha-=10;
        //Si alpha es mayor o igual a 0 disminuye la transparencia
        if (alpha >= 0) { 
            getImage().setTransparency(alpha);
            //Cuando la transparencia es menor a 0 se elimina el objeto
        } else {
            getImage().setTransparency(0);
            getWorld().removeObject(this);
        }

    }
}

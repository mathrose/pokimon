import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition extends Actor
{
    /**
     * Act - do whatever the Transition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public World world;
    public boolean fadeOut = false;
    public boolean startFade = false;
    public int fadeSpeed;
    public int alpha = 0;
    public int counter = 0;
    public int waitDuration = 0;

    public Transition(boolean fadeOut, World world, int speed) {
        this.fadeSpeed = speed;
        this.world = world;
        this.fadeOut = fadeOut;
        // Establece la transparencia inicial de la imagen del actor en 0.
        getImage().setTransparency(0);
    }

    public Transition(boolean fadeOut, World world, int speed, int waitDuration) {
        //Incluye una duración de espera adicional
        this.fadeSpeed = speed;
        this.world = world;
        this.fadeOut = fadeOut;
        this.waitDuration = waitDuration;
        // Establece la transparencia inicial de la imagen del actor en 0.
        getImage().setTransparency(0);
    }

    public Transition(boolean fadeOut, World world, String image, int speed) {
        this.fadeSpeed = speed;
        // Establece la imagen del actor con la imagen proporcionada.
        setImage(new GreenfootImage(image));
        this.world = world;
        this.fadeOut = fadeOut;
        getImage().setTransparency(0);
    }

    public void act()
    {
        // Incrementa el valor de 'alpha' según la velocidad de desvanecimiento.
        alpha+=fadeSpeed;
        if (alpha <= 255) {
            //Si la condicion es verdadera, establece la transparencia
            //de la imagen en el valor actual de alpha
            getImage().setTransparency(alpha);

        } else {
            // Si alpha es mayor que 255, establece la transparencia en 255
            getImage().setTransparency(255);
            //Incrementa el contador de espera
            counter++;
            // Verifica si el contador de espera supera 
            //la duración de espera especificada
            if (counter > waitDuration) {
                //Si no es un desvanecimiento, llama a changeWorld() y devuelve
                if (!fadeOut) {
                    changeWorld();
                    return;
                } else {
                    // Si es un desvanecimiento, agrega un nuevo 
                    //objeto EndTransition al mundo y llama a changeWorld()
                    world.addObject(new EndTransition(), 316, 215);
                    changeWorld();
                    return;
                }
            }
        }
    }
    // Método que cambia el mundo actual al mundo almacenado en 
    //world y elimina el objeto Transition
    public void changeWorld() { 

        getWorld().removeObject(this);
        Greenfoot.setWorld(world);
    }
}

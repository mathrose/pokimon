import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.List;
import java.util.Random;
import greenfoot.*;

public class BotonCriatura extends Actor {
    private String texto;
    private int size;
    private Color color;
    private Color bgColor;
    
    private BotonReactor onClick;

    private int forceWidth;
    private int forceHeight;
    
    private GreenfootImage imagenOriginal;
    
    private boolean visualHover;
    private boolean visualSeleccionado;

    
    public BotonCriatura(String texto, GreenfootImage image) {
        this.texto = texto;
        this.size = size;
        this.color = color;
        this.bgColor = Color.LIGHT_GRAY;
        this.imagenOriginal = image;
        render();
    }

    public void render() {
            MyGreenfootImage nuevaImagen = new MyGreenfootImage(imagenOriginal) {
                public void configurar() {
                    if (visualHover) {
                        scaleToRatio(1.15);
                    }
                    if (visualSeleccionado) {
                        highlight();
                    }
                    shadow();
                }
            };

    setImage(nuevaImagen);
    }
    
    
    public void act() {
        boolean _visualHover = visualHover;
        boolean _visualSeleccionado = visualSeleccionado;

        MouseInfo m = Greenfoot.getMouseInfo();

        // TODO: detecta el mouse-over, no tocar
        if (m != null) {
            List<Actor> actor = getWorld().getObjectsAt(m.getX(), m.getY(), Actor.class);

            if (actor.size() > 0 && actor.get(0) == this) {
                visualHover = true;
            } else {
                visualHover = false;
            }
        }

        if (Greenfoot.mouseClicked(this)) {
            System.out.print(this.texto);
            ((PantallaSeleccion)getWorld()).ubicarEnLista(this);
        }

        if (_visualHover != visualHover || _visualSeleccionado != visualSeleccionado) {
            render();
        }
    }

}

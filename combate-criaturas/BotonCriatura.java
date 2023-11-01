import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.List;
import java.util.Random;
import greenfoot.*;

public class BotonCriatura extends Actor {
    private String nombre;
    private int size;
    private Color color;
    private Color bgColor;

    private BotonReactor onClick;

    private int forceWidth;
    private int forceHeight;

    private GreenfootImage imagenOriginal;

    private boolean visualHover;
    private boolean visualSeleccionado;
    private boolean poseeEquipo = false;
    private boolean esEquipoRojo = false;
    private boolean esEquipoAzul = false;

    public BotonCriatura(String nombre, GreenfootImage image) {
        this.nombre = nombre;
        this.size = size;
        this.color = color;
        this.bgColor = Color.LIGHT_GRAY;
        this.imagenOriginal = image;
        render();
    }

    public BotonCriatura(String nombre, GreenfootImage image, boolean esEquipoAzul) {
        this.nombre = nombre;
        this.size = size;
        this.color = color;
        this.bgColor = Color.LIGHT_GRAY;
        this.imagenOriginal = image;

        this.poseeEquipo = true;
        if (esEquipoAzul == true) {
            this.esEquipoAzul = true;
            this.esEquipoRojo = false;
        } else {
            this.esEquipoAzul = false;
            this.esEquipoRojo = true;
        }
        render();
    }

    public void render() {
        MyGreenfootImage nuevaImagen = new MyGreenfootImage(imagenOriginal) {
                public void configurar() {
                    if (visualHover) {
                        scaleToRatio(1.15);
                        if ((esEquipoRojo == false) && (esEquipoAzul == false)) {
                            highlight(Color.BLACK);
                        }
                    }
                    if (visualSeleccionado) {
                        highlight();
                    }

                    if (esEquipoAzul == true) {
                        highlight(Color.BLUE);
                    }
                    if (esEquipoRojo == true) {
                        highlight(Color.RED);
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
            System.out.print(this.nombre);
            ((PantallaSeleccion)getWorld()).ubicarEnLista(this);
        }

        if (_visualHover != visualHover || _visualSeleccionado != visualSeleccionado) {
            render();
        }
    }

    public String getNombre(){

        return this.nombre;
    }

}

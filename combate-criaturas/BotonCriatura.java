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

    private boolean esClickeable = true;
    private boolean visualHover;
    private boolean visualSeleccionado;
    private boolean poseeEquipo = false;
    private boolean esEquipoRojo = false;
    private boolean esEquipoAzul = false;
    GreenfootSound clicksound = new GreenfootSound("click-sound.mp3");
    /**
     * Toma como parametros el nombre y la imagen del boton criatura
     */
    public BotonCriatura(String nombre, GreenfootImage image) {
        this.nombre = nombre;
        this.size = size;
        this.color = color;
        this.bgColor = Color.LIGHT_GRAY;
        this.imagenOriginal = image;
        render();
    }

    /**
     * Toma como parametros el nombre, la imagen del boton criatura y el booleano de Equipo Azul
     */
    public BotonCriatura(String nombre, GreenfootImage image, boolean esEquipoAzul) {
        this.nombre = nombre;
        this.size = size;
        this.color = color;
        this.bgColor = Color.LIGHT_GRAY;
        this.imagenOriginal = image;
        this.esClickeable = true;
        this.poseeEquipo = true;
        //Si es verdad que es del Equipo Azul es del Equipo Azul, sino es del Rojo
        if (esEquipoAzul == true) {
            this.esEquipoAzul = true;
            this.esEquipoRojo = false;
        } else {
            this.esEquipoAzul = false;
            this.esEquipoRojo = true;
        }
        render();
    }

    
    public BotonCriatura(String nombre, GreenfootImage image, boolean esEquipoAzul, boolean esClickeable) {
        this.nombre = nombre;
        this.size = size;
        this.color = color;
        this.bgColor = Color.LIGHT_GRAY;
        this.imagenOriginal = image;
        this.esClickeable = esClickeable;
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
        boolean esClickeable = this.esClickeable;
        MyGreenfootImage nuevaImagen = new MyGreenfootImage(imagenOriginal) {
                public void configurar() {
                    if(esClickeable){
                        if (visualHover) {
                            //Suena el clicksound al pasar el mouse por encima del objeto
                            clicksound.play();
                            //Se agranda la imagen al pasar el mouse por encima del objeto
                            scaleToRatio(1.15);
                            if ((esEquipoRojo == false) && (esEquipoAzul == false)) {
                                //Agrega un borde CYAN al pasar el mouse por encima del objeto
                                highlight(Color.CYAN);
                            }
                        }
                    }

                    if (visualSeleccionado) {
                        highlight();
                    }
                    
                    if (esEquipoAzul == true) {
                        flipHorizontally();
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
            if(this.esClickeable){
                //Coloca a las criaturas en el equipo correspondiente
                ((PantallaSeleccion)getWorld()).ubicarEnLista(this);
            }
        }

        if (_visualHover != visualHover || _visualSeleccionado != visualSeleccionado) {
            render();
        }
    }
    //Retorna el nombre de la criatura para despues agregarla en la Pantalla Duelo
    public String getNombre(){
        return this.nombre;
    }

}

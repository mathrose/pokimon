import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.List;
import java.util.Random;
import greenfoot.*;

public class MarcoEquipo extends Actor {
    private GreenfootImage imagenOriginal;
    boolean esEquipoAzul;

    public MarcoEquipo(GreenfootImage image, boolean esEquipoAzul) {
        this.imagenOriginal = image;
        this.imagenOriginal.scale(250, 110);
        this.esEquipoAzul = esEquipoAzul;

        setImage(imagenOriginal);

        render();
    }

    public void render() {
        MyGreenfootImage nuevaImagen = new MyGreenfootImage(imagenOriginal) {
                public void configurar() {
                    if(!esEquipoAzul) {
                        flipHorizontally();

                    }

                    shadow();
                }
            };

        setImage(nuevaImagen);
    }


}

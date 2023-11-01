import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class BotonCriatura extends Actor {
    private String texto;
    private int size;
    private Color color;
    private Color bgColor;
    
    private BotonReactor onClick;

    private int forceWidth;
    private int forceHeight;
    
    private GreenfootImage imagenOriginal;

    public BotonCriatura(String texto, GreenfootImage image) {
        this.texto = texto;
        this.size = size;
        this.color = color;
        this.bgColor = Color.LIGHT_GRAY;
        this.imagenOriginal = image;
        render();
    }

    public void render() {
    
    setImage(imagenOriginal);
    }

}

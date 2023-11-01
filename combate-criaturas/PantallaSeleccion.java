import greenfoot.*;

public class PantallaSeleccion extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private Criatura[] criaturas = new Criatura[4];

    private int ronda = 0;
    private int turno = 0;
    //El algoritmo diferencia el turno real, que recorre entre los pokemons y verifica si están o no vivos, y el turno que debe mostrar en el texto.
    private int turnoTextoNumero = 0;

    public PantallaSeleccion() {
        super(800, 500, 1);
        GreenfootImage imagenFondo = new GreenfootImage("select.png");
        getBackground().drawImage(imagenFondo, 0, 0);
        agregarImagenesSeleccion();
        
    }

    private void agregarImagenesSeleccion() {
        
        //Primera fila
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("blastoise_menu.png")), 209, 321);
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("charizard_menu.png")), 306, 321);
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("glaceon_menu.png")), 403, 321);
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("leafeon_menu.png")), 498, 321);
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("delphox_menu.png")), 591, 321);
        
        //Segunda fila
        
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("sylveon_menu.png")), 209, 416);
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("mew_menu.png")), 306, 416);
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("mimikyu_menu.png")), 403, 416);
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("charizard_menu.png")), 498, 416);
        addObject(new BotonBlastoise("Blastoise", new GreenfootImage("charizard_menu.png")), 591, 416);
        
    }

   
}

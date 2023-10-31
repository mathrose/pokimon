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
        
    }

    private void agregarCriaturas() {
        criaturas[0] = new Blastoise("Blastoise");
        criaturas[1] = new Sylveon("Sylveon");
        criaturas[2] = new Mew("Mew", true);
        criaturas[3] = new Mimikyu("Mimikyu", true);

        addObject(criaturas[0], 100, 150);
        addObject(criaturas[1], 300, 150);
        addObject(criaturas[2], 500, 150);
        addObject(criaturas[3], 700, 150);

    }

   
}

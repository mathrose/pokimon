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

        agregarCriaturas();

        turnoTexto = new Texto("Ronda 1 | Turno 1", 20, Color.BLACK, Color.WHITE);
        addObject(turnoTexto, turnoTexto.getImage().getWidth() / 2, turnoTexto.getImage().getHeight() / 2);

        uiAtaques = new UIAtaques(criaturas);
        addObject(uiAtaques, 400, 400);

        GreenfootImage imagenFondo = new GreenfootImage("fondo.png");
        getBackground().drawImage(imagenFondo, 0, 0);

        ronda();
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

    private void ronda() {
        ronda++;
        turno(true);
    }

    public void turno() {
        turno++;
        if (turno >= criaturas.length) {
            ronda();
        }

        if (getObjects(criaturas[turno].getClass()).size() != 0){
            turnoTextoNumero++;
            //System.out.println(turno + " " + getObjects(criaturas[turno].getClass()).getClass());

            for (int i = 0; i < criaturas.length; i++) {
                if (getObjects(criaturas[i].getClass()).size() != 0){
                    criaturas[i].setVisualSeleccionado(false);

                }
            }

            turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turnoTextoNumero);
            uiAtaques.asignarCriaturaActual(criaturas[turno]);

        }
        else {
            //System.out.println("Criatura " + turno + " existe: " + criaturas[turno].getClass());

            turno();

        }

        if (getObjects(Criatura.class).size() == 1) {
            System.out.println("Juego terminado");
        }
    }

    public void turno(boolean nuevaRonda) {
        turno = 0;
        turnoTextoNumero = 0;
        if (getObjects(criaturas[turno].getClass()).size() != 0){
            //System.out.println(getObjects(Criatura.class));
            for (int i = 0; i < criaturas.length; i++) {
                if (getObjects(criaturas[i].getClass()).size() != 0){
                    criaturas[i].setVisualSeleccionado(false);

                }
            }

            turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turnoTextoNumero);
            uiAtaques.asignarCriaturaActual(criaturas[turno]);
        }else{
            //System.out.println("new: Criatura " + turno + " existe: " + criaturas[turno].getClass());
            turno();
        }
        if (getObjects(Criatura.class).size() == 1) {
            System.out.println("Juego terminado");
        }
    }

    private int criaturasVivas() {

        int cantidadDeCriaturasVivas = 0;

        for (int i = 0; i < criaturas.length; i++) {

            if (criaturas[i] != null) {
                cantidadDeCriaturasVivas++;
            }
        }

        return cantidadDeCriaturasVivas;
    }

    public void click(Criatura c) {
        if (c != null)
            uiAtaques.click(c);
    }

    public void hover(Criatura c) {
        uiAtaques.hover(c);
    }
}

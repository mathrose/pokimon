import greenfoot.*;

public class PantallaDuelo extends World {
    private Texto turnoTexto;
    protected UIAtaques uiAtaques;
    private Criatura[] criaturas = new Criatura[4];

    private int ronda = 0;
    private int turno = 0;
    //El algoritmo diferencia el turno real, que recorre entre los pokemons y verifica si están o no vivos, y el turno que debe mostrar en el texto.
    private int turnoTextoNumero = 0;

    public PantallaDuelo(Criatura[] criaturas) {
        super(800, 500, 1);
        this.criaturas = criaturas;
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
        String mensajeAtaque = criaturas[turno].getMensajeAtaque();
        turno++;

        //Verifica si la criatura estaba stuneada, saltea la ronda y la desestunea.

        if (turno >= criaturas.length) {
            uiAtaques.cambiarDescripcion(mensajeAtaque);
            ronda();
        }

        if (criaturas[turno].getStun() == true) {
            criaturas[turno].pasarTurnoStun();
            criaturas[turno].setMensajeStun();
            turno();
            return;
        }

        if (getObjects(criaturas[turno].getClass()).size() != 0){
            turnoTextoNumero++;
            for (int i = 0; i < criaturas.length; i++) {
                if (getObjects(criaturas[i].getClass()).size() != 0){
                    criaturas[i].setVisualSeleccionado(false);
                }
            }
            turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turnoTextoNumero);
            uiAtaques.asignarCriaturaActual(criaturas[turno]);
            uiAtaques.cambiarDescripcion(mensajeAtaque);
        }
        else {
            turno();
        }

        //verifica si todos los pokemons son del mismo equipo y da fin a la pelea.
        if(getObjects(Criatura.class).stream().allMatch(val -> val.esEquipo1() == true)) {
            uiAtaques.cambiarDescripcion("Gana el equipo rojo!");
        }
        if(getObjects(Criatura.class).stream().allMatch(val -> val.esEquipo1() == false)) {
            uiAtaques.cambiarDescripcion("Gana el equipo azul!");
        }
    }

    public void turno(boolean nuevaRonda) {
        turno = 0;
        turnoTextoNumero = 0;
        if (getObjects(criaturas[turno].getClass()).size() != 0){
            for (int i = 0; i < criaturas.length; i++) {
                if (getObjects(criaturas[i].getClass()).size() != 0){
                    criaturas[i].setVisualSeleccionado(false);

                }
            }
            turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turnoTextoNumero);
            uiAtaques.asignarCriaturaActual(criaturas[turno]);
        }else{
            turno();
        }

        /**
         * Como recorrer los objetos activos
         * 
        getObjects(Criatura.class).forEach(criatura -> {
        if (criatura.esEquipo1()){

        }

        });
         **/

        //verifica si todos los pokemons son del mismo equipo y da fin a la pelea.
        if(getObjects(Criatura.class).stream().allMatch(val -> val.esEquipo1() == true)) {
            uiAtaques.cambiarDescripcion("Gana el equipo rojo!");
        }
        if(getObjects(Criatura.class).stream().allMatch(val -> val.esEquipo1() == false)) {
            uiAtaques.cambiarDescripcion("Gana el equipo azul!");
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

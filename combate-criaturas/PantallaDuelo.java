import greenfoot.*;

public class PantallaDuelo extends World {
    private Texto turnoTexto;
    protected UIAtaques uiAtaques;
    private Criatura[] criaturas = new Criatura[4];
    GreenfootSound batallasound = new GreenfootSound("batalla.wav");
    GreenfootSound finale = new GreenfootSound("final.wav");

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
        batallasound.play(); 
        batallasound.setVolume(50);
        batallasound.playLoop();

        addObject(criaturas[0], 100, 150);
        addObject(criaturas[1], 300, 150);
        addObject(criaturas[2], 500, 150);
        addObject(criaturas[3], 700, 150);

    }

    private void ronda() {
        ronda++;
        turno(true);

    }

    public boolean verificarFinDeJuego() {
        if(getObjects(Criatura.class).stream().allMatch(val -> val.esEquipo1() == true)) {
            uiAtaques.cambiarDescripcion("Gana el equipo rojo!");
            batallasound.pause();
            finale.play();
            return true;
        }
        if(getObjects(Criatura.class).stream().allMatch(val -> val.esEquipo1() == false)) {
            uiAtaques.cambiarDescripcion("Gana el equipo azul!");
            batallasound.pause();
            finale.play();
            return true;
        }
        return false;
    }

    public void turno() {
        String mensajeAtaque = criaturas[turno].getMensajeAtaque();
        turno++;

        //verifica si todos los pokemons son del mismo equipo y da fin a la pelea.
        verificarFinDeJuego();

        if (turno >= criaturas.length) {
            uiAtaques.cambiarDescripcion(mensajeAtaque);
            verificarFinDeJuego();
            ronda();
        }

        //Verifica si la criatura estaba stuneada, saltea la ronda y reduce el contador de stun.
        if (criaturas[turno].getStun() == true) {
            criaturas[turno].pasarTurnoStun();
            criaturas[turno].setMensajeStun();
            turno();
            return;
        }

        boolean equipoCriatura = criaturas[turno].esEquipo1();
        if (getObjects(criaturas[turno].getClass()).size() != 0 && (getObjects(criaturas[turno].getClass()).stream().anyMatch(val -> val.esEquipo1() == equipoCriatura)) ){
            turnoTextoNumero++;
            for (int i = 0; i < criaturas.length; i++) {
                if (getObjects(criaturas[i].getClass()).size() != 0){
                    criaturas[i].setVisualSeleccionado(false);
                }
            }
            turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turnoTextoNumero);
            uiAtaques.asignarCriaturaActual(criaturas[turno]);
            uiAtaques.cambiarDescripcion(mensajeAtaque);
            verificarFinDeJuego();
        }
        else {
            turno();
            verificarFinDeJuego();
        }
        verificarFinDeJuego();
    }

    public void turno(boolean nuevaRonda) {
        turno = 0;
        turnoTextoNumero = 0;

        //verifica si todos los pokemons son del mismo equipo y da fin a la pelea.
        verificarFinDeJuego();

        if (criaturas[turno].getStun() == true) {
            criaturas[turno].pasarTurnoStun();
            criaturas[turno].setMensajeStun();
            turno();
            return;
        }

        boolean equipoCriatura = criaturas[turno].esEquipo1();
        if (getObjects(criaturas[turno].getClass()).size() != 0 && (getObjects(criaturas[turno].getClass()).stream().anyMatch(val -> val.esEquipo1() == equipoCriatura) )){

            for (int i = 0; i < criaturas.length; i++) {
                if (getObjects(criaturas[i].getClass()).size() != 0){
                    criaturas[i].setVisualSeleccionado(false);

                }
            }
            turnoTexto.actualizarTexto("Ronda " + ronda + " | Turno " + turnoTextoNumero);
            uiAtaques.asignarCriaturaActual(criaturas[turno]);
            verificarFinDeJuego();
        }else{
            turno();
            verificarFinDeJuego();
            batallasound.pause();
        }

        /**
         * Como recorrer los objetos activos
         * 
        getObjects(Criatura.class).forEach(criatura -> {
        if (criatura.esEquipo1()){

        }

        });
         **/

        verificarFinDeJuego();

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
        if (verificarFinDeJuego() == true)
        {
            Greenfoot.setWorld(new Menu());
            return;
        }
        else if (c != null){
            uiAtaques.click(c);
        }
        verificarFinDeJuego();
    }

    public void hover(Criatura c) {
        uiAtaques.hover(c);
    }
}

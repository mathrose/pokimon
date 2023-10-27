import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class UIAtaques extends Actor {
    Criatura criaturaActual;
    Texto tituloAtaques;
    Boton b1, b2, b3, b4;
    Criatura[] criaturas;
    Boton botonSeleccionado;
    Parrafo descripcion;
    Runnable ataque = null;
    Criatura ataqueObjetivo = null;
    Criatura hoverObjetivo = null;

    public UIAtaques(Criatura[] criaturas) {
        this.criaturas = criaturas;

        b1 = new Boton("", null, 25, Color.BLACK, 344, 30);
        b2 = new Boton("", null, 25, Color.BLACK, 344, 30);
        b3 = new Boton("", null, 25, Color.BLACK, 344, 30);
        b4 = new Boton("", null, 25, Color.BLACK, 344, 30);
        descripcion = new Parrafo("Ataque", 20, Color.BLACK, 330, 192);
        tituloAtaques = new Texto("Ataques", 30, Color.WHITE, null);
    }

    @Override
    protected void addedToWorld(World world) {
        int inicioCuadro = 325;
        int centroDeCuadroAzul = 226;
        getWorld().addObject(tituloAtaques, centroDeCuadroAzul, inicioCuadro);
        getWorld().addObject(b1, centroDeCuadroAzul, 361);
        getWorld().addObject(b2, centroDeCuadroAzul, 401);
        getWorld().addObject(b3, centroDeCuadroAzul, 441);
        getWorld().addObject(b4, centroDeCuadroAzul, 481);
        getWorld().addObject(descripcion, 562, 391);
    }

    public void asignarCriaturaActual(Criatura criaturaActual) {
        this.criaturaActual = criaturaActual;

        tituloAtaques.actualizarTexto(criaturaActual.toString());
        descripcion.setText("");
        botonSeleccionado = null;
        ataque = null;
        resetColorBotones();
        criaturaActual.setVisualSeleccionado(true);

        dibujarFondo();

        Boton[] botones = { b1, b2, b3, b4 };

        for (int i = 0; i < botones.length; i++) {
            new BotonReactor(botones[i], this, criaturaActual, i + 1);
        }
    }

    public void click(Criatura c) {
        ataqueObjetivo = c;
        if (botonSeleccionado == null) {
            descripcion.setText(c.getStats());
        }
        if (ataque != null) {
            ataque.run();
        }
    }
    
    public void cambiarDescripcion(String texto) {
        descripcion.setText(texto);
    }

    public void hover(Criatura c) {
        if (hoverObjetivo == c) {
            return;
        }

        hoverObjetivo = c;
        if (botonSeleccionado == null) {
            // descripcion.actualizarTexto(c.toString());
        }
    }

    void resetColorBotones() {
        b1.actualizar(Color.LIGHT_GRAY);
        b2.actualizar(Color.LIGHT_GRAY);
        b3.actualizar(Color.LIGHT_GRAY);
        b4.actualizar(Color.LIGHT_GRAY);
    }

    private void dibujarFondo() {
        GreenfootImage imagenBarra = new GreenfootImage(700, 200);
        imagenBarra.setColor(Color.BLACK);
        imagenBarra.fill();
        imagenBarra.setColor(criaturaActual.esEquipo1() ? Color.RED : Color.BLUE);
        imagenBarra.fillRect(4, 4, 344, 192);
        imagenBarra.setColor(Color.LIGHT_GRAY);
        imagenBarra.fillRect(352, 4, 344, 192);
        setImage(imagenBarra);
    }

}

import java.util.List;
import java.util.Random;
import greenfoot.*;

public abstract class Criatura extends Actor {
    protected final String nombre;
    protected final int vidaMaxima;

    protected final String[] nombresAtaque;
    protected final String[] detallesAtaque;

    GreenfootSound hit = new GreenfootSound("hit.wav");
    GreenfootSound psyco = new GreenfootSound("psyco.wav");

    GreenfootSound psyco2 = new GreenfootSound("psyco2.wav");
    GreenfootSound multihit = new GreenfootSound("multihit.wav");
    
    GreenfootSound rugido = new GreenfootSound("rugido.wav");
    GreenfootSound llamarada = new GreenfootSound("llamarada.wav");
    GreenfootSound llamarada2 = new GreenfootSound("llamarada2.wav");
    GreenfootSound llamarada3 = new GreenfootSound("llamarada3.wav");
    
    

    protected final boolean equipo1;
    //atributos de la criatura
    protected int vida;
    protected int ataque;
    protected int velocidad;
    protected int defensa;
    protected int defensaBase;
    protected String elemento;
    protected String mensajeAtaque = "";
    protected String nombreAtaqueActual = "";

    protected int stun = 0;

    protected UIInfoCriatura uiInfoCriatura;

    private boolean visualHover;
    private boolean visualSeleccionado;

    private MyGreenfootImage imagenOriginal;
    private MyGreenfootImage imagenStun;

    public Criatura(String nombre, int vida, int ataque,int defensa, int velocidad , String elemento, String[] nombresAtaque, boolean equipo1, String[] detallesAtaque) {
        this.nombre = nombre;

        this.vidaMaxima = vida;

        this.nombresAtaque = nombresAtaque;
        this.detallesAtaque = detallesAtaque;

        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.defensaBase = defensa;
        this.velocidad = velocidad;
        this.elemento = elemento;

        this.equipo1 = equipo1;

        this.imagenOriginal = new MyGreenfootImage(getImage());
        this.imagenOriginal.scale(170, 170);

        try {
            this.imagenStun = new MyGreenfootImage(new GreenfootImage(this.nombre + "Stun.png"));
        } catch(java.lang.IllegalArgumentException err) {
            this.imagenStun = imagenOriginal;
        }

        this.imagenStun.scale(170, 170);

        this.uiInfoCriatura = new UIInfoCriatura(this);
        this.stun = 0;
    }

    @Override
    protected void addedToWorld(World world) {
        render();

        getWorld().addObject(uiInfoCriatura, getX(), getY());
        // Una vez en el mundo, actualizo segun su tamaño
        uiInfoCriatura.setLocation(getX(), getY() + getImage().getHeight() / 2 - /*Sombra*/ 10 + uiInfoCriatura.getImage().getHeight() / 2);
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
                ((PantallaDuelo)getWorld()).hover(this);
            } else {
                visualHover = false;
            }
        }

        if (Greenfoot.mouseClicked(this)) {
            ((PantallaDuelo)getWorld()).click(this);
        }

        if (_visualHover != visualHover || _visualSeleccionado != visualSeleccionado) {
            render();
        }
    }

    public void render() {
        MyGreenfootImage imagenParaRenderizar;

        //Verifica si hay que renderizar la imagen stun o la normal.
        if(this.getStun() == true) {
            imagenParaRenderizar = imagenStun;
        }else{
            imagenParaRenderizar = imagenOriginal;
        }
        MyGreenfootImage nuevaImagen = new MyGreenfootImage(imagenParaRenderizar) {
                public void configurar() {
                    if (!equipo1) {
                        flipHorizontally();
                    }
                    if (visualHover) {
                        scaleToRatio(1.15);
                    }
                    if (visualSeleccionado) {
                        highlight();
                    }
                    shadow();
                }
            };

        setImage(nuevaImagen);
    }

    public void atacar1(Criatura otro) {
        double efectividad = otro.recibirDaño(this, this.ataque);
        actualizarMensajeAtaque(efectividad, 0);
        ((PantallaDuelo)getWorld()).turno();
        this.hit=hit;
        hit.play(); 

    }

    public void atacar2(Criatura otro) {
        {
            otro.recibirDaño(this, this.ataque);
            ((PantallaDuelo)getWorld()).turno();
        }

    }

    public abstract void atacar3(Criatura otro);

    public abstract void atacar4(Criatura otro);

    protected boolean esDelMismoEquipoQue(Criatura otro) {
        return this.equipo1 == otro.equipo1;
    }

    public boolean puedeRealizarAtaque1En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public abstract boolean puedeRealizarAtaque2En(Criatura otro);

    public abstract boolean puedeRealizarAtaque3En(Criatura otro);

    public abstract boolean puedeRealizarAtaque4En(Criatura otro);

    protected double recibirDaño(Criatura atacante, int ataque) {
        double[] calculoAtaque = calcularAtaque(atacante, ataque);

        int daño = (int)calculoAtaque[0];
        double efectividad = calculoAtaque[1];

        this.vida -= daño;

        // START Remueve el objeto del pokemon si se queda sin vida
        if (this.vida<=0){
            this.vida = 0;
            uiInfoCriatura.actualizar();
            getWorld().removeObject(this.uiInfoCriatura);
            getWorld().removeObject(this);
        }
        // END

        //this.imagenOriginal = new MyGreenfootImage(new GreenfootImage("tumba.png"));
        //this.imagenOriginal.scale(130, 130);
        //render();
        uiInfoCriatura.actualizar();
        return efectividad;
    }

    protected void recibirVida(Criatura objetivo, int cantidadVida) {

        this.vida += cantidadVida;
        // START gestiona la vida, si la curacion supera a la vida maxima.
        if (this.vida>=objetivo.getVidaMaxima()){
            this.vida = objetivo.getVidaMaxima();
            uiInfoCriatura.actualizar();
        }
        // END
        uiInfoCriatura.actualizar();
    }

    private double[] calcularAtaque(Criatura atacante, int ataque) {
        Random random = new Random();
        double ataqueContraDefensa = ataque/this.defensa;
        double randomNumber = random.nextInt(4) + 1;
        double efectividad = calcularEfectividad(atacante);
        double daño = 2*(1+ataqueContraDefensa)*randomNumber*efectividad;
        return (new double[] {daño, efectividad});
    }

    protected double calcularEfectividad(Criatura atacante) {
        if (this.elemento == "Fuego" && atacante.getElemento() == "Agua")
            return 1.25;
        if (this.elemento == "Agua" && atacante.getElemento() == "Fuego")
            return 0.75;
        if (this.elemento == "Planta" && atacante.getElemento() == "Fuego")
            return 1.25;
        if (this.elemento == "Fuego" && atacante.getElemento() == "Planta")
            return 0.75;
        if (this.elemento == "Viento" && atacante.getElemento() == "Tierra")
            return 1.75;
        if (this.elemento == "Tierra" && atacante.getElemento() == "Viento")
            return 1.25;

        return 1;
    }

    public int getVida() {
        return this.vida;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public String getElemento() {
        return this.elemento;
    }

    public int getVidaMaxima() {
        return this.vidaMaxima;
    }

    public boolean esEquipo1() {
        return equipo1;
    }

    public void setVisualSeleccionado(boolean visualSeleccionado) {
        this.visualSeleccionado = visualSeleccionado;
        render();
    }

    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String[] getNombresAtaque() {
        return nombresAtaque;
    }

    public String[] getDetallesAtaque() {
        return detallesAtaque;
    }

    public String getStats() {
        return nombre + " (" + this.getClass().getSimpleName() + ")\n" +
        " - Ataque: "+ this.ataque + "\n" +
        " - Defensa: " + this.defensa + "\n" +
        " - Velocidad: "+ this.velocidad + "\n" +
        " - Tipo: " + this.elemento + "\n"  
        ;
    }

    protected void actualizarMensajeAtaque(double efectividad, int numeroAtaque) {
        String mensajeAtaque = this.nombre + " ha usado " + this.nombresAtaque[numeroAtaque] + "\n";
        if (efectividad == 1.25)
            mensajeAtaque = mensajeAtaque + nombresAtaque[numeroAtaque] + " ha sido efectivo!";
        if (efectividad == 0.75)
            mensajeAtaque = mensajeAtaque + nombresAtaque[numeroAtaque] + " no ha sido efectivo.";

        this.mensajeAtaque = mensajeAtaque;
        //System.out.print(this.mensajeAtaque);
    }

    public void setMensajeStun() {
        this.mensajeAtaque = (this.nombre + " está estuneado por: " + getTurnosStun() + " turnos");
    }

    public String getMensajeAtaque() {
        return this.mensajeAtaque;
    }

    protected void cambiarDescripcion(String texto) {
        ((PantallaDuelo)getWorld()).uiAtaques.cambiarDescripcion(texto);
    }

    protected void stunearCriatura(int n) {
        this.stun = n;
    }

    protected void pasarTurnoStun() {
        if (this.stun > 0) {
            this.stun -= 1;

        }else{
            this.stun = 0;
        }

    }

    public boolean getStun() {
        if (stun != 0 ){
            return true;
        }
        else{
            return false;
        }
    }

    public int getTurnosStun() {
        return stun+1;
    }

    public int perderPuntosDeAtaque(int lossAtac){
        this.ataque-=lossAtac;
        return this.ataque;}

    public int perderPuntosDeDefensa(int lossDef){
        this.ataque-=lossDef;
        return this.ataque;}

}

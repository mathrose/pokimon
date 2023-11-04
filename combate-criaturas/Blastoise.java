import greenfoot.*;
import java.util.Random;

public class Blastoise extends Criatura {
    public Blastoise(String nombre, boolean imagenEspejada) {
        super(nombre, 100, 10, 10, 10, "Agua", new String[] { "Placaje", "Hidrobomba", "Subir Defensa", "Autodestrucción" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Lanza bombas de agua que realizan un gran daño a costa de un poco de vida", "Aumenta su defensa durante 3 turnos", "Realiza daño a todos los pokemons presentes a cambio de consumir su propia vida" });
    }

    public Blastoise(String nombre) {
        this(nombre, false);
    }

   

    public void atacar2(Criatura otro) {
        double efectividad = otro.recibirDaño(this, this.ataque*4);
        actualizarMensajeAtaque(efectividad, 1);
        ((PantallaDuelo)getWorld()).turno();

    }


    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return true;
    }

    public void atacar3(Criatura otro) {
        this.defensa += 20;
        actualizarMensajeAtaque(1, 2);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        if (otro == this){
            return true;
        }else{
            cambiarDescripcion("El objetivo no es Blastoise");
            return false;
        }
    }

    //Autodestruccion
    public void atacar4(Criatura otro) {
        ((PantallaDuelo)getWorld()).getObjects(Criatura.class).forEach(criatura -> {
                criatura.recibirDaño(this, this.ataque*4);
        });
        actualizarMensajeAtaque(1.0, 3);
        ((PantallaDuelo)getWorld()).turno();
        this.recibirDaño(this, this.ataque*200);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }

    protected double recibirDaño(Criatura atacante, int ataque) {
        double[] calculoAtaque = calcularAtaque(atacante, ataque);

        int daño = (int)calculoAtaque[0];
        double efectividad = calculoAtaque[1];

        this.vida -= daño;

        //Remueve el objeto del pokemon si se queda sin vida
        if (this.vida<=0){
            this.vida = 0;
            uiInfoCriatura.actualizar();
            getWorld().removeObject(this.uiInfoCriatura);
            getWorld().removeObject(this);
        }

        uiInfoCriatura.actualizar();
        return efectividad;
    }

    private double[] calcularAtaque(Criatura atacante, int ataque) {
        Random random = new Random();
        double ataqueContraDefensa = ataque/this.defensa;
        double randomNumber = random.nextInt(2) + 1;
        double efectividad = calcularEfectividad(atacante);
        double daño = 2*(1+ataqueContraDefensa)*randomNumber*efectividad;
        return (new double[] {daño, efectividad});
    }

}

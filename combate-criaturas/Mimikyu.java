import greenfoot.GreenfootImage;
import greenfoot.*;

public class Mimikyu extends Criatura {
    public Mimikyu(String nombre, boolean imagenEspejada) {
        super(nombre, 90,91,20,10 , "Psiquico", new String[] { "Placaje", "Perplejo", "Ataque Psíquico", "Espanto" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Los rivales se realizan placaje a si mismos", "Realiza un ataque mental que hace mucho daño", "Stunea a un rival por 3 turnos, pero aumenta el ataque del mismo considerablemente." });

    }
    public Mimikyu(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        ((PantallaDuelo)getWorld()).getObjects(Criatura.class).forEach(criatura -> {
                if (!esDelMismoEquipoQue(criatura)){
                    criatura.recibirDaño(criatura, criatura.ataque);
                    cambiarDescripcion(criatura.getNombre() + " ha usado placaje en si mismo.");
                    Greenfoot.delay(200);
                    this.hit=hit;
                    hit.play(); 
                }
            });
            
        actualizarMensajeAtaque(1, 2);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar3(Criatura otro) {
        double efectividad = otro.recibirDaño(this, this.ataque*3, true);
        actualizarMensajeAtaque(efectividad, 1);
        ((PantallaDuelo)getWorld()).turno();
        psyco.play(); 
        psyco.setVolume(90);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar4(Criatura otro) {
        otro.ganarPuntosDeAtaque((int)(otro.getAtaque()*0.70));
        otro.stunearCriatura(3);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
        psyco.play(); 
        psyco.setVolume(90);
        
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }
}

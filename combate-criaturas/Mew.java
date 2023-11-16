import greenfoot.GreenfootImage;

public class Mew extends Criatura {
    public Mew(String nombre, boolean imagenEspejada) {
        super(nombre, 100,98,14,13, "Psiquico", new String[] { "Placaje", "Equilibrio Psiquico", "Hipnosis", "Burbuja" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Roba vida al oponente", "Baja mucho la defensa de un enemigo", "Aumenta mucho su defensa, pero no puede atacar por 2 turnos." });

    }

    public Mew(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        recibirVida(this,30);
        double efectividad = otro.recibirDaño(this, this.ataque*1, true);
        actualizarMensajeAtaque(efectividad, 1);
        psyco2.play(); 
        psyco2.setVolume(90);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar3(Criatura otro) {
        otro.perderPuntosDeDefensa((int)(otro.getDefensa()*0.7));
        actualizarMensajeAtaque(1, 2);
        psyco.play(); 
        psyco.setVolume(90);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar4(Criatura otro) {
        otro.ganarPuntosDeDefensa((int)(otro.getDefensa()*0.7));
        stunearCriatura(2);
        actualizarMensajeAtaque(1, 3);
        psyco.play(); 
        psyco.setVolume(90);
        ((PantallaDuelo)getWorld()).turno();

    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        if (otro == this){
            return true;
        }else{
            cambiarDescripcion("El objetivo no es Mew");
            return false;
        }
    }
}

import greenfoot.GreenfootImage;

public class Glaceon extends Criatura {
    public Glaceon(String nombre, boolean imagenEspejada) {
        super(nombre, 100,96,25,20, "Agua", new String[] { "Placaje", "Mirada Gelida", "Nieve Pesada", "Congelamiento eterno" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Baja su ataque a la mitad, y stunea a todas las criaturas rivales.", "Realiza un ataque de nieve potente, a cambio de dañar a su grupo.", "Se autodestruye, congelando a los oponentes por 3 turnos." });

    }

    public Glaceon(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        ((PantallaDuelo)getWorld()).getObjects(Criatura.class).forEach(criatura -> {
                if (!esDelMismoEquipoQue(criatura)){
                    criatura.stunearCriatura(1);
                }
            });
        this.perderPuntosDeAtaque(this.ataque/2);

        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();

        psyco.play(); 
        psyco.setVolume(90);

    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar3(Criatura otro) {
        double efectividad = otro.recibirDaño(this, ataque*4, true);
        ((PantallaDuelo)getWorld()).getObjects(Criatura.class).forEach(criatura -> {
                if (esDelMismoEquipoQue(criatura)){
                    criatura.recibirDaño(this, ataque*2, true);
                }
            });

        actualizarMensajeAtaque(efectividad, 2);
        ((PantallaDuelo)getWorld()).turno();

        psyco.play(); 
        psyco.setVolume(90);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar4(Criatura otro) {

        ((PantallaDuelo)getWorld()).getObjects(Criatura.class).forEach(criatura -> {
                if (!esDelMismoEquipoQue(criatura)){
                    criatura.stunearCriatura(3);
                }
            });
        actualizarMensajeAtaque(1.0, 3);
        ((PantallaDuelo)getWorld()).turno();
        this.recibirDaño(this, this.ataque*200);

        
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}

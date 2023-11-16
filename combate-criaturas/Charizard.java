import greenfoot.GreenfootImage;

public class Charizard extends Criatura {
    public Charizard(String nombre, boolean imagenEspejada) {
        //vida, ataque, defensa, velocidad
        super(nombre, 90,130,14,90 , "Fuego", new String[] { "Placaje", "Gruñido", "Pantalla de Humo", "Lanzallamas" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Baja 7 puntos al nivel de ataque de una criatura rival", "Causa un daño elevado a una criatura rival, con el costo de quedar paralizado por 2 turnos.", "Este ataque causa un gran daño solo si se tiene mayor cantidad de vida que la criatura rival" });

    }

    public Charizard(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {

        otro.perderPuntosDeAtaque(7);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();

        rugido.play(); 
        rugido.setVolume(50);
        //System.out.print(otro.getAtaque());
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return true;
    }

    public void atacar3(Criatura otro) {
        this.llamarada=llamarada;
        llamarada.play(); 
        llamarada.setVolume(50);

        this.stunearCriatura(2);
        double efectividad = otro.recibirDaño(this, this.ataque*3, true);
        actualizarMensajeAtaque(efectividad, 2);
        ((PantallaDuelo)getWorld()).turno();

    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return true;
    }

    public void atacar4(Criatura otro) {
        llamarada2.play(); 
        llamarada.setVolume(35);
        if (this.vida>otro.vida){

            double efectividad = otro.recibirDaño(this, this.ataque*3, true);
            actualizarMensajeAtaque(efectividad, 3);
            ((PantallaDuelo)getWorld()).turno();

        } else {
            double efectividad = otro.recibirDaño(this, this.ataque, true);
            actualizarMensajeAtaque(efectividad, 3);
            ((PantallaDuelo)getWorld()).turno();}
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }
}

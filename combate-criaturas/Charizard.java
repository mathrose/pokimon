import greenfoot.GreenfootImage;

public class Charizard extends Criatura {
    public Charizard(String nombre, boolean imagenEspejada) {
        super(nombre, 150,40,20,90 , "Fuego", new String[] { "Placaje", "Gruñido", "Pantalla de Humo", "Lanzallamas" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Baja 5 puntos al nivel de ataque de una criatura rival", "Causa un daño elevado a una criatura rival y la paraliza durante 1 turno", "Este ataque causa el triple de daño solo si se tiene mayor cantidad de vida que la criatura rival" });

    }

    public Charizard(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        double efectividad = otro.perderPuntosDeAtaque(6);
        actualizarMensajeAtaque(efectividad, 1);
        ((PantallaDuelo)getWorld()).turno();

    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return true;
    }

    public void atacar3(Criatura otro) {
        otro.stunearCriatura(3);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
        double efectividad = otro.recibirDaño(this, this.ataque*4);
        actualizarMensajeAtaque(efectividad, 1);
        ((PantallaDuelo)getWorld()).turno();

    }
    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return true;
    }

    public void atacar4(Criatura otro) { if (vida<otro.vida){
            double efectividad = otro.recibirDaño(this, this.ataque*3);
        actualizarMensajeAtaque(efectividad, 0);
        ((PantallaDuelo)getWorld()).turno();} else{  double efectividad = otro.recibirDaño(this, this.ataque*3);
        actualizarMensajeAtaque(efectividad, 0);
        ((PantallaDuelo)getWorld()).turno();}
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}

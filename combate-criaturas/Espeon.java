import greenfoot.GreenfootImage;

public class Espeon extends Criatura {
    public Espeon(String nombre, boolean imagenEspejada) {
        super(nombre, 21,90,30,30, "Psiquico", new String[] { "Placaje", "Psicoforme", "Rayo Psiquico", "Brillo Milagroso" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Evita los efectos de ataque, solo recibe el daño verdadero durante 1 turno", "Realiza un ataque de minimo 20 puntos y paraliza a la criatura rival durante 1 turno", "Baja el ataque de todas las criaturas" });
    }

    public Espeon(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {

    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return false;
    }

    public void atacar3(Criatura otro) {
        otro.stunearCriatura(3);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
        int ataqueConMinimo = this.ataque+=20;
        double efectividad = otro.recibirDaño(this, ataqueConMinimo);
        actualizarMensajeAtaque(efectividad, 2);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return true;
    }

    public void atacar4(Criatura otro) {
        ((PantallaDuelo)getWorld()).getObjects(Criatura.class).forEach(criatura -> {
                int porcentajeDeAtaque = criatura.ataque*25/100;
                criatura.perderPuntosDeAtaque(porcentajeDeAtaque);

            });
        actualizarMensajeAtaque(1, 3);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}

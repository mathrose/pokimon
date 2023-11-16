import greenfoot.GreenfootImage;

public class Espeon extends Criatura {
    public Espeon(String nombre, boolean imagenEspejada) {
        super(nombre, 21,90,30,30, "Psiquico", new String[] { "Placaje", "Psicoforme", "Rayo Psiquico", "Brillo Milagroso" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Aumenta el ataque y la defensa de un aliado.", "Realiza un ataque moderado y paraliza a la criatura rival durante 1 turno", "Baja el ataque de todas las criaturas" });
    }

    public Espeon(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        otro.ganarPuntosDeAtaque(20);
        otro.ganarPuntosDeDefensa(20);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();

        psyco.play(); 
        psyco.setVolume(90);
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        if (otro == this){
            cambiarDescripcion("No puedes usar esta habilidad en ti mismo.");
            return false;
        }else if (!esDelMismoEquipoQue(otro)){
            cambiarDescripcion("No puedes usar esta habilidad en un enemigo.");
            return false;
        }else{
            return true;
        }
    }

    public void atacar3(Criatura otro) {
        otro.stunearCriatura(1);
        double efectividad = otro.recibirDaño(this, ataque+30);
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
                int porcentajeDeAtaque = criatura.ataque*25/100;
                criatura.perderPuntosDeAtaque(porcentajeDeAtaque);

            });
        actualizarMensajeAtaque(1, 3);
        ((PantallaDuelo)getWorld()).turno();
        psyco.play(); 
        psyco.setVolume(90);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}

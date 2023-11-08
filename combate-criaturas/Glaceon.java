import greenfoot.GreenfootImage;

public class Glaceon extends Criatura {
    public Glaceon(String nombre, boolean imagenEspejada) {
        super(nombre, 21,50,40,20, "Agua", new String[] { "Placaje", "Mirada Gelida", "Nieve Pesada", "Muro Congelado" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Los jugadores rivales solo pueden atacar con placaje durante 1 turno", "Realiza un ataque potente del 40% de la vida del oponente", "No puede ser paralizado por 1 turno" });
                

    }

    public Glaceon(String nombre) {
        this(nombre, false);
    }
    
    public void atacar2(Criatura otro) {
        atacar1(otro);
    }
    
    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return false;
    }

    public void atacar3(Criatura otro) {
        int porcentajeDeVida = otro.vida*40/100;
        double efectividad = otro.recibirDaño(this, porcentajeDeVida);
        actualizarMensajeAtaque(efectividad, 2);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return true;
    }

    public void atacar4(Criatura otro) {
        atacar1(otro);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return false;
    }
}

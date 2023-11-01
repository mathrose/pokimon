import greenfoot.GreenfootImage;

public class Glaceon extends Criatura {
    public Glaceon(String nombre, boolean imagenEspejada) {
        super(nombre, 21,50,40,20, "Agua", new String[] { "Placaje", "Mirada Gelida", "Nieve Pesada", "Muro Congelado" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Los jugadores rivales solo pueden atacar con placaje durante 1 turno", "Realiza un ataque potente del 40% de la suma total de vida de los contrincantes", "No puede ser paralizado por 1 turno" });
                

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
        atacar1(otro);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return false;
    }

    public void atacar4(Criatura otro) {
        atacar1(otro);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return false;
    }
}

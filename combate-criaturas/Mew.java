import greenfoot.GreenfootImage;

public class Mew extends Criatura {
    public Mew(String nombre, boolean imagenEspejada) {
        super(nombre, 100,98,14,13, "Psiquico", new String[] { "Placaje", "Equilibrio Psiquico", "Re-creación", "Burbuja" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Si tiene menos vida que la criatura rival, roba vida al oponente hasta tener la misma cantidad", "Si muere en el siguiente turno, renace con 25% de su vida total pero con una bonificacion de ataque del 100%", "No puede recibir daño de ningun tipo durante 3 turnos" });
                

    }

    public Mew(String nombre) {
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

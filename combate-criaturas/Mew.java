import greenfoot.GreenfootImage;

public class Mew extends Criatura {
    public Mew(String nombre, boolean imagenEspejada) {
        super(nombre, 100,20,30,100, new String[] { "Placaje", "- Vacío -", "- Vacío -", "- Vacío -" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "-", "-", "-" });
                

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

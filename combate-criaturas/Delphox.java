import greenfoot.GreenfootImage;

public class Delphox extends Criatura {
    public Delphox(String nombre, boolean imagenEspejada) {
        super(nombre, 90,40,20,90 , "Fuego", new String[] { "Placaje", "- Vacío -", "- Vacío -", "- Vacío -" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "-", "-", "-" });
                

    }

    public Delphox(String nombre) {
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

import greenfoot.GreenfootImage;

public class Delphox extends Criatura {
    public Delphox(String nombre, boolean imagenEspejada) {
        super(nombre, 90,40,20,90 , "Fuego", new String[] { "Placaje", "Giro de Fuego", "Desfile de Antorchas", "Fuego Magico" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Disminuye 2 puntos el ataque de la criatura rival durante 1 turno", "Realiza un ataque de 30 puntos por cada criatura muerta", "El daño causante lo recupera en salud" });
                

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

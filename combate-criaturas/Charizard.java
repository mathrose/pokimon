import greenfoot.GreenfootImage;

public class Charizard extends Criatura {
    public Charizard(String nombre, boolean imagenEspejada) {
        super(nombre, 90,40,20,90 , "Fuego", new String[] { "Placaje", "Gruñido", "Pantalla de Humo", "Lanzallamas" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Baja 5 puntos al nivel de ataque de una criatura rival", "Causa un daño elevado a una criatura rival y la paraliza durante 1 turno", "Este ataque causa el triple de daño solo si se tiene mayor cantidad de vida que la criatura rival" });
                

    }


    public Charizard(String nombre) {
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

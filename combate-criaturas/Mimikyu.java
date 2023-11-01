import greenfoot.GreenfootImage;

public class Mimikyu extends Criatura {
    public Mimikyu(String nombre, boolean imagenEspejada) {
        super(nombre, 90,13,10,10 , "Psiquico", new String[] { "Placaje", "Perplejo", "Copión", "Espanto" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Los pokemones del oponente se realizan un placaje mutuamente", "Realiza el mismo daño que el que reciba en el siguiente turno a quien lo ataque", "Reduce la defensa de sus rivales en un 20%" });
                

    }

    public Mimikyu(String nombre) {
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

import greenfoot.GreenfootImage;

public class Espeon extends Criatura {
    public Espeon(String nombre, boolean imagenEspejada) {
        super(nombre, 21,40,30,30, "Psiquico", new String[] { "Placaje", "Psicoforme", "Rayo Psiquico", "Brillo Milagroso" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Evita los efectos de ataque, solo recibe el daño verdadero durante 1 turno", "Realiza un ataque de minimo 20 puntos y paraliza a la criatura rival durante 1 turno", "Baja el ataque de las criaturas rivales un 25%" });
    }

    public Espeon(String nombre) {
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

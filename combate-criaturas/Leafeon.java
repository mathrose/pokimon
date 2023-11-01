import greenfoot.GreenfootImage;

public class Leafeon extends Criatura {
    public Leafeon(String nombre, boolean imagenEspejada) {
        super(nombre, 21,60,50,50, "Planta", new String[] { "Placaje", "Guardian de la Hoja", "Energia del ardin", "Ciclon de Hojas" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Durante 1 turno recibe solo la mitad de daño", "Regenera 20% de su vida actual o a su compañero de equipo", "Causa gran daño a ambos enemigos gastando 20% de su vida" });
                

    }

    public Leafeon(String nombre) {
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

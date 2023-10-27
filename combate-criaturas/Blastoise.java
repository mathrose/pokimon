public class Blastoise extends Criatura {
    public Blastoise(String nombre, boolean imagenEspejada) {
        super(nombre, 100, 20, 50, 20, "Agua", new String[] { "Placaje", "Hidrobomba", "Subir Defensa", "Autodestrucción" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Lanza bombas de agua que realizan un gran daño a costa de un poco de vida", "Aumenta su defensa durante 3 turnos", "Realiza daño a todos los pokemons presentes a cambio de consumir su propia vida" });
        }

    public Blastoise(String nombre) {
        this(nombre, false);
    }
    
    public void atacar2(Criatura otro) {
        atacar1(otro);
        
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return true;
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

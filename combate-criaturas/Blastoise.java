import greenfoot.*;
import java.util.Random;
//wefwsdfffsdff
public class Blastoise extends Criatura {
    public Blastoise(String nombre, boolean imagenEspejada) {
        //vida, ataque, defensa, velocidad
        super(nombre, 100, 120, 10, 10, "Agua", new String[] { "Placaje", "Hidrobomba", "Subir Defensa", "Autodestrucción" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Lanza bombas de agua que realizan un gran daño a costa de un poco de vida", "Aumenta su defensa durante 3 turnos", "Realiza daño a todos los pokemons presentes a cambio de consumir su propia vida" });
    }

    public Blastoise(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        double efectividad = otro.recibirDaño(this, this.ataque*3, true);
        actualizarMensajeAtaque(efectividad, 1);
        ((PantallaDuelo)getWorld()).turno();
        rugido.play(); 
        rugido.setVolume(90);

    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar3(Criatura otro) {
        this.defensa += 20;
        actualizarMensajeAtaque(1, 2);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        if (otro == this){
            return true;
        }else{
            cambiarDescripcion("El objetivo no es Blastoise");
            return false;
        }
    }

    //Autodestruccion
    public void atacar4(Criatura otro) {
        ((PantallaDuelo)getWorld()).getObjects(Criatura.class).forEach(criatura -> {
                if (criatura != this){
                criatura.recibirDaño(this, this.ataque*2);
            }
        });
        actualizarMensajeAtaque(1.0, 3);
        ((PantallaDuelo)getWorld()).turno();
        rugido.play(); 
        rugido.setVolume(90);
        this.recibirDaño(this, this.ataque*200);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }





}

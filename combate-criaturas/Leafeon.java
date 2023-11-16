import greenfoot.GreenfootImage;

public class Leafeon extends Criatura {
    public Leafeon(String nombre, boolean imagenEspejada) {
        super(nombre, 90,102,9,50, "Planta", new String[] { "Placaje", "Guardian de la Hoja", "Energia del jardín", "Corte de Hoja" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Sube mucho su defensa, a cambio de quedar paralizado un turno.", "Regenera una gran cantidad de su vida, a cambio de quedar paralizado por 2 turnos.", "Realiza un golpe de hoja cortante" });

    }

    public Leafeon(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        this.defensa += 20;
        stunearCriatura(1);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
        psyco.play(); 
        psyco.setVolume(90);
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        if (otro == this){
            return true;
        }else if (!esDelMismoEquipoQue(otro)){
            cambiarDescripcion("No puedes usar esta habilidad en un enemigo.");
            return false;
        }else{
            cambiarDescripcion("No puedes usar esta habilidad en un aliado.");
            return false;
        }
    }

    public void atacar3(Criatura otro) {
        int vidaRecuperada = (int)((double)this.getVidaMaxima()*0.70);
        otro.recibirVida(otro, vidaRecuperada);
        stunearCriatura(2);
        System.out.print(vidaRecuperada);
        actualizarMensajeAtaque(1, 2);
        ((PantallaDuelo)getWorld()).turno();
        psyco.play(); 
        psyco.setVolume(90);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        if (otro == this){
            return true;
        }else if (!esDelMismoEquipoQue(otro)){
            cambiarDescripcion("No puedes usar esta habilidad en un enemigo.");
            return false;
        }else{
            cambiarDescripcion("No puedes usar esta habilidad en un aliado.");
            return false;

        }
    }

    public void atacar4(Criatura otro) {
        double efectividad = otro.recibirDaño(this, this.ataque*3, true);
        actualizarMensajeAtaque(efectividad, 3);
        ((PantallaDuelo)getWorld()).turno();
        psyco.play(); 
        psyco.setVolume(90);
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }
}

import greenfoot.GreenfootImage;

public class Delphox extends Criatura {
    public Delphox(String nombre, boolean imagenEspejada) {
        super(nombre, 90,40,20,90 , "Fuego", new String[] { "Placaje", "Giro de Fuego", "Desfile de Antorchas", "Fuego Magico" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Disminuye 2 puntos el ataque de la criatura rival y lo paraliza durante 1 turno", "Realiza un ataque de 30 puntos por cada criatura muerta", "El daño causante lo recupera en salud" });

    }

    public Delphox(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        otro.perderPuntosDeAtaque(2);
        otro.stunearCriatura(1);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
        //System.out.print(otro.getAtaque());
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
        if(this.vida <= 75){
            double efectividad = otro.recibirDaño(this, this.ataque);
            actualizarMensajeAtaque(efectividad, 3);
            ((PantallaDuelo)getWorld()).turno();
            System.out.print(this.vida);
            vida+=15;
            uiInfoCriatura.actualizar();
            System.out.print(this.vida);
        }else{
            double efectividad = otro.recibirDaño(this, this.ataque);
            actualizarMensajeAtaque(efectividad, 3);
            this.vida = 90;
            uiInfoCriatura.actualizar();
            ((PantallaDuelo)getWorld()).turno();
            System.out.print(this.vida);
        }
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}

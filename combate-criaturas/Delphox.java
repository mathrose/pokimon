import greenfoot.GreenfootImage;

public class Delphox extends Criatura {
    public Delphox(String nombre, boolean imagenEspejada) {
        super(nombre, 90,90,20,90 , "Fuego", new String[] { "Placaje", "Giro de Fuego", "Desfile de Antorchas", "Fuego Magico" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Disminuye 12 puntos el ataque de la criatura rival y lo paraliza durante 1 turno", "Este ataque aumenta su daño por cada criatura muerta.", "El daño causante lo recupera en salud" });

    }

    public Delphox(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        otro.perderPuntosDeAtaque(12);
        otro.stunearCriatura(1);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
        llamarada.play(); 
        llamarada.setVolume(90);
    }

    public boolean puedeRealizarAtaque2En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar3(Criatura otro) {
        int cantidadDeCriaturasMuertas = 6 - ((PantallaDuelo)getWorld()).getObjects(Criatura.class).size();
        System.out.print(cantidadDeCriaturasMuertas);
        double efectividad = otro.recibirDaño(this, this.ataque*cantidadDeCriaturasMuertas, true);
        actualizarMensajeAtaque(efectividad, 2);
        ((PantallaDuelo)getWorld()).turno();
        llamarada.play(); 
        llamarada.setVolume(90);
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }

    public void atacar4(Criatura otro) {

        double[] calculoAtaque = calcularAtaque(otro, ataque*2);
        int daño = (int)calculoAtaque[0];
        double efectividad = calculoAtaque[1];

        otro.recibirDañoNeto(daño);
        this.recibirVida(this, daño);
        actualizarMensajeAtaque(efectividad, 3);
        ((PantallaDuelo)getWorld()).turno();
        llamarada.play(); 
        llamarada.setVolume(90);

    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return !esDelMismoEquipoQue(otro);
    }
}

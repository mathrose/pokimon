import greenfoot.GreenfootImage;

public class Leafeon extends Criatura {
    public Leafeon(String nombre, boolean imagenEspejada) {
        super(nombre, 21,60,50,50, "Planta", new String[] { "Placaje", "Guardian de la Hoja", "Energia del ardin", "Sacrificio al Señor Oscuro" }, imagenEspejada,
                new String[] { "Causa un daño moderado a un enemigo", "Durante 1 turno recibe solo la mitad de daño", "Regenera 35% de su vida actual o a su compañero de equipo", "Causa gran daño a ambos enemigos gastando 20% de su vida(creo)" });
                

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
        int vidaRecuperada = (int)((double)this.getVidaMaxima()*0.35);
        otro.recibirVida(otro, vidaRecuperada);
        System.out.print(vidaRecuperada);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque3En(Criatura otro) {
        return false;
    }

    public void atacar4(Criatura otro) {
        ((PantallaDuelo)getWorld()).getObjects(Criatura.class).forEach(criatura -> {
                criatura.recibirDaño(this, this.ataque*2);
        });
        int porcentajeDeVida = otro.vida*20/100;
        this.recibirDaño(this, porcentajeDeVida);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
    }

    public boolean puedeRealizarAtaque4En(Criatura otro) {
        return true;
    }
}

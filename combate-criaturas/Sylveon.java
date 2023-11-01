public class Sylveon extends Criatura {
    public Sylveon(String nombre, boolean imagenEspejada) {
        super(nombre, 100,12,10,10, "Viento", new String[] { "Placaje", "Luz lunar", "Voz Cautivadora", "Sinfonia de Latigazos" }, imagenEspejada,
            new String[] { "Causa un daño moderado a un enemigo", "Regenera vida a si mismo, o a un aliado", "La criatura rival queda aturdida durante 1 turno", "Realiza multiples ataques de placaje" });
    }
    //hola

    public Sylveon(String nombre) {
        this(nombre, false);
    }

    public void atacar2(Criatura otro) {
        int vidaRecuperada = (int)((double)this.getVidaMaxima()*0.20);
        otro.recibirVida(otro, vidaRecuperada);
        System.out.print(vidaRecuperada);
        actualizarMensajeAtaque(1, 1);
        ((PantallaDuelo)getWorld()).turno();
    } 

    public boolean puedeRealizarAtaque2En(Criatura otro) {

        if (otro.esDelMismoEquipoQue(this)){
            if (otro.getVidaMaxima() == otro.getVida()) {
                cambiarDescripcion("El objetivo se encuentra con vida máxima");
                return false;
            }else{

                return true;
            }}
           cambiarDescripcion("El objetivo es de otro equipo");
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

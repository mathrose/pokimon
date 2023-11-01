import greenfoot.*;

public class PantallaSeleccion extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private BotonCriatura[] criaturasSeleccion = new BotonCriatura[4];
    private int contadorSeleccion = 0;

    public PantallaSeleccion() {
        super(800, 500, 1);
        MyGreenfootImage fondoSeleccion = new MyGreenfootImage(new GreenfootImage("select.png"));
        fondoSeleccion.scale(800,500);
        getBackground().drawImage(fondoSeleccion, 0, 0);
        agregarImagenesSeleccion();

    }

    private void agregarImagenesSeleccion() {

        //Primera fila
        addObject(new BotonCriatura("Blastoise", new GreenfootImage("blastoise_menu.png")), 209, 321);
        addObject(new BotonCriatura("Charizard", new GreenfootImage("charizard_menu.png")), 306, 321);
        addObject(new BotonCriatura("Glaceon", new GreenfootImage("glaceon_menu.png")), 403, 321);
        addObject(new BotonCriatura("Leafeon", new GreenfootImage("leafeon_menu.png")), 498, 321);
        addObject(new BotonCriatura("Delphox", new GreenfootImage("delphox_menu.png")), 591, 321);

        //Segunda fila

        addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png")), 209, 416);
        addObject(new BotonCriatura("Mew", new GreenfootImage("mew_menu.png")), 306, 416);
        addObject(new BotonCriatura("Mimikyu", new GreenfootImage("mimikyu_menu.png")), 403, 416);
        addObject(new BotonCriatura("Charizard", new GreenfootImage("charizard_menu.png")), 498, 416);
        addObject(new BotonCriatura("Charizard", new GreenfootImage("charizard_menu.png")), 591, 416);

    }

    public void ubicarEnLista(BotonCriatura criaturaSeleccion) {
        if(contadorSeleccion <= 3){
            this.criaturasSeleccion[contadorSeleccion] = criaturaSeleccion;
            this.contadorSeleccion++;
        }
        else {
            
            //Cambia el mundo
            Greenfoot.setWorld(new PantallaDuelo());
            String nombreCriatura = this.criaturasSeleccion[contadorSeleccion].getNombre();
            
            
            try
            {
                Class test = Class.forName(nombreCriatura);
            }
            catch (ClassNotFoundException cnfe)
            {
                cnfe.printStackTrace();
            }
            
            
        }
    }

    public int getContadorSeleccion() {
        return this.contadorSeleccion;
    }

}

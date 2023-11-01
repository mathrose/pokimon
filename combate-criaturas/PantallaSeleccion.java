import greenfoot.*;

public class PantallaSeleccion extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private BotonCriatura[] criaturasSeleccion = new BotonCriatura[4];
    private Criatura[] criaturas = new Criatura[4];
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
        addObject(new BotonCriatura("Charizard", new GreenfootImage("CharizardMenu.png")), 306, 321);
        addObject(new BotonCriatura("Glaceon", new GreenfootImage("glaceon_menu.png")), 403, 321);
        addObject(new BotonCriatura("Leafeon", new GreenfootImage("leafeon_menu.png")), 498, 321);
        addObject(new BotonCriatura("Delphox", new GreenfootImage("delphox_menu.png")), 591, 321);

        //Segunda fila

        addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png")), 209, 416);
        addObject(new BotonCriatura("Mew", new GreenfootImage("mew_menu.png")), 306, 416);
        addObject(new BotonCriatura("Mimikyu", new GreenfootImage("mimikyu_menu.png")), 403, 416);
        addObject(new BotonCriatura("Espeon", new GreenfootImage("EspeonMenu.png")), 498, 416);
        addObject(new BotonCriatura("Charizard", new GreenfootImage("CharizardMenu.png")), 591, 416);

    }

    public void ubicarEnLista(BotonCriatura criaturaSeleccion) {
        if(contadorSeleccion <= 3){
            this.criaturasSeleccion[contadorSeleccion] = criaturaSeleccion;
            String nombreCriatura = criaturaSeleccion.getNombre();
            System.out.print(nombreCriatura);
            switch (nombreCriatura) { 
                case "Sylveon":
                    criaturas[contadorSeleccion] = new Sylveon("Sylveon");
                    break;
                case "Blastoise":
                    criaturas[contadorSeleccion] = new Blastoise("Blastoise");
                    break;
                case "Charizard" :
                    criaturas[contadorSeleccion] = new Charizard("Charizard");
                    break;
                case "Mimikyu"   :
                    criaturas[contadorSeleccion] = new Mimikyu("Mimikyu");
                    break;
                case "Mew"       :
                    criaturas[contadorSeleccion] = new Mew("Mew");
                    break;
                case "Delphox"   :
                    criaturas[contadorSeleccion] = new Delphox("Delphox");
                    break;
                case "Espeon"    :
                    criaturas[contadorSeleccion] = new Espeon("Espeon");
                    break;
                case "Glaceon"   :
                    criaturas[contadorSeleccion] = new Glaceon("Glaceon");
                    break;
                case "Leafeon"   :
                    criaturas[contadorSeleccion] = new Leafeon("Leafeon");
                    break;
                default:
                    break;
            }
            this.contadorSeleccion++;
        }
        else {

            //Cambia el mundo
            Greenfoot.setWorld(new PantallaDuelo(criaturas));
            

            

        }
    }

    public int getContadorSeleccion() {
        return this.contadorSeleccion;
    }

}

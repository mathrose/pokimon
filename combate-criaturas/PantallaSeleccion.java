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
        addObject(new BotonCriatura("Blastoise", new GreenfootImage("blastoise_menu.png")), 209, 340);
        addObject(new BotonCriatura("Charizard", new GreenfootImage("CharizardMenu.png")), 306, 340);
        addObject(new BotonCriatura("Glaceon", new GreenfootImage("glaceon_menu.png")), 403, 340);
        addObject(new BotonCriatura("Leafeon", new GreenfootImage("leafeon_menu.png")), 498, 340);
        addObject(new BotonCriatura("Delphox", new GreenfootImage("delphox_menu.png")), 591, 340);

        //Segunda fila

        addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png")), 209, 430);
        addObject(new BotonCriatura("Mew", new GreenfootImage("mew_menu.png")), 306, 430);
        addObject(new BotonCriatura("Mimikyu", new GreenfootImage("mimikyu_menu.png")), 403, 430);
        addObject(new BotonCriatura("Espeon", new GreenfootImage("EspeonMenu.png")), 498, 430);
        addObject(new BotonCriatura("Charizard", new GreenfootImage("CharizardMenu.png")), 591, 430);

    }

    public void ubicarEnLista(BotonCriatura criaturaSeleccion) {
        if(contadorSeleccion <= 3){
            this.criaturasSeleccion[contadorSeleccion] = criaturaSeleccion;
            String nombreCriatura = criaturaSeleccion.getNombre();
            System.out.print(nombreCriatura);
            int pos_x;
            int pos_y;
            boolean equipoAzul;
            
            switch (contadorSeleccion) {
                case 0:
                    pos_x = 65;
                    pos_y = 88;
                    equipoAzul = true;
                    break;
                case 1:
                    pos_x = 65;
                    pos_y = 180;
                    equipoAzul = true;
                    break;
                case 2:
                    pos_x = 728;
                    pos_y = 88;
                    equipoAzul = false;
                    break;
                case 3:
                    pos_x = 728;
                    pos_y = 180;
                    equipoAzul = false;
                    break;
                default:
                    pos_x = 728;
                    pos_y = 180;
                    equipoAzul = false;
                    break;
            }
            System.out.print(pos_x);
            
            switch (nombreCriatura) { 
                case "Sylveon":
                    criaturas[contadorSeleccion] = new Sylveon("Sylveon", equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
                    break;
                case "Blastoise":
                    criaturas[contadorSeleccion] = new Blastoise("Blastoise",equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
                    break;
                case "Charizard" :
                    criaturas[contadorSeleccion] = new Charizard("Charizard",equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
                    break;
                case "Mimikyu"   :
                    criaturas[contadorSeleccion] = new Mimikyu("Mimikyu",equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
                    break;
                case "Mew"       :
                    criaturas[contadorSeleccion] = new Mew("Mew",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
                    break;
                case "Delphox"   :
                    criaturas[contadorSeleccion] = new Delphox("Delphox",equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
                    break;
                case "Espeon"    :
                    criaturas[contadorSeleccion] = new Espeon("Espeon",equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
                    break;
                case "Glaceon"   :
                    criaturas[contadorSeleccion] = new Glaceon("Glaceon",equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
                    break;
                case "Leafeon"   :
                    criaturas[contadorSeleccion] = new Leafeon("Leafeon",equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("sylveon_menu.png"), equipoAzul), pos_x, pos_y);
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

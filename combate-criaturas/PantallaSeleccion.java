import greenfoot.*;

public class PantallaSeleccion extends World {
    private Texto turnoTexto;
    private UIAtaques uiAtaques;
    private BotonCriatura[] criaturasSeleccion = new BotonCriatura[4];
    private BotonCriatura[] criaturasSeleccionMenu = new BotonCriatura[4];
    private Criatura[] criaturas = new Criatura[4];
    private int contadorSeleccion = 0;
    GreenfootSound sound = new GreenfootSound("seleccion.wav");
    GreenfootSound batallasound = new GreenfootSound("batalla.wav");
    GreenfootSound finsound = new GreenfootSound("menufin.wav");
    GreenfootSound letsfightsound = new GreenfootSound("lets-fight.wav");
    GreenfootSound selected_sfx = new GreenfootSound("click-sfx_2.mp3");


    public PantallaSeleccion() {
        super(800, 500, 1);
        MyGreenfootImage fondoSeleccion = new MyGreenfootImage(new GreenfootImage("select.png"));
        fondoSeleccion.scale(800,500);
        getBackground().drawImage(fondoSeleccion, 0, 0);
        agregarImagenesSeleccion();
        this.sound=sound;
        sound.play(); 
        sound.setVolume(0);
        sound.playLoop();

    }

    private void agregarImagenesSeleccion() {

        //Primera fila
        addObject(new BotonCriatura("Blastoise", new GreenfootImage("BlastoiseMenu.png")), 209, 340);
        addObject(new BotonCriatura("Charizard", new GreenfootImage("CharizardMenu.png")), 306, 340);
        addObject(new BotonCriatura("Glaceon", new GreenfootImage("GlaceonMenu.png")), 403, 340);
        addObject(new BotonCriatura("Leafeon", new GreenfootImage("LeafeonMenu.png")), 498, 340);
        addObject(new BotonCriatura("Delphox", new GreenfootImage("DelphoxMenu.png")), 591, 340);

        //Segunda fila
        addObject(new BotonCriatura("Sylveon", new GreenfootImage("SylveonMenu.png")), 209, 430);
        addObject(new BotonCriatura("Mew", new GreenfootImage("MewMenu.png")), 306, 430);
        addObject(new BotonCriatura("Mimikyu", new GreenfootImage("MimikyuMenu.png")), 403, 430);
        addObject(new BotonCriatura("Espeon", new GreenfootImage("EspeonMenu.png")), 498, 430);
        addObject(new BotonCriatura("Charizard", new GreenfootImage("CharizardMenu.png")), 591, 430);

        //Marcos de equipo

        addObject(new MarcoEquipo(new GreenfootImage("MarcoAzul.png"), true), 125, 140);
        addObject(new MarcoEquipo(new GreenfootImage("MarcoRojo.png"), false), 674, 140);

        //Boton duelo
        GreenfootImage botonDuelo = new GreenfootImage("BotonLuchar.png");
        botonDuelo.scale(231,48);
        addObject(new BotonDuelo("Boton Duelo", botonDuelo),400,148);

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
                    pos_x = 79;
                    pos_y = 140;
                    equipoAzul = true;
                    break;
                case 1:
                    pos_x = 171;
                    pos_y = 140;
                    equipoAzul = true;
                    break;
                case 2:
                    pos_x = 636;
                    pos_y = 140;
                    equipoAzul = false;
                    break;
                case 3:
                    pos_x = 727;
                    pos_y = 140;
                    equipoAzul = false;
                    break;
                default:
                    pos_x = 150;
                    pos_y = 140;
                    equipoAzul = false;
                    break;
            }
            System.out.print(pos_x);

            switch (nombreCriatura) { 
                case "Sylveon":
                    criaturas[contadorSeleccion] = new Sylveon("Sylveon", !equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("SylveonMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                case "Blastoise":
                    criaturas[contadorSeleccion] = new Blastoise("Blastoise",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("BlastoiseMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                case "Charizard" :
                    criaturas[contadorSeleccion] = new Charizard("Charizard",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("CharizardMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                case "Mimikyu"   :
                    criaturas[contadorSeleccion] = new Mimikyu("Mimikyu",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("MimikyuMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                case "Mew"       :
                    criaturas[contadorSeleccion] = new Mew("Mew",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("MewMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                case "Delphox"   :
                    criaturas[contadorSeleccion] = new Delphox("Delphox",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("DelphoxMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                case "Espeon"    :
                    criaturas[contadorSeleccion] = new Espeon("Espeon",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("EspeonMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                case "Glaceon"   :
                    criaturas[contadorSeleccion] = new Glaceon("Glaceon",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("GlaceonMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                case "Leafeon"   :
                    criaturas[contadorSeleccion] = new Leafeon("Leafeon",!equipoAzul);
                    addObject(new BotonCriatura("Sylveon", new GreenfootImage("LeafeonMenu.png"), equipoAzul,false), pos_x, pos_y);
                    selected_sfx.play();
                    break;
                default:
                    break;
            }
            this.contadorSeleccion++;
        }
    }

    public void empezarDuelo() {
        //Cambia el mundo
        if (contadorSeleccion > 3){
            Greenfoot.setWorld(new PantallaDuelo(criaturas));
            sound.pause();
            letsfightsound.play();
            this.finsound=finsound;
            //finsound.play(); 
            this.batallasound=batallasound;
            //Greenfoot.delay(200);
            batallasound.play(); 
            batallasound.setVolume(10);
            batallasound.playLoop();

        }
    }

    public int getContadorSeleccion() {

        return this.contadorSeleccion;
    }

}

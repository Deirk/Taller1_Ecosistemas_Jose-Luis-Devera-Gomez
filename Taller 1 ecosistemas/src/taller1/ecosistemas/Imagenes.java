package taller1.ecosistemas;

import processing.core.PApplet;
import processing.core.PImage;

public class Imagenes {

	private PApplet app;
	static PImage electraI;
	static PImage electraD;
	static PImage balaElectraI;
	static PImage balaElectraD;
	static PImage theBeastI;
	static PImage theBeastD;
	static PImage balaTheBeastI;
	static PImage balaTheBeastD;
	static PImage escenario;
	static PImage bnEscenario;
	static PImage vida1;
	static PImage vida2;
	static PImage geoda;
	static PImage crystalrogx;
	static PImage inicio;
	
	public Imagenes(PApplet app) {
		this.app = app;
		Imagenes.electraI = app.loadImage("ElectraI.png");
		Imagenes.theBeastI = app.loadImage("The beastI.png");
		Imagenes.electraD = app.loadImage("ElectraD.png");
		Imagenes.theBeastD = app.loadImage("The beastD.png");
		Imagenes.balaElectraI = app.loadImage("ElectraShootI.png");
		Imagenes.balaTheBeastI = app.loadImage("The beastShotI.png");
		Imagenes.balaElectraD = app.loadImage("ElectraShootD.png");
		Imagenes.balaTheBeastD = app.loadImage("The beastShotD.png");
		Imagenes.escenario = app.loadImage("Fondo.png");
		Imagenes.bnEscenario = app.loadImage("BnFondo.png");
		Imagenes.vida1 = app.loadImage("jugador1.png");
		Imagenes.vida2 = app.loadImage("jugador2.png");
		Imagenes.inicio = app.loadImage("Inicio.png");
		// TODO Auto-generated constructor stub
	}
	
}

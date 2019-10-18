package taller1.ecosistemas;

import processing.core.PApplet;

public class Main extends PApplet {
	
	private Logica log;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("taller1.ecosistemas.Main");
	}
	
	public void settings() {
		size(1200,700);
	}
	
	public void setup() {
		log = new Logica(this);
		log.start();
		imageMode(CENTER);
	}
	
	public void draw() {
		log.show();
	}
	
	public void keyPressed() {
		log.tecladoPresionar();
	}
	
	public void keyReleased() {
		log.tecladoSoltar();
	}
	
	public void mousePressed() {
		log.mouseClick();
	}
	
	

}

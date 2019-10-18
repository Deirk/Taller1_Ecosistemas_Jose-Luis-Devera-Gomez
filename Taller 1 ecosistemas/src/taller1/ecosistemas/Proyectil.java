package taller1.ecosistemas;

import processing.core.PApplet;
import processing.core.PVector;

public class Proyectil {

	private PApplet app;
	private int tipo;
	private PVector pos;
	private int vel;
	private int direccion;

	public Proyectil(PApplet app, int tipo, float x, float y, int direccion) {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.tipo = tipo;
		this.direccion = direccion;
		pos = new PVector(x, y);
		vel = 6;
	}

	public void show() {
		if (tipo == 1) {
			if (direccion == -1) {
				app.image(Imagenes.balaElectraI, pos.x, pos.y);
			} else if (direccion == 1) {
				app.image(Imagenes.balaElectraD, pos.x, pos.y);
			}

		} else if (tipo == 2) {
			if (direccion == -1) {
				app.image(Imagenes.balaTheBeastI, pos.x, pos.y);
			} else if (direccion == 1) {
				app.image(Imagenes.balaTheBeastD, pos.x, pos.y);
			}
		}
	}

	public void mover() {
		pos.x += vel * direccion;
	}
	
	public float getX() {
		return pos.x;
	}
	
	public float getY() {
		return pos.x;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	

}

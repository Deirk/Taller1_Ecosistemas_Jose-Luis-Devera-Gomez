package taller1.ecosistemas;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;
import processing.core.PVector;

public class Jugador extends Thread implements Observer{

	private PApplet app;
	private int jugador;
	private PVector pos;
	private float vel;
	private float grav;
	private int vida;
	private boolean jump;
	private boolean left, rigth;
	private int direccion;
	private ArrayList<Proyectil> proyectiles;

	public Jugador(PApplet app, int jugador) {
		// TODO Auto-generated constructor stub
		this.app = app;
		this.jugador = jugador;
		if (jugador == 1) {
			pos = new PVector(150, 550);
			vel = 4;
		} else if (jugador == 2) {
			pos = new PVector(1100, 600);
			vel = 3;
		}
		grav = 1;
		vida = 7;
		direccion = 1;
		proyectiles = new ArrayList<Proyectil>();
	}

	public void show() {
		if (jugador == 1) {
			app.fill(0,255,0,90);
			app.rect(pos.x-25, pos.y-53, 6*vida, 5);
			app.image(Imagenes.vida1, pos.x, pos.y-50);
			if (direccion == 1) {
				app.image(Imagenes.electraD, pos.x, pos.y);
			} else if (direccion == -1) {
				app.image(Imagenes.electraI, pos.x, pos.y);
			}

		} else if (jugador == 2) {
			app.fill(0,255,0,90);
			app.rect(pos.x-17, pos.y-53, 6*vida, 5);
			app.image(Imagenes.vida2, pos.x, pos.y-50);
			if (direccion == 1) {
				app.image(Imagenes.theBeastD, pos.x, pos.y);
			} else if (direccion == -1) {
				app.image(Imagenes.theBeastI, pos.x, pos.y);
			}

		}

		for (int i = 0; i < proyectiles.size(); i++) {
			proyectiles.get(i).show();
		}
	}

	public void run() {
		while (vida > 0) {
			try {
				grav += 0.2;
				if (Imagenes.bnEscenario.get((int) pos.x, (int) pos.y + 38) == -16777216) {
					if (jump == false) {
						grav = 0;
					}
					jump = false;
				} else if (Imagenes.bnEscenario.get((int) pos.x, (int) pos.y - 35) == -16777216) {
					grav = 1;
				}
				pos.y += grav;

				if (left == true) {
					pos.x -= vel;
				}
				if (rigth == true) {
					pos.x += vel;
				}

				for (int i = 0; i < proyectiles.size(); i++) {
					proyectiles.get(i).mover();
				}

				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void tecladoPresionar() {
		if (jugador == 1) {

			if (app.keyCode == app.RIGHT) {
				rigth = true;
				direccion = 1;
			}
			if (app.keyCode == app.LEFT) {
				left = true;
				direccion = -1;
			}

		} if (jugador == 2) {
			if (app.key == 'd') {
				rigth = true;
				direccion = 1;
			}
			if (app.key == 'a') {
				left = true;
				direccion = -1;
			}

		}
	}

	public void evaluar(Jugador jug) {
		for (int i = 0; i < proyectiles.size(); i++) {
			Proyectil bala = proyectiles.get(i);
			if (app.dist(jug.getX(), jug.getY(), bala.getX(), bala.getY()) < 10) {
				if (jug.getJugador() != jugador) {
					jug.setVida(jug.getVida() - 1);
					proyectiles.remove(bala);
					return;
				}
			}
		}
	}

	public void tecladoSoltar() {
		if (jugador == 1) {

			if (app.keyCode == app.RIGHT) {
				rigth = false;
			} else if (app.keyCode == app.LEFT) {
				left = false;
			}
			if (app.key == ' ') {
				jump = true;
				grav = -9;
			}
			if (app.key == '0') {
				proyectiles.add(new Proyectil(app, jugador, pos.x, pos.y, direccion));
			}
		} 
		
		if (jugador == 2) {

			if (app.key == 'd') {
				rigth = false;
			} else if (app.key == 'a') {
				left = false;
			}
			if (app.key == 'f') {
				if (jump == false) {
					jump = true;
					grav = -9;
				}
			}
			if (app.key == 'q') {
				proyectiles.add(new Proyectil(app, jugador, pos.x, pos.y, direccion));
			}
		}

	}
	
	
	public int getJugador() {
		return jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

	public float getX() {
		return pos.x;
	}

	public float getY() {
		return pos.x;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}

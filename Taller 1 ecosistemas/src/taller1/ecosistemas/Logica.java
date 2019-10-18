package taller1.ecosistemas;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Logica extends Thread implements Observer {

	private PApplet app;
	private Imagenes imagenes;
	private int pantalla;
	private ArrayList<Jugador> jugadores;
	private Comunicacion com;
	private Timer time;

	public Logica(PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		imagenes = new Imagenes(app);
		com = Comunicacion.getSingleton();
		com.addObserver(this);
		Thread t = new Thread(com);
		t.start();


	}

	public void show() {
		switch (pantalla) {
		case 0:
			app.image(Imagenes.inicio, app.width/2, app.height/2 );
			break;

		case 1:

			app.image(Imagenes.escenario, app.width / 2, app.height / 2);
			for (int i = 0; i < jugadores.size(); i++) {
				jugadores.get(i).show();
			}
			time.show();


			break;

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	public void run() {
		while (true) {

			try {
		
				switch (pantalla) {
				case 1:
					for (int i = 0; i < jugadores.size(); i++) {
						for (int j = 0; j < jugadores.size(); j++) {
							jugadores.get(i).evaluar(jugadores.get(j));
						}
						break;
					}
				}
					sleep(20);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void mouseClick() {
		if (pantalla == 0) {
			jugadores = new ArrayList<Jugador>();
			time = new Timer(app);
			time.start();
			for (int i = 0; i < 2; i++) {
				Jugador jugador = new Jugador(app, i + 1);
				jugadores.add(jugador);
				jugador.start();
			}
			pantalla = 1;
		}
	}

	public void tecladoPresionar() {
		switch (pantalla) {
		case 1:
			for (int i = 0; i < jugadores.size(); i++) {
				jugadores.get(i).tecladoPresionar();
			}		
			break;
		}
		
	}
		

	public void tecladoSoltar() {
		switch (pantalla) {
		case 1:
			for (int i = 0; i < jugadores.size(); i++) {
				jugadores.get(i).tecladoSoltar();
			}

			break;
		}
			}

}

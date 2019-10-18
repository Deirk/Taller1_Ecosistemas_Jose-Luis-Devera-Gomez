package taller1.ecosistemas;

import processing.core.PApplet;

public class Timer extends Thread {
	
	private PApplet app;
	private boolean contando = true;
	private int sRestantes;
	private int mRestantes;
	
	public Timer(PApplet app) {
		this.app = app;
		// TODO Auto-generated constructor stub
		 mRestantes = 3;
	}
	
	public void show() {
		app.textSize(50);
		app.fill(255);
		app.text(mRestantes + ":" + sRestantes, 50, 50);
	}
	
	public void run() {
		while(contando) {
			try {
				sleep(1000);
				if (sRestantes == 0) {
					mRestantes --;	
					if (mRestantes != 0) {
						sRestantes = 59;
					}
					
				} else {
					sRestantes --;
				}
				if (mRestantes == 0) {
					contando = false;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}

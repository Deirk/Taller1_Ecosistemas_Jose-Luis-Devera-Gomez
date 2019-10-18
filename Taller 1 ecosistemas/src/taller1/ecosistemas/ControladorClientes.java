package taller1.ecosistemas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;

public class ControladorClientes extends Observable implements Runnable {

	private Socket s;
	private DataOutputStream salida;
	private DataInputStream entrada;

	public ControladorClientes(Socket socket) {
		try {
			this.s = socket;
			salida = new DataOutputStream(s.getOutputStream());
			entrada = new DataInputStream(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				recibir();
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	private void recibir() throws IOException {
		if (s != null && s.isConnected() && !s.isClosed()) {
			String mensaje = entrada.readUTF();
			setChanged();
			notifyObservers(mensaje);
			clearChanged();
		}
	}
	
	public void enviar(String mensaje) {

		if (s != null && s.isConnected() && !s.isClosed()) {

			new Thread(new Runnable() {

				@Override
				public void run() {
					try {						
						salida.writeUTF(mensaje);
				
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();

		}
	}

}

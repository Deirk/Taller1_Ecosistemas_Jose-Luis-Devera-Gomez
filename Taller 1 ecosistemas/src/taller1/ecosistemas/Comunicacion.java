package taller1.ecosistemas;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

	public class Comunicacion extends Observable implements Runnable, Observer {

		private static Comunicacion ref;
		private ServerSocket ss;
		private ArrayList<ControladorClientes> clientes;

		private Comunicacion() {

			try {
				ss = new ServerSocket(5000);
				clientes = new ArrayList<>();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public static Comunicacion getSingleton() {
			if (ref == null) {
				ref = new Comunicacion();
			}
			return ref;
		}
		
		@Override
		public void run() {

			while (true) {


					try {
						recibirClientes();
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		}

		private void recibirClientes() throws IOException {
			
			System.out.println("comunicacion iniciada");
			
			Socket socketNuevoCliente = ss.accept();

			ControladorClientes nuevoCliente = new ControladorClientes(socketNuevoCliente);

			clientes.add(nuevoCliente);

			Thread t = new Thread(nuevoCliente);

			t.start();

			nuevoCliente.addObserver(this);

			System.out.println("Ahora tengo " + clientes.size() + " Clientes");

		}

		@Override
		public void update(Observable o, Object arg) {

			System.out.println((String) arg);

			setChanged();
			notifyObservers((String) arg);
			clearChanged();
		}

		public ArrayList<ControladorClientes> getClientes() {
			return clientes;
		}

	}

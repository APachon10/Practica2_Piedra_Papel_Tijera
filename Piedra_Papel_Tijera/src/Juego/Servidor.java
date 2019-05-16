package Juego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {
	public static void main(String[] args) throws IOException {
		int puerto = 1234;
		//Creamos el Socket Server con el puerto 1234
		ServerSocket socket_server  =  new ServerSocket(puerto);
		//Variables para manejar los Datos que manda el usuario 
		int eleccion;
		int res;
		while(true) {
			System.out.println("LocalHost: "+InetAddress.getLocalHost());
			System.out.println("Juego listo... esperando cliente ");
			//El Servidor coge la Eleccion del Socket 
			Socket socket = socket_server.accept();
			//Cogemos los datos del socket 
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			//El Servidor hace su Eleccion
			Random r = new Random(); 
			int posibilidad = r.nextInt(30);
			//1= Piedra, 2 = Papel , 3= Tijeras
			int posibles_elecciones [] = {1,2,3};
		}
	}
}

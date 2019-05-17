package Juego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {
	static int eleccion_server;
	public static void main(String[] args) throws IOException {
		int puerto = 1234;
		//Creamos el Socket Server con el puerto 1234
		ServerSocket socket_server  =  new ServerSocket(puerto);
		//Variables para manejar los Datos que manda el usuario 
		int eleccion=0;
		int res;
		System.out.println("LocalHost: "+InetAddress.getLocalHost());
		System.out.println("Juego listo... esperando cliente ");
		//El Servidor coge la Eleccion del Socket 
		Socket socket = socket_server.accept();
		//Cogemos los datos del socket 
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		//El Servidor hace su Eleccion
		Random r = new Random(); 
		
		int contador=0,contador_server=0;
		int i=1;
		eleccion = dis.readInt();
		Cliente_Jugador v = new Cliente_Jugador();
		do {
			System.out.println("Ronda : "+i);
			System.out.println("========================================");
			System.out.println("Servidor: "+contador_server +" ------------"+"Cliente:"+contador );
			int eleccion_server = r.nextInt(3)+1;
			if(eleccion >0 && eleccion <=3) {
				switch (eleccion_server) {
				case 1:
					switch (eleccion) {
					case 1:
						System.out.println("El Servidor ha escogido Piedra ,la Ronda queda en Empate ");
						break;
					case 2:
						System.out.println("El Servidor ha escogido Piedra ,Punto para el Servidor");
						contador_server++;
						break;
					case 3:
						System.out.println("El Servidor ha escogido Piedra ,Punto para el Jugador  ");
						contador++;
						break;
					}
					break;
				case 2:
					switch (eleccion) {
					case 1:
						System.out.println("El Servidor ha escogido Papel ,Punto para el Servidor");
						contador_server++;
						break;
					case 2:
						System.out.println("El Servidor ha escogido Papel ,La Ronda queda en Empate ");
						break;
					case 3:
						System.out.println("El Servidor ha escogido Papel , Punto para el Jugador");
						contador++;
						break;
					}
					break;
				case 3:
					switch (eleccion) {
					case 1:
						System.out.println("El servidor ha escogido Tijera,Punto para el Servidor ");
						contador_server++;
						break;
					case 2:
						System.out.println("El servidor ha escogido Tijera,Punto para el Jugador ");
						contador++;
						break;
					case 3:
						System.out.println("El servidor ha escogido Tijera, La ronda queda en Empate ");
						break;
					}
					break;
				}
				System.out.println("=================================================");
				System.out.println("Servidor: "+contador_server +" ------------"+"Cliente:"+contador );
				v.mainn();
				i++;
				//Cerramos los Stream y el Socket
				dis.close();
				dos.close(); 
				socket.close();
			}
		}while(contador <=3 && contador_server<=3);
		
	}
}

package Juego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente_Jugador {
	public static void mainn() throws IOException{
		//Definimos el Puerto y el host del cliente 
		final int puerto = 1234;
		final String host = "localhost";
		//Creamos los Streams para insertar y sacar Datos
		DataInputStream dis = null;
		DataOutputStream dos = null;
		int numero = 0;
		//Bucle infinit
		while(true) {
			try {
				//Creamos el Socket con el host y el puerto
				Socket socket = new Socket(host, puerto);
				System.out.println("1 - Piedra "
						+ "2 - Papel"
						+ "3 - Tijeras");
				System.out.print("Escoge una opcion: ");
				//Le pasamos un Numero al Servidor
				numero = leerEnteros();
				//Extraemos los Streams de entrada y salida 
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeInt(numero);
				int res = dis.readInt();
				System.out.println( " Eleccion Jugador: " + numero +", \tResultado: "+res);
				//Cerramos los Streams y el socket 
				dis.close();
				dos.close();
				socket.close();
			} catch (Exception e) {
				System.out.println("Error!: " +e);
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		mainn();
	}
	//Metodo para leerDatos
	public static int leerEnteros() {
		Scanner scan  =new Scanner(System.in);
		int numero =  scan.nextInt();
		return numero;
	}
	public static String leerCadenas() {
		Scanner scan  =new Scanner(System.in);
		String numero =  scan.nextLine();
		return numero;
	}
}

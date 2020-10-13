package servicio;

import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class BicisLocal {

	static final int NPUESTOS = 5; // Numero de puestos de alquiler de bicis

	/**
	 * Muestra el menu de opciones y lee repetidamente de teclado hasta obtener una opcion valida
	 * @param teclado
	 * @return
	 */
	public static int menu(Scanner teclado) {
		int opcion;
		System.out.println("\n\n");
		System.out.println("=====================================================");
		System.out.println("============            MENU        =================");
		System.out.println("=====================================================");
		System.out.println("0. Salir");
		System.out.println("1. Consultar bicis disponibles");
		System.out.println("2. Consulta bicis alquiladas");
		System.out.println("3. Alquilar bicicleta");
		System.out.println("4. Devolver bicicleta");
		do {
			System.out.print("\nElige una opcion (0..4): ");
			opcion = teclado.nextInt();
		} while ( (opcion<0) || (opcion>4) );
		teclado.nextLine(); // Elimina retorno de carro del buffer de entrada
		return opcion;
	}


	/**
	 * Programa principal. Muestra el menú repetidamente y atiende las peticiones del cliente.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException  {

		Scanner teclado = new Scanner(System.in);

		// Crea un gestor de alquiler de bicis
		GestorAlquileres gestor = new GestorAlquileres();

		System.out.print("Introduce tu codigo de cliente (max. 8 caracteres): ");
		String codcli = teclado.nextLine();
		codcli = rightPad(codcli,8);
		System.out.print("Codigo recortado: "+codcli);

		int opcion; 
		do {
			opcion = menu(teclado);
			switch (opcion) {
			case 0: // Cierra el gestor y sale del programa
				gestor.cierraGestor();
				break;

			case 1: { // Consulta bicis disponibles
				int[] nBicis = gestor.consultaDisponibles();
				for(int i=0; i<NPUESTOS; i++) {
					System.out.println("Puesto "+(i+1)+": "+nBicis[i]+" bicicletas disponibles");
				}
				break;
			}

			case 2: { // Consulta bicis alquiladas por un cliente
				Vector<String> alquiladas = gestor.consultaAlquiladas(codcli);
				if (alquiladas.size()==0) {
					System.out.println("Usted no tiene alquilada ninguna bicicleta.");
				}
				else {
					System.out.println("Ha alquilado las siguientes bicicletas:\n");
					for(int i=0; i<alquiladas.size(); i++) {
						System.out.println("-Bicicleta "+alquiladas.get(i)+"\n");
					}
				}
				break;
			}

			case 3: { // Alquila una bici
				System.out.print("Introduce el puesto donde quiere alquilar la bici: ");
				int puesto = teclado.nextInt();
				String biciAlquilada = gestor.alquilaBici(puesto, codcli); 
				if(biciAlquilada==null) System.out.println("Puesto incorrecto o puesto vacio.");
				else {
					System.out.println("Bicicleta "+biciAlquilada+" del puesto "+puesto+" alquilada.");
				}
				break;
			}

			case 4: // Devuelve una bici
				System.out.print("Introduce el puesto donde quiere devolver la bicicleta: ");
				int puesto = teclado.nextInt();
				System.out.print("Introduce el codigo de la bicicleta que quiere devolver: ");
				String bici = teclado.next();	
				String biciDevuelta = gestor.devuelveBici(puesto, bici, codcli);
				if(biciDevuelta!=null) {
					System.out.print("Bicicleta "+biciDevuelta+" devuelta correctamente");
				}
				else System.out.print("El puesto no existe o esta lleno, o el codigo de bicicleta introducido es incorrecto");
				break;

			} // fin switch

		} while (opcion != 0);

	} // fin de main

	private static String rightPad(String cadena, int n) {
		return (cadena.length()) < n ? cadena+"        ".substring(0,n-cadena.length()) : cadena.substring(0,n);
	}

} // fin class

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

		int opcion; 
		do {
			opcion = menu(teclado);
			switch (opcion) {
			case 0: // Cierra el gestor y sale del programa
				gestor.cierraGestor();
				break;

			case 1: { // Consulta bicis disponibles
					
				
				break;
			}

			case 2: { // Consulta bicis alquiladas por un cliente

				// POR IMPLEMENTAR

				break;
			}

			case 3: { // Alquila una bici

				// POR IMPLEMENTAR


				break;
			}

			case 4: // Devuelve una bici

				// POR IMPLEMENTAR


				break;

			} // fin switch

		} while (opcion != 0);


	} // fin de main

} // fin class

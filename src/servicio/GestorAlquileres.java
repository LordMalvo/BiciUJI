package servicio;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.Vector;


public class GestorAlquileres {

	private final int NPUESTOS = 5; // Numero de puestos de alquiler de bicis
	private final int NBICIS = 10;  // Bicicletas por puesto

	private RandomAccessFile stream;


	/**
	 * Constructor del gestor de consultas del servicio de alquiler.
	 * Crea un fichero con datos de prueba
	 */
	public GestorAlquileres() {
		creaFichero("bicis.dat");
	}

	/**
	 * Cierra el flujo/stream asociado al fichero de comics.
	 * @throws IOException 
	 */
	public void cierraGestor() throws IOException{
		stream.close();
		
	}

	/**
	 * Si no existe, crea el fichero y lo rellena con unas bicis
	 * 
	 * @param nombreFichero
	 */
	public void creaFichero(String nombreFichero) {
		File f = new File(nombreFichero);
		stream = null;
		try {
			if (!f.exists()) {
				stream = new RandomAccessFile(f, "rw"); // al no existir, lo crea

				// Primero colocamos NBICIS/2 en cada puesto
				for (int p = 0; p < NPUESTOS; p++) {
					stream.writeInt(NBICIS/2);
				}				

				// Ahora llena la primera mitad de cada puesto almacenando bicis con hora de devolucion 00:00
				Bicicleta bici = null;
				int ct = 0;
				for (int p = 0; p < NPUESTOS; p++) {
					for (int b = 0; b < NBICIS/2; b++) {
						bici = new Bicicleta("B"+String.format("%03d", ct), p, "        ", 0, 0);
						bici.escribeEnFichero(stream); 
						ct++;
					}
				}	

			}	
			else
				stream = new RandomAccessFile(f, "rw"); // al existir, lo abre sin destruir su contenido
		}
		catch (IOException e) {
			System.out.println("Problema al crear el fichero");
			System.exit(0);
		};
	}
	

	/**
	 * Consulta el numero de bicis disponibles en todos los puestos
	 * 
	 * @return	vector con las bicis disponibles en cada puesto
	 * @throws IOException 
	 */
	public int[] consultaDisponibles() throws IOException {
		stream.seek(0);
		
		
		return null; // DEVOLVER LA INFORMACION ADECUADA EN CADA CASO
		
	}
	

	/**
	 * Devuelve las bicis alquiladas por el cliente
	 * 
	 * @param codcli
	 * @return vector de bicis alquiladas. Vector vacio si no tiene ninguna
	 */
	public Vector<String> consultaAlquiladas(String codcli) {	

		// POR IMPLEMENTAR
		
		return null; // DEVOLVER LA INFORMACION ADECUADA EN CADA CASO
		

	}




	/**
	 * Devuelve el indice de la primera bici del puesto en el fichero
	 * 
	 * @param puesto	puesto en el que buscar
	 * @return	indice en el fichero. -1 si el puesto no existe o no tiene bicis
	 */
	private long buscaBiciPuesto(int puesto) {
		boolean encontrada = false;
		long indice = -1;
		Bicicleta bici = null;
		if ( (puesto < 0) || (puesto > (NPUESTOS-1)) )
			return -1;
		else {
			bici = new Bicicleta();
			// Recorre todo el fichero buscando bicis del cliente
			try {
				stream.seek(NPUESTOS*Integer.BYTES);
				while(!encontrada) {
					indice = stream.getFilePointer();
					bici.leeDeFichero(stream);
					if ( bici.getPuesto() == puesto ) 
						encontrada = true;
				}
			}
			catch (EOFException e) { // Hemos llegado al final del fichero
				indice = -1;
			}
			catch (IOException e) {
				indice = -1;
				System.out.println("Error en buscaBiciPuesto");
			}

			return indice;
		}	
	}



	/**
	 * El cliente codcli alquila una bici de un puesto dado
	 * 
	 * @param puesto	puesto del que alquilar
	 * @param codcli	codigo del cliente que alquila
	 * @return	bici alquilada. null si no hay bicis en ese puesto o el puesto no existe
	 */
	public String alquilaBici(int puesto, String codcli) {

		// POR IMPLEMENTAR
		
		return null; // DEVOLVER LA INFORMACION ADECUADA EN CADA CASO
		
	}



	/**
	 * Devuelve el numero de huecos en un puesto dado
	 * 
	 * @param puesto	puesto en el que buscar
	 * @return	numero de huecos hueco. -1 si el puesto no existe
	 * @throws IOException 
	 */
	private int numHuecos(int puesto) throws IOException {

		// POR IMPLEMENTAR
		
		return 0; // DEVOLVER LA INFORMACION ADECUADA EN CADA CASO
		
	}

	/**
	 * Devuelve la posicion en el fichero de la bici con un codigo dado
	 * 
	 * @param codbici	codigo de la bici
	 * @return	indice en el fichero. -1 si no se encuentra la bici
	 * @throws IOException 
	 */
	private long buscaBici(String codbici) throws IOException {

		// POR IMPLEMENTAR
		
		return 0; // DEVOLVER LA INFORMACION ADECUADA EN CADA CASO
		
	}


	/**
	 * Devuelve una bici en un puesto dado
	 * 
	 * @param puesto	puesto en el que devolver la bici
	 * @param codbici	codigo de la bici
	 * @param codcli	codigo del cliente que devuelve la bici
	 * @return	bici devuelta. null si no la ha podido devolver
	 */
	public String devuelveBici(int puesto, String codbici, String codcli) {

		// POR IMPLEMENTAR
		
		return null; // DEVOLVER LA INFORMACION ADECUADA EN CADA CASO

	}

}

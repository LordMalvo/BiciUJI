package servicio;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class Bicicleta implements Serializable {


	private static final long serialVersionUID = 1L;
	
	/**
	 * Clase Bicicleta
	 */
	
    private String codbici;  // codigo unico de la bicicleta. Formato Bxxx, donde xxx es un numero rellenado a 0 por la izquierda
    private int puesto;      // puesto en el que esta guardada. -1 si esta alquilada
    private String codcli;   // codigo del cliente que la ha alquilado. Cadena de un maximo de 8 caracteres para garantizar que se podrian guardar con tamaño fijo en un fichero
    private int hora;        // hora en que se alquilo/devolvio
    private int minuto;      // minuto en que se alquilo/devolvio
    
	/**
	 * Constructor por defecto de una Bicicleta
	 */	
  	public Bicicleta() {
	  super();
  	} 
  	
  
  	/**
  	 * Constructor con valores de una Bicicleta
  	 * 
  	 * @param codbici
  	 * @param puesto
  	 * @param codcli
  	 * @param hora
  	 * @param minuto
  	 */
	public Bicicleta(String codbici, int puesto, String codcli, int hora, int minuto) {
		super();
		this.codbici = codbici;
		this.puesto = puesto;
		this.codcli = rightPad(codcli, 8);
		this.hora = hora;
		this.minuto = minuto;
	}
	

	@Override
	/**
	 * Devuelve los datos de la bici en una cadena
	 */
	public String toString() {
		return codbici + "#" + puesto + "#" + codcli +  "#" + hora+  "#" + minuto;
	}

	/**
	 * Ajusta el tamaño de una cadena para que ocupe n caracteres.
	 * La recorta o la rellena con blancos por la derecha.
	 * 
	 * @param cadena	cadena que queremos ajustar
	 * @param n			numero de caracteres que queremos que acabe teniendo
	 * @return			cadena con el tamaño ajustado
	 */
	public String rightPad(String cadena, int n) {
		return (cadena.length()) < n ? cadena+"        ".substring(0,n-cadena.length()) : cadena.substring(0,n);
	}

	/**
	 *
	 * @return	codigo de la bici
	 */
	public String getCodbici() {
		return codbici;
	}

	/**
	 * 
	 * @param codbici	codigo a asignar a la bici
	 */
	public void setCodbici(String codbici) {
		this.codbici = codbici;
	}


	/**
	 * 
	 * @return	puesto en el que esta guardada. -1 si esta alquilada
	 */
	public int getPuesto() {
		return puesto;
	}

	/**
	 * 
	 * @param puesto	puesto a asignar
	 */
	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	/**
	 * 
	 * @return	codigo del cliente que tiene la bici alquilada. Cadena vacia si no esta alquilada
	 */
	public String getCodcli() {
		return codcli; 
	}
	
	
	/**
	 * Asigna un codigo de cliente a una bici ajustando su tamanyo a 8 caracteres
	 * 
	 * @param codcli	codigo del cliente a asignar
	 */
	public void setCodcli(String codcli) {
		this.codcli = rightPad(codcli, 8);
	}

	/**
	 * 
	 * @return	hora en que se alquilo/devolvio la bici
	 */
	public int getHora() {
		return hora;
	}

	/**
	 * 
	 * @param hora	hora a asignar
	 */
	public void setHora(int hora) {
		this.hora = hora;
	}

	/**
	 * 
	 * @return	minuto en que se alquilo/asigno la bici
	 */
	public int getMinuto() {
		return minuto;
	}

	/**
	 * 
	 * @param minuto	minuto a asignar
	 */
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}


	/**
	 * Lee los datos de una bici de la posicion actual de un fichero
	 * @param	stream	stream asociado al fichero
	 * @throws	EOFException, IOException
	 */	
  	public void leeDeFichero(RandomAccessFile stream) throws EOFException, IOException {
  		setCodbici(stream.readUTF());
  		setPuesto(stream.readInt());
  		setCodcli(stream.readUTF());
  		setHora(stream.readInt());
  		setMinuto(stream.readInt());
    } // fin leeDeFichero
  	

	/**
	 * Escribe los datos de una bici en la posicion actual de un fichero en formato binario
	 * @param	stream	stream asociado al fichero
	 * @throws IOException 
	 */	
  	public void escribeEnFichero(RandomAccessFile stream) throws IOException {
  	  	stream.writeUTF(getCodbici());
  	  	stream.writeInt(getPuesto());
  	  	stream.writeUTF(getCodcli());
  	  	stream.writeInt(getHora());
  	  	stream.writeInt(getMinuto());	
    } // fin escribeEnFichero
	

   
}

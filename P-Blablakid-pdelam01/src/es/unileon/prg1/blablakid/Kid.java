package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author pdelam01
 *
 */

public class Kid {
	private String name;
	private Activities activities;
	final static int TAM = 3;
	private static final Logger logger= LogManager.getLogger(Kid.class);


	/**
	 * Constructor clase Kid
	 * @param name
	 * @return void
	 */
	
	public Kid (String name)throws BlablakidException{
		if(name.compareTo(" ")==0) {
			logger.error("Error in the name of kid");
			throw new BlablakidException("Error in the name of kid");
		}else {
			this.name = name;
			this.activities = new Activities(TAM);
		}
	}
	
	/**
	 * Obtiene nombre del ninio
	 * @return
	 */
	String getName() {
		return this.name;
	}

	
	/*
	 * Metodo anyade una actividad asociada a un ninio
	 * @return devuelve true si el metodo add de la clase Activities consigue anyadir una actividad al array de activities
	 * @throws BlablakidException 
	 */
	
	public boolean add(Activity activity) throws BlablakidException {
		boolean add = false;

		if (this.activities.add(activity)) {
			add = true;
		}
		return add;
	}
	
	/**
	 * Metodo borra actividada asociada a un ninio
	 * @param activity
	 * @return
	 * @throws BlablakidException
	 */
	public boolean remove(Activity activity) throws BlablakidException {
		boolean remove = false;
		
		if(this.activities.remove(activity)) {
			remove = true;
		}
		return remove;
	}
	

	/**
	 * Metodo toString clase Kid
	 * @param 
	 * @return devuelve un String con los datos del kid
	 * 
	 */
	
	@Override
	public String toString () {
		StringBuilder salida = new StringBuilder();

		salida.append("******"+this.name+"******");
		salida.append("\n");
		if(this.activities!=null) {
			salida.append(this.activities.toString());
		}
		
		return salida.toString();
	}
}




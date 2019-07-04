package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author dfernv04
 *
 */
public class Activities {
	 
	private Activity activity [];
	private int next;
	private static final Logger logger= LogManager.getLogger(Activities.class);
	
	/**
	 * Constructor de Activities
	 * @param MAX_ACTIVITIES
	 */
	public Activities(int MAX_ACTIVITIES) {
		this.next = 0;
		this.activity = new Activity[MAX_ACTIVITIES];
	}

	/**
	 * Anyade una actividad
	 * @param activity
	 * @return boolean
	 */
	public boolean add(Activity activity)throws BlablakidException {
		boolean anyadir = false;
		if(isFull()) {
			logger.error("ERROR, the array of activities is full!");
			throw new BlablakidException("ERROR, the array of activities is full!");	
		}else if(buscar(activity.getName())!=null) {
			logger.error("ERROR, the activity already exists!");
				throw new BlablakidException("ERROR, the activity already exists!");
		}else {
			logger.info("Activity added");
			this.activity[next] = activity;
			next++;
			anyadir = true;
		}
	return anyadir;
	}

	/**
	 * Elimina una actividad
	 * @param activity
	 * @return boolean
	 */
	public boolean remove(Activity activity)throws BlablakidException {
		boolean quitar = false;
		if(buscar(activity.getName())!=null) {
			this.activity[next]=null;
			next --;
			for(int i=next;i<this.activity.length-1;i++) {
				this.activity[i]=this.activity[i+1];
			}
			logger.info("Activity removed");
			quitar = true;
		}else {
			logger.error("ERROR, the procces of removing a activity has failed");
			throw new BlablakidException("ERROR, the procces of removing a activity has failed");
		}
		return quitar;
	}
	
	
	/**
	 * Comprueba si el array esta lleno
	 * @param activity
	 * @return boolean
	 */
	public boolean isFull()throws BlablakidException {
		boolean full = false;
		if(next==this.activity.length) {
			full = true;
		}
		return full;
	}
		
	
	/**
	 * Comprueba la existencia de la actividad
	 * @param activity
	 * @return boolean
	 */
	public boolean existe(Activity activity)throws BlablakidException {
		boolean exist = false;
		if(buscar(activity.getName())!=null) {
			exist = true;
		}
		return exist;
	}

	/**
	 * Busca una actividad
	 * @param name
	 * @return Activity
	 */
	public Activity buscar(String name)throws BlablakidException {
		int contador = 0;
		Activity actividad = null;
		while((contador<this.next)&&(actividad==null)) {
			if(activity[contador].getName().equals(name)) {
				actividad = activity[contador];
			}
			contador ++;
		}
		return actividad;
	}
	/**
	 * ToString de la clase Activities
	 * @return String
	 */
	public String toString() {
		StringBuilder output = new StringBuilder();
		int i = 0;
		
		while(i<next) {
			if(activity[i]!=null) {
				output.append(this.activity[i].toString());
				output.append("\n");
			}
			i ++;
		}
		return output.toString();
	}

}


package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author defernv04
 *
 */
public class Parent {
	private String name;
	private Week days;
	private Kids kids;
	private Rides ride;
	private static final Logger logger= LogManager.getLogger(Parent.class);

	/**
	 * Constructor clase Parent
	 * @param name
	 * @param nif
	 * @throws BlablakidException 
	 */
	public Parent(String name, Week day, int numRides) throws BlablakidException {
		if(name.compareTo(" ")==0) {
			logger.error("Error in the name of the parent");
			throw new BlablakidException("Error in the name of the parent");
		}else {
			if(numRides <=0) {
				logger.error("Error in the number of rides");
				throw new BlablakidException("Error in the number of rides");
			}else {
				this.name = name;
				this.days = day;
				numRides=this.ride.length();
			}
		}
	}
	
	/**
	 * Constructor clase parent
	 * @param name
	 * @throws BlablakidException
	 */
	public Parent(String name) throws BlablakidException {
		if(name.compareTo(" ")==0) {
			logger.error("Error in the name of the parent");
			throw new BlablakidException("Error in the name of the parent");
		}else {
			this.name = name;
		}
	}
	
	/**
	 * Devuelve el nombre del padre
	 * @return
	 */
	String getName() {
		return this.name;
	}
	
	
	/**
	 * Metodo anyade un ride
	 * @return boolean: si ha sido anayadido true
	 */
	public boolean add (Ride ride) throws BlablakidException{
		boolean added = false;
		if (this.ride.existe(ride)) {
			added = true;
		}
		return added;
	}
	
	/**
	 * Metodo elimina un ride
	 * @return boolena: si ha sido elimidnado true
	 */
	public boolean remove (Ride ride) throws BlablakidException{
		boolean remove = false;
		if(this.ride.remove(ride)) {
			remove = true;
		}
		return remove;
	}
	
	
	/**
	 * ToString de la clase Parent
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append("### "+this.name+" ###");
		return output.toString();
	}

}


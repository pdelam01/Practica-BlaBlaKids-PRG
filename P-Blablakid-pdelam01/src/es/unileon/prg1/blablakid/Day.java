package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author defernv04
 */
public class Day {
	private WeekDays day;
	private Rides rides;
	private static final Logger logger= LogManager.getLogger(Day.class);
	private StringBuilder append;
	
	/**
	 * Constructor de la clase Day
	 * @param day
	 * @param maxRides
	 * @throws BlablakidException
	 */
	public Day(WeekDays day, int maxRides) throws BlablakidException {
		if (maxRides < 0) {
			logger.error("Error in the num of rides");
			throw new BlablakidException("Error in the num of rides");
		} else {
			this.day = day;
			this.rides = new Rides(maxRides);
		}
	}
	
	/**
	 * Metodo devuelve el tamanyo de los rides
	 * @return tamanyo de los rides
	 */
	public int getNumRides() {
		return this.rides.length();
	}
	
		
	/**
	 * Metodo devuelve dia (int) en String
	 * @param day
	 * @return output
	 */
	public String getNameDay (int day) throws BlablakidException {
		String output = " ";
		switch(day) {
		case 0:
			output = "MONDAY";
			break;
		case 1:
			output = "TUESDAY";
			break;
		case 2:
			output = "WEDNESDAY";
			break;
		case 3:
			output = "THURSDAY";
			break;
		case 4:
			output = "FRIDAY";
			break;
		default:
			logger.error("Error in the day");
			throw new BlablakidException("Error in the day");
		}
		return output;
		
	}
	
	
	/**
	 * Metodo toString clase Day
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		try {
			output.append(getNameDay(this.day.ordinal()));
		} catch (BlablakidException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return output.toString();	
	}


}


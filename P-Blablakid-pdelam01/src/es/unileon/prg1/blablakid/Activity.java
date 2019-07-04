package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author dfernv04
 *
 */
public class Activity {
	private String name;
	private String place;
	private int hourStart;
	private int minStart;
	private int hourEnd;
	private int minEnd;
	private WeekDays day;
	private static final Logger logger= LogManager.getLogger(Activity.class);
	

	/**
	 * @param name
	 * @param place
	 * @param hourStart
	 * @param hourFinish
	 * @return void
	 */
	public Activity(String name, String place, int hourStart, int minStart, int hourEnd, int minEnd, WeekDays day ) throws BlablakidException {
		if(name.compareTo(" ")==0) {
			logger.error("Error in the name of the activity");
			throw new BlablakidException("Error in the name of the activity");
		}else {
			if(place.compareTo(" ")==0) {
				logger.error("Error in the place of the activity");
				throw new BlablakidException("Error in the place of the activity");
			}else {
				if(hourStart>hourEnd) {
					logger.error("Error with the hours of the activity");
					throw new BlablakidException("Error with the hours of the activity");
				}else {
					if((hourStart==hourEnd)&&(minStart>=minEnd)) {
						logger.trace("Error with the hours of the activity");
						throw new BlablakidException("Error with the hours of the activity");
					}else {
						this.name = name;
						this.place = place;
						this.hourStart = hourStart;
						this.minStart = minStart;
						this.hourEnd = hourEnd;
						this.minEnd = minEnd;
						this.day = day;
					}
				}
			}
		}
		
	}
	
	/**
	 * Constructor clase Activity
	 * @param name
	 * @param day
	 * @throws BlablakidException
	 */
	public Activity(String name, WeekDays day) throws BlablakidException {
		if(name.compareTo(" ") == 0) {
			logger.error("Error in the name of the activity");
			throw new BlablakidException("Error in the name of the activity");
		}else {
			this.name = name;
			this.day = day;
		}
	}
	
	/**
	 * Obtiene el nombre de la actividad
	 * @return
	 */
	String getName() {
		return this.name;
	}
	
	/**
	 * Obtiene el lugar de la actividad
	 * @return
	 */
	String getPlace() {
		return this.place;
	}
	
	/**
	 * Obtiene la hora de inicio de la actividad
	 * @return
	 */
	int getHourStart() {
		return this.hourStart;
	}
	
	/**
	 * Obtiene el minuto de la hora de inicio de la actividad
	 * @return
	 */
	int getMinStart() {
		return this.minStart;
	}
	
	/**
	 * Obtiene la hora de fin de la actividad
	 * @return
	 */
	int getHourEnd() {
		return this.hourEnd;
	}
	
	/**
	 * Obtiene el minuto de la hora de fin de la actividad
	 * @return
	 */
	int getMinEnd() {
		return this.minEnd;
	}
	
	/**
	 * Obtiene el dia de la actividad
	 * @return
	 */
	WeekDays getDay() {
		return this.day;
	}

	

	/**
	 * toString clase Activity
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		
		salida.append(this.name);
		salida.append(" ("+this.place);
		salida.append(" - "+this.day+")");
		salida.append(this.hourStart+":"+this.minStart);
		salida.append(" > "+this.hourEnd+":"+this.minEnd);
		
		return salida.toString();
	}

}


package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author pdelam01
 *
 */

public class Ride {
	private String nameActivity;
	private WeekDays day;
	private String placeStart;
	private String placeEnd;
	private int hourStart;
	private int minStart;
	private int hourEnd;
	private int minEnd;
	private static final Logger logger= LogManager.getLogger(Ride.class);

	
	/**
	 * Constructor clase Ride
	 * @param parent
	 * @param place
	 * @param hour
	 * @return void
	 */
	public Ride(String nameActivity, WeekDays day, String placeStart, String placeEnd, int hourStart, int minStart,
			int hourEnd, int minEnd) throws BlablakidException {
		if (nameActivity == " ") {
			logger.error("Error in the name of the activity");
			throw new BlablakidException("Error in the name of the activity");
		} else {
			if (placeStart == " ") {
				logger.error("Error in the starting place");
				throw new BlablakidException("Error in the starting place");
			} else {
				if (placeEnd == " ") {
					logger.error("Error in the ending place");
					throw new BlablakidException("Error in the ending place");
				} else {
					if (placeStart == placeEnd) {
						logger.error("Error. The starting place and the ending place are the same.");
						throw new BlablakidException(
								"Error. The starting place and the ending place are the same.");
					} else {
						if (hourEnd < hourStart) {
							logger.error("Error. The initial time is smaller than the final hour.");
							throw new BlablakidException("Error. The initial time is smaller than the final hour.");
						} else {
							if ((hourStart == hourEnd) && (minStart >= minEnd)) {
								logger.error("Error in the time of the ride");
								throw new BlablakidException("Error in the time of the ride");
							} else {
								this.nameActivity = nameActivity;
								this.day = day;
								this.placeStart = placeStart;
								this.placeEnd = placeEnd;
								this.hourStart = hourStart;
								this.minStart = minStart;
								this.hourEnd = hourEnd;
								this.minEnd = minEnd;
							}
						}
					}
				}
			}
		}
	}
			
	/**
	 * Constructor clase Ride
	 * @param day
	 * @param placeStart
	 * @param placeEnd
	 * @throws BlablakidException
	 */
	public Ride(WeekDays day, String placeStart, String placeEnd)throws BlablakidException {
		if(placeStart.compareTo(" ")==0) {
			logger.error("Error in the starting place");
			throw new BlablakidException("Error in the starting place");
		}else {
			if(placeEnd.compareTo( " ")==0) {
				logger.error("Error in the ending place");
				throw new BlablakidException("Error in the ending place");
			}else {
				this.day = day;
				this.placeStart = placeStart;
				this.placeEnd = placeEnd;
			}
		}
	}
	
	/**
	 * Obtiene nombre actividad
	 * @return
	 */
	String getNameActivity() {
		return this.nameActivity;
	}
	
	/**
	 * Obtiene dia trayecto
	 * @return
	 */
	WeekDays getDay() {
		return this.day;
	}
	
	/**
	 * Obtiene lugar comienzo trayecto
	 * @return
	 */
	String getPlaceStart() {
		return this.placeStart;
	}
	
	/**
	 * Obtiene lugar final trayecto
	 * @return
	 */
	String getPlaceEnd() {
		return this.placeEnd;
	}
	
	/**
	 * Obtiene hora inicio trayecto
	 * @return
	 */
	int getHourStart() {
		return this.hourStart;
	}
	
	/**
	 * Obtiene min final trayecto
	 * @return
	 */
	int getMinStart() {
		return this.minStart;
	}
	
	/**
	 * Obtiene hora fin trayecto
	 * @return
	 */
	int getHourEnd() {
		return this.hourEnd;
	}
	
	/**
	 * Obtiene min final trayecto
	 * @return
	 */
	int getMinEnd() {
		return this.minEnd;
	}
	

	/**
	 * 	Metodo toString clase Ride
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder salida = new StringBuilder();
		
		salida.append(this.placeStart+" > "+this.placeEnd);
		salida.append(" : "+this.hourStart+":"+this.minStart);
		salida.append("/"+this.hourEnd+":"+this.minEnd);
		
		return salida.toString();
		
		
	}

}












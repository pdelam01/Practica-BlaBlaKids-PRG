package es.unileon.prg1.blablakid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author jflorc01
 *
 */
public class Rides {
	private Ride ride[];
	private int next;
	private static final Logger logger= LogManager.getLogger(Ride.class);
	
	/**
	 * Constructor clase Rides
	 * @param MAX_RIDES
	 */
	public Rides(int MAX_RIDES) {
		this.next = 0;
		this.ride = new Ride[MAX_RIDES];
	}

	/**
	 * Metodo anyade un trayecto
	 * @param ride
	 * @return boolean
	 */
	public boolean add(Ride ride) throws BlablakidException {

		boolean anyadir = false;

		if (isFull()) {
			logger.error("ERROR, the procces of adding a activity has failed");
			throw new BlablakidException("ERROR, the procces of adding a activity has failed");

		} else if (buscar(ride.getNameActivity(), ride.getDay(), ride.getPlaceStart(), ride.getPlaceEnd(),
				ride.getHourStart(), ride.getMinStart(), ride.getHourEnd(), ride.getMinEnd()) != null) {
			logger.error("ERROR, the procces of adding a ride has failed");
			throw new BlablakidException("ERROR, the procces of adding a ride has failed");

		} else {
			this.ride[next] = ride;
			next++;
			anyadir = true;
		}

		return anyadir;
	}

	/**
	 * Metodo elimina un trayecto
	 * @param ride
	 * @return boolean
	 */
	public boolean remove(Ride ride) throws BlablakidException {
		boolean aux = false;
		if (buscar(ride.getNameActivity(), ride.getDay(), ride.getPlaceStart(),
				ride.getPlaceEnd(), ride.getHourStart(), ride.getMinStart(), ride.getHourEnd(),
				ride.getMinEnd()) != null) {
			this.ride[next] = null;
			next--;
			for (int i = next; i < this.ride.length; i++) {
				this.ride[i] = this.ride[i++];
			}
			aux = true;
		} else {
			logger.error("ERROR, the procces of removing a ride has failed");
			throw new BlablakidException("ERROR, the procces of removing a ride has failed");
		}
		return aux;
	}
	
	/**
	 * Metodo comprueba un trayecto esta complento o no
	 * @return
	 * @throws BlablakidException
	 */
	public boolean isFull()throws BlablakidException {
		boolean full=false;
		if(next==ride.length){
			full=true;
		}
	return full;
	}

	/**
	 * 	Metodo existe un trayecto o no
	 * @param ride
	 * @return boolean
	 */
	public boolean existe(Ride ride) throws BlablakidException {
		boolean aux = false;
		if (buscar(ride.getNameActivity(), ride.getDay(), ride.getPlaceStart(),
				ride.getPlaceEnd(), ride.getHourStart(), ride.getMinStart(), ride.getHourEnd(),
				ride.getMinEnd()) != null) {
			aux = true;
		}
		return aux;
	}

	/**
	 * Metodo busca un trayecto
	 * @param name
	 * @return Ride
	 */
	public Ride buscar(String nameActivity, WeekDays day, String placeStart, String placeEnd, int hourStart,
			int minStart, int hourEnd, int minEnd) throws BlablakidException {
		int contador = 0;
		Ride buscarRide = null;

		while ((contador < this.next) && (buscarRide == null)) {
			if ((ride[contador].getNameActivity().equals(nameActivity)) && (ride[contador].getDay().equals(day))
					&& (ride[contador].getPlaceStart().equals(placeStart))
					&& (ride[contador].getHourStart() == hourStart) && (ride[contador].getMinStart() == minStart)
					&& (ride[contador].getHourEnd() == hourEnd) && (ride[contador].getMinEnd() == minEnd)) {
				buscarRide = ride[contador];
			}
			contador++;
		}
		return buscarRide;
	}
	
	/**
	 * Metodo devuelve longitud de ride
	 * @return
	 */
	public int length() {
		return this.ride.length;
	}
	
	/**
	 * Metodo toString de Rides
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		int i = 0;
		
		while(i<next) {
			output.append(this.ride[i].toString());
			output.append("\n");
			i ++;
		}
		
		return output.toString();
	}


}


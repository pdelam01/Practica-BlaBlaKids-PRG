package es.unileon.prg1.blablakid;

/**
 * 
 * @author pdelam01
 *
 */
public class Week {
	private WeekDays day[];
	final static int MAX_DAYS = 5;
	
	/**
	 * Constructor clase Week
	 */
	public Week() {
		this.day=new WeekDays [MAX_DAYS];	
	}
	
	/**
	 * Metodo toString clase Week
	 * @return String
	 */
	public String toString() {
		StringBuilder output = new StringBuilder();
		int i = 0;
		while(i<MAX_DAYS) {
			if(day[i]!=null) {
				output.append(day[i].toString());
				output.append("\n");
			}
			i++;
		}
		return output.toString();
	}
}

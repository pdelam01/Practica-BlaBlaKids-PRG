package es.unileon.prg1.blablakid;
/**
 * @author
 *
 */
public class Time {
	private int hourStart;
	private int minStart;
	private int hourEnd;
	private int minEnd;

	public Time (int hourStart, int minStart, int hourEnd, int minEnd) {
		this.hourStart=hourStart;
		this.minStart=minStart;
		this.hourEnd=hourEnd;
		this.minEnd=minEnd;
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("The activity starts at: "+hourStart+":"+minStart);
		output.append("The activity ends at: "+hourEnd+":"+minEnd);
		return output.toString();
	}
}


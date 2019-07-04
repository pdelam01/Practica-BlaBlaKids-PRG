package es.unileon.prg1.blablakid;

public class MainBlablakid {
	public static void main (String[] args) throws BlablakidException {
		int num;
		if(args.length!=1) {
			System.out.println("ERROR, I need 1 argument");
		}
		else {
			try {
				num = Integer.parseInt(args[0]);
				Blablakid blablakid = new Blablakid(num);
				TextUI textUI = new TextUI(blablakid);
				textUI.start();
			}	
			catch(NumberFormatException e) {
				System.out.println("ERROR, Incorrect number format");
			}
		}
	}
}

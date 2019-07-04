package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author
 *
 */
public class Blablakid {
	private Kids kids;
	private Parents parents;
	private static final Logger logger= LogManager.getLogger(Blablakid.class);
	
	public Blablakid(int maxKids) {
		this.kids = new Kids(maxKids);
		this.parents = new Parents(maxKids*2);
	}
	
	public void add(Kid kid) throws BlablakidException {
		this.kids.add(kid);
	}
	
	public void remove(Kid kid) throws BlablakidException{
		this.kids.remove(kid);
	}
	
	public void add(Parent parent) throws BlablakidException{
		this.parents.add(parent);
	}
	
	public void remove(Parent parent) throws BlablakidException{
		this.parents.remove(parent);
	}
	
	
	public void add(Activity activity, String kidName)throws BlablakidException{
		Kid kid;
		kid = this.kids.buscar(kidName);
		if(kid!=null) {
			kid.add(activity);
		}else {
			throw new BlablakidException("Error, the kid does not exist");
		}
	}
	
	public void remove(Activity activity, String kidName)throws BlablakidException{
		Kid kid;
		kid = this.kids.buscar(kidName);
		if(kid == null) {
			logger.error("Error the kid does not exist");
			throw new BlablakidException("Error the kid does not exist");
		}else {
			logger.info("Activity removed");
			kid.remove(activity);
		}
		
	}
	
	
	public void add(Ride ride, String kidName, String parentName)throws BlablakidException {
		Kid kid;
		kid = this.kids.buscar(kidName);
		Parent parent;
		parent = this.parents.buscar(parentName);
		if(kid == null) {
			logger.error("Error the kid does not exist");
			throw new BlablakidException("Error the kid does not exist");
		}else {
			if(parent == null) {
				logger.error("Error the parent does not exist");
				throw new BlablakidException("Error the parent does not exist");
			}else {
				logger.info("Ride added");
				parent.add(ride);
			}
		}
	}
	
	public void remove(Ride ride, String parentName)throws BlablakidException {
		Parent parent;
		parent = this.parents.buscar(parentName);
		if(parent == null) {
			logger.error("Error the parent does not exist");
			throw new BlablakidException("Error the parent does not exist");
		}else {
			logger.info("Ride removed");
			parent.remove(ride);
		}
	}
	
	
	/**
	 * @param 
	 * @return String
	 */
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		
		output.append(this.kids.toString());
		output.append(this.parents.toString());
		
		return output.toString();
	}
	
	
	
}


package es.unileon.prg1.blablakid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author defernv04
 *
 */
public class Kids {
	private Kid  kid[];
	private int next;
	private static final Logger logger= LogManager.getLogger(Kids.class);

	/**
	 * Constructor de kids
	 * @param MAX_KIDS
	 */
	public Kids (int MAX_KIDS) {
		this.next=0;
		this.kid= new Kid [MAX_KIDS];
	}

	/**Metodo anyade un ninio
	 * @param 
	 * @return devuelve true si se ha podido anyadir al kid y false en caso contrario
	 */
	public boolean add(Kid kid) throws BlablakidException {
		boolean anyadir = false;
		if(isFull()) {
			logger.error("ERROR, the procces of adding a activity has failed");
			throw new BlablakidException("ERROR, the procces of adding a activity has failed");
			
		}else if(buscar(kid.getName())!=null) {
			logger.error("ERROR, the procces of adding a activity has failed");
				throw new BlablakidException("ERROR, the procces of adding a activity has failed");
					
		}else {
			this.kid[next] = kid;
				next++;
				anyadir = true;
		}
		
	return anyadir;
	}
	
	

	/**
	 * Metodo borra un ninio
	 * @param kid
	 * @return  devuelve true si se ha podido eliminar al kid y false en caso contrario
	 */
	public boolean remove(Kid kid) throws BlablakidException {
		boolean aux=false;
		if(buscar(kid.getName())!=null) {
			this.kid[next]=null;
			next --;
			for(int i=next; i<this.kid.length; i++) {
				this.kid[i]=this.kid[i++];

			}
			aux=true;
			
		}else {
			logger.error("ERROR, the procces of removing a kid has failed");
			throw new BlablakidException("ERROR, the procces of removing a kid has failed");
		}
		return aux;
	}

	/**
	 * Metodo comprueba esta lleno 
	 * @return  devuelve true si se array de kids esta lleno y falso si caben mas
	 */
	public boolean isFull()throws BlablakidException{
		boolean full=false;
		//Llamamos al MAX_KIDS con el kid.length
		if(next==kid.length){
			full=true;
		}
	return full;
	}

	/**
	 * Metodo comprueba existe un ninio
	 * @param kid
	 * @return devuelve true si el kid pasado ya existe en el array de kids
	 */
	public boolean existe(Kid kid)throws BlablakidException {
		boolean aux=false;
		if(buscar(kid.getName())!=null) {
			aux=true;
		}
		return aux;
	}

	/**
	 * Metodo busca un ninio
	 * @param name
	 * @return devuelve un Kid si el nombre pasado se corresponde con un kid ya existente en el array de kids
	 */
	public Kid buscar(String name)throws BlablakidException {
		int contador=0;
		Kid kidbuscar = null;
		
		while((contador<this.next) && (kidbuscar==null)) {
			if(kid[contador].getName().equals(name)) {
				kidbuscar=kid[contador];
			}
			contador++;
		}
		return kidbuscar;
	}
	
	/**
	 * ToString clase KIds
	 */
	public String toString() {
		StringBuilder output = new StringBuilder();
		int i = 0;
		output.append("/////////////\n");
		output.append("KIDS: \n");
		while(i<next) {
			
			if(kid[i]!=null) {
				output.append(kid[i].toString());
				output.append("\n");
			}
			
			i++;
		}
		return output.toString();
	}
	
	
}


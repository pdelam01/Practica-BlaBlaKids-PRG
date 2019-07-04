package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * @author jflorc01
 *
 */
public class Parents {
	private Parent  parent [];
	private int next;
	private static final Logger logger= LogManager.getLogger(Parents.class);

	public Parents(int MAX_PARENT) {
		this.next = 0;
		this.parent = new Parent [MAX_PARENT];
	}

	/**
	 * Anyade un parent
	 * @param parent
	 * @return boolean
	 */
	public boolean add(Parent parent)throws BlablakidException {
		boolean anyadir = false;
		if(isFull()) {
			logger.error("ERROR, the procces of adding a activity has failed");
			throw new BlablakidException("ERROR, the procces of adding a activity has failed");		
		}else if(buscar(parent.getName())!=null) {
			logger.error("ERROR, the procces of adding a activity has failed");
				throw new BlablakidException("ERROR, the procces of adding a activity has failed");	
		}else {
			logger.info("Parent added");
			this.parent[next] = parent;
			next++;
			anyadir = true;
		}
	return anyadir;
	}

	/**
	 * Elimina un parent
	 * @param parent
	 * @return boolean
	 */
	public boolean remove(Parent parent)throws BlablakidException {
		boolean aux = false;
		if(buscar(parent.getName())!=null) {
			this.parent[next]=null;
			next --;
			for(int i=next; i<this.parent.length-1; i++) {
				this.parent[i] = this.parent[i+1]; 
			}
			aux=true;
			logger.info("Parent removed");
		}else {
			logger.error("ERROR, the procces of removing a parent has failed");
			throw new BlablakidException("ERROR, the procces of removing a parent has failed");
		}
		return aux;
	}

	/**
	 * Comprueba si el array esta lleno
	 * @return boolean
	 */
	public boolean isFull()throws BlablakidException {
		boolean full=false;
		//Llamamos al MAX_PARENT con el parent.length
		if(next==parent.length){
			full=true;
		}
	return full;
	}

	/**
	 * Comprueba si existe el parent
	 * @param parent
	 * @return boolean
	 */
	public boolean existe(Parent parent)throws BlablakidException {
		boolean aux = false;
		if(buscar(parent.getName())!=null) {
			aux = true;
		}
		return aux;
	}

	/**
	 * Busca el parent
	 * @param name
	 * @return Parent
	 */
	public Parent buscar(String name)throws BlablakidException {
		int contador=0;
		Parent parentbuscar = null;
		
		while((contador<this.next) && (parentbuscar==null)) {
			if(parent[contador].getName().equals(name)) {
				parentbuscar=parent[contador];
			}
			contador++;
		}
		return parentbuscar;
	}
	
	/*
	 * ToString de la clase Parents
	 * @return String
	 */
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append("PARENTS: \n");
		
		int i = 0;
		while(i<next) {
			if(parent[i]!=null) {
				output.append(parent[i].toString());
				output.append("\n");
			}
			i++;
		}
		output.append("/////////////\n");
		
		return output.toString();
	}
}


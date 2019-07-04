package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TextUI {
	private Blablakid blablakid;
	private static final Logger logger= LogManager.getLogger(TextUI.class);
	
	/**
	 * Constructor de la clase
	 * @param blablakid
	 */
	public TextUI (Blablakid blablakid) {
		this.blablakid=blablakid;
	}
	
	public void start() throws BlablakidException{
		int option;
		
		do {
			logger.info("Show summary");
			showSummary();
			logger.info("Show Menu");
			menu();
			logger.info("Select an option");
			option=selectOption();
			action(option);
		}while(option!=0);
		logger.info("Exit app Blablakid");
	}
	
	/**
	 * Metodo muestra el menu de la aplicacion
	 */
	public void menu() {
		System.out.println("\r\n" + 
				"  ____  _       ____  _       _  ___     _     \r\n" + 
				" |  _ \\| |     |  _ \\| |     | |/ (_)   | |    \r\n" + 
				" | |_) | | __ _| |_) | | __ _| ' / _  __| |___ \r\n" + 
				" |  _ <| |/ _` |  _ <| |/ _` |  < | |/ _` / __|\r\n" + 
				" | |_) | | (_| | |_) | | (_| | . \\| | (_| \\__ \\\r\n" + 
				" |____/|_|\\__,_|____/|_|\\__,_|_|\\_\\_|\\__,_|___/       \r\n" + 
				"                                               \r\n" + 
				"                                               \r\n");		
		System.out.println("Select an option:");
		System.out.println(" 1 - Add kid");
		System.out.println(" 2 - Remove kid");
		System.out.println(" 3 - Add parent");
		System.out.println(" 4 - Remove parent");
		System.out.println(" 5 - Add activity");
		System.out.println(" 6 - Remove activity");
		System.out.println(" 7 - Add ride");
		System.out.println(" 8 - Remove ride");
		System.out.println(" 9 - Show summary");
		System.out.println(" 10 - Check status");
		System.out.println(" 0 - Exit");
	}
	
	/**
	 * Metodo lee el int que ha sido pedido en el metodo Menu
	 * @return opcion introducida por teclado
	 */
	public int selectOption() {
		int option;
		option=Teclado.readInteger();
		return option;
	}
	
	/**
	 * Metodo pide el nombre del ninio al usuario y lo anyade
	 * @return	kid: ninio anyadido
	 * @throws BlablakidException
	 */
	public Kid askAddKid() throws BlablakidException {
		String kidName;
		System.out.println("What's the name of the kid?: ");
		kidName=Teclado.readString();
		
		Kid kid = new Kid (kidName);
		return kid;
	}
	
	/**
	 * Metodo pide el nombre del ninio al usuario y lo borra
	 * @return	kid: ninio eliminado
	 * @throws BlablakidException
	 */
	public Kid askRemoveKid() throws BlablakidException {
		String kidName;
		System.out.println("Name of the kid to remove: ");
		kidName=Teclado.readString();
		
		Kid kid = new Kid (kidName);
		return kid;
	}
	
	/**
	 * Metodo pide el nombre del padre/madre al usuario y lo anyade
	 * @return	parent: parent anyadido
	 * @throws BlablakidException
	 */
	public Parent askAddParent() throws BlablakidException{
		String parentName;
		int parentKids;
		int  parentRides;
		String kidNames[];
		
		System.out.println("What's the name of the parent? ");
		parentName=Teclado.readString();
			
		System.out.println("How many kids does "+parentName+" have? ");
		parentKids=Teclado.readInteger();
			
		System.out.println("How many rides can "+parentName+" make per day? ");
		parentRides=Teclado.readInteger();
			
		kidNames = new String[parentKids];
		for(int i=0;i<parentKids;i++) {
			System.out.println("Who is "+parentName+" kid number 0"+i+"?");
			kidNames[i] = Teclado.readString();
		}
		
		Parent parent = new Parent (parentName);
		return parent;
	}
	
	/**
	 * Metodo pide el nombre del padre/madre al usuario y lo borra
	 * @return	parent: parent eliminado
	 * @throws BlablakidException
	 */
	public Parent askRemoveParent() throws BlablakidException{
		String parentName;
		System.out.println("Name of the parent to remove: ");
		parentName=Teclado.readString();
		
		Parent parent = new Parent (parentName);
		return parent;
	}
	
	/**
	 * Metodo pide el nombre del ninio a anyadir y lo pasa a la clase Blablakid
	 * @return	kidName: nombre del ninio a anyadir
	 */
	public String kidNameAdd() {
		String kidName;
		System.out.println("Name of the kid taking the activity");
		kidName=Teclado.readString();
		
		return kidName;
	}
	
	/**
	 * Metodo pide al usuario varios parametros con el objeto de anyadir una acividad
	 * @return	activity: actividad anyadida
	 * @throws BlablakidException
	 */
	public Activity askAddActivity() throws BlablakidException{
		String actName;
		System.out.println("Name of the activity: ");
		actName=Teclado.readString();
		
		String placeAct;
		System.out.println("Where does the activity "+actName+" takes place? ");
		placeAct=Teclado.readString();
		
		int dayAct;
		do{
			StringBuffer cadena = new StringBuffer();
			cadena.append("Day of the week for the activity: ");
			cadena.append("Insert the number of the day of the week: ");
			cadena.append("0-Monday / 1-Tuesday / 2-Wendnesday / 3-Thursday / 4-Friday");
			System.out.println(cadena);
			dayAct=Teclado.readInteger();
			if(dayAct<0 || dayAct>4){
				System.out.println("ERROR! You must insert a number between 0-4!");
			}
		}while(dayAct<0 || dayAct>4);
		
		WeekDays day = day(dayAct);
		
		System.out.println("When does de activity start? ");
		int hourStart = hour();
		int minStart = min();
	
		System.out.println("When does de activity end? ");
		int hourEnd = hour();
		int minEnd = min();
		
		Activity activity = new Activity(actName, placeAct, hourStart, minStart,hourEnd,minEnd,day);
		return activity;
		
	}
	
	/**
	 * Metodo pide el nombre del ninio a eliminar y lo pasa a la clase Blablakid
	 * @return	kidName: nombre del ninio a eliminar
	 */
	public String kidNameRemove() {
		String kidName;
		System.out.println("Name of the kid taking the activity: ");
		kidName=Teclado.readString();
		
		return kidName;
	}	
	
	/**
	 * Metodo borra una actividad
	 * @return activity: actividad eliminada
	 * @throws BlablakidException
	 */
	public Activity askRemoveActivity() throws BlablakidException{
		String actName;
		System.out.println("Name of the activty to remove: ");
		actName=Teclado.readString();
		
		int dayAct;
		do{
			StringBuffer cadena = new StringBuffer();
			cadena.append("Day of the week for the activity: ");
			cadena.append("Insert the number of the day of the week: ");
			cadena.append("0-Monday / 1-Tuesday / 2-Wendnesday / 3-Thursday / 4-Friday");
			System.out.println(cadena);
			dayAct=Teclado.readInteger();
			if(dayAct<0 || dayAct>4){
				System.out.println("ERROR! You must insert a number between 0-4!");
			}
		}while(dayAct<0 || dayAct>4);
		
		WeekDays day = day(dayAct);
		
		Activity activity = new Activity(actName,day);
		return activity;
	}
	
	/**
	 * Metodo pide el nombre del padre/madre a anyadir y lo pasa a la clase Blablakid
	 * @return	parentName: nombre del parent a anyadir
	 */
	public String parentNameAdd() {
		String parentName;
		System.out.println("Name of the parent taking the ride: ");
		parentName=Teclado.readString();
		
		return parentName;
	}
	
	
	/**
	 * Metodo pide al usuario varios parametros con el objeto de anyadir un trayecto
	 * @return	ride: trayecto a anyadir
	 * @throws BlablakidException
	 */
	public Ride askAddRide()throws BlablakidException{		
		String nameActivity;
		System.out.println("Name of the activity of the ride: ");
		nameActivity=Teclado.readString();
		
		String rideStartPlace;
		System.out.println("Where does the ride start? ");
		rideStartPlace=Teclado.readString();
		
		String rideEndPlace;
		System.out.println("Where does the ride end? ");
		rideEndPlace=Teclado.readString();
		
		System.out.println("When does de ride start? ");
		int hourRideStart = hour();
		int minRideStart = min();
		
		System.out.println("When does the ride end? ");
		int hourRideEnd = hour();
		int minRideEnd = min();
		
		
		int dayRide;
		do{
			StringBuffer cadena1 = new StringBuffer();
			cadena1.append("Day of the week for the activity: ");
			cadena1.append("Insert the number of the day of the week: ");
			cadena1.append("0-Monday / 1-Tuesday / 2-Wendnesday / 3-Thursday / 4-Friday");
			System.out.println(cadena1);
			dayRide=Teclado.readInteger();	
			if(dayRide<0 || dayRide>4){
				System.out.println("ERROR! You must insert a number between 0-4!");
			}
		}while(dayRide<0 || dayRide>4);
		
		WeekDays day = day(dayRide);
		
		Ride ride = new Ride (nameActivity,day,rideStartPlace,rideEndPlace,hourRideStart,minRideStart,hourRideEnd,minRideEnd);
		return ride;
		
	}
	
	/**
	 * Metodo pide el nombre del padre/madre a eliminar y lo pasa a la clase Blablakid
	 * @return	parentName: nombre del parent a anyadir
	 */
	public String parentNameRemove() {
		String parentName;
		System.out.println("Name of the parent to remove the activity: ");
		parentName=Teclado.readString();
		
		return parentName;
	}
	
	/**
	 * Metodo borra un trayecto
	 * @return	ride: trayecto eliminado
	 * @throws BlablakidException
	 */
	public Ride askRemoveRide() throws BlablakidException{
		
		int dayRide;
		do{
			StringBuffer cadena1 = new StringBuffer();
			cadena1.append("Day of the week for the activity: ");
			cadena1.append("Insert the number of the day of the week: ");
			cadena1.append("0-Monday / 1-Tuesday / 2-Wendnesday / 3-Thursday / 4-Friday");
			System.out.println(cadena1);
			dayRide=Teclado.readInteger();	
			if(dayRide<0 || dayRide>4){
				System.out.println("ERROR! You must insert a number between 0-4!");
			}
		}while(dayRide<0 || dayRide>4);
		
		WeekDays day = day(dayRide);
		
		String rideStartPlace;
		System.out.println("Where does the ride start? ");
		rideStartPlace=Teclado.readString();
		
		String rideEndPlace;
		System.out.println("Where does the ride end? ");
		rideEndPlace=Teclado.readString();
		
		Ride ride = new Ride (day,rideStartPlace,rideEndPlace);
		return ride;
	}
	
	/**
	 * Metodo
	 */
	public void checkStatus() throws BlablakidException{
		
	}
	
	/**
	 * Metodo
	 */
	public void showSummary() throws BlablakidException{
		System.out.println(this.blablakid.toString());
		logger.info(this.blablakid.toString());
	}
	
	/**
	 * Metodo que dependiendo del valor de option dirige a los distintos metodos
	 * @param option: recibe la opcion que el usuario mete poor teclado
	 * @throws BlablakidException 
	 */
	public void action (int option) throws BlablakidException {
		switch(option) {
			case 1:
				this.blablakid.add(this.askAddKid());
				logger.info("Add a kid");
				break;
			case 2:
				this.blablakid.remove(this.askRemoveKid());
				logger.info("Remove a kid");
				break;
			case 3:
				this.blablakid.add(this.askAddParent());
				logger.info("Add a parent");
				break;
			case 4:
				this.blablakid.remove(this.askRemoveParent());
				logger.info("Remove a parent");
				break;
			case 5:
				this.blablakid.add(this.askAddActivity(),kidNameAdd());
				logger.info("Add an activity");
				break;
			case 6:
				this.blablakid.remove(this.askRemoveActivity(),kidNameRemove());
				logger.info("Remove an activity");
				break;
			case 7:
				this.blablakid.add(askAddRide(), kidNameAdd(),parentNameAdd());
				logger.info("Add a ride");
				break;
			case 8:
				this.blablakid.remove(this.askRemoveRide(),parentNameRemove());
				logger.info("Remove a ride");
				break;
			case 9:
				showSummary();
				break;
			case 10:
				checkStatus();
				break;				
			case 0:		
				logger.info("Thanks for using Blablakids, hope to see you soon!");
				System.out.println("Thanks for using Blablakids, hope to see you soon!");
				break;
			default:
				logger.info("ERROR. You have made a wrong selection. Please try again!");
				System.out.println("ERROR. You have made a wrong selection. Please try again!");
		}
	}
	
	/**
	 * Metodo que pide al usuario introducir una hora del 00-23 
	 * y verifica que no esta fuera de rango 00-23
	 * @return	hour: hora introducida por el usuario
	 */
	public int hour() {
		int hour;
		do {
			System.out.println("Insert hour: ");
			hour=Teclado.readInteger();
			if(hour<0 || hour>23) {
				System.out.println("ERROR! You must insert a hour between 00-23!");
				logger.error("ERROR! You must insert a hour between 00-23!");
			}
		}while(hour<0 || hour>23);
		return  hour;
	}
	
	
	/**
	 * Metodo pide al usuario introducir minutos del 00-59
	 * y verifica que no esta fuera de rango 00-59
	 * @return min: minuto introducido por el usuario
	 */
	public int min() {
		int min;
		do {
			System.out.println("Insert minute: ");
			min=Teclado.readInteger();
			if(min<0 || min>59) {
				System.out.println("ERROR! You must insert a minute between 00-59!");
				logger.error("ERROR! You must insert a minute between 00-59!");
			}
		}while(min<0 || min>59);
		return min;
	}
	
	/**
	 * Metodo pasa el dia introducido como numero a letra
	 * @param day: dia introducido por el usuario
	 * @return dayOfWeek: dia de la semana 
	 */
	public WeekDays day(int day) {
		WeekDays dayOfWeek;
		switch (day) {
		case 0:
			dayOfWeek = WeekDays.MONDAY;
			break;
		case 1:
			dayOfWeek = WeekDays.TUESDAY;
			break;
		case 2:
			dayOfWeek = WeekDays.WEDNESDAY;
			break;
		case 3:
			dayOfWeek = WeekDays.THURSDAY;
			break;
		default:
			dayOfWeek = WeekDays.FRIDAY;
			break;
		}
		return dayOfWeek;	
	}
	
	
}

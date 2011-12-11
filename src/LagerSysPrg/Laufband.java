package LagerSysPrg;


/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 01-Jun-2011 15:44:59
 */
public class Laufband {

	public Motor s_L_Motor;
	public Motor L_Motor;
	
	private boolean Zustand;
	
	String Addresse;

	public Laufband(String LAdd, String mAdd){
		System.out.println("Sim: Laufband "+LAdd+" erstellt");
		s_L_Motor= new Simulation.Motor(mAdd);
	}
	
	public Laufband(){
		System.out.println("Laufband");
		L_Motor= new Motor();
	}

	/**
	 * 
	 * @exception Throwable Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public void vor(){

	}

	public void zurueck(){

	}

}
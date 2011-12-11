package Simulation;
import java.lang.Thread; 
/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 01-Jul-2011 15:44:59
 */
//public class Taster extends LagerSysPrg.Taster implements Runnable{
public class Taster extends Thread{
	private String Adresse;
	public boolean zustand= false;
	int time;

	public Taster(String T_Add, int stime){
		Adresse=T_Add;
		time=stime;
	}
	public void finalize() throws Throwable {

	}
	public void gedrueckt(){
		zustand = true;
		System.out.println("Taster "+Adresse+": gedrueckt");

	}

	public boolean geloest(){
		zustand = false;
		System.out.println("Taster "+Adresse+": geloest");
		return zustand;
	}

	public void run() {
		System.out.println("Taster "+Adresse+": wird nach "+time+" mSec gedrueckt");
	        try {
	          Thread.sleep(time);
	        }
	        catch(InterruptedException e) {
	        }
	        
	        gedrueckt();
	        
	      }
	
}
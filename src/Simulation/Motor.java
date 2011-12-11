package Simulation;
import LagerSysPrg.*;
/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 10-Jun-2011 15:44:59
 */
public class Motor extends LagerSysPrg.Motor implements Runnable{
	boolean running = false;

	private String address;
	
	//public Motor(){}
	public Motor(String add){	
		this.address=add;
		System.out.println("Sim: Motor "+add+" erstellt");
	}

	public void Aus(){
		System.out.println("Sim: Motor "+address+" : Aus");
		running = false;
	}
	public void Ein(char richtung){
		System.out.println("Sim: Motor "+address+" : : Ein");
		SetRichtung(richtung);
		//super.start();
	}
	public void SetRichtung(char richtung){
		if (richtung == 'r'){
			System.out.println("Sim: Motor "+address+" : Richtung Rechts");
		}
		if (richtung == 'l'){
			System.out.println("Sim: Motor "+address+" : Richtung links");
		}
	}
	public void run() {
        	System.out.println("Sim: Motor "+address+" :  Run");
			running = true;
	     	while (running == true){
	        //System.out.println("Motor Run");
			}
	    }

}
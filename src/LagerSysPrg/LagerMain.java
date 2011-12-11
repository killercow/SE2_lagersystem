/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 01-Jun-2011 15:44:59
 */
package LagerSysPrg;

import LagerSysGui.*;
import Simulation.*;
//import Simulation.Motor;
import Hardware.*;

public class LagerMain {

	/**
	 * @param args
	 */
	//public Stapler S1= new Stapler();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Sim="sim";
		LagerSysFrame frame = new LagerSysFrame("LagerSYSGui");
		Hardware H1 = new Hardware();
		if (Sim.equals("sim")){
			Init start = new Init(Sim);
			//Stapler S1 =new Stapler();
		
		}else {
			//LagerSysPrg.Motor motor = new LagerSysPrg.Motor();
			//Stapler S1 = new Stapler (motor);
			
		}
	}

}

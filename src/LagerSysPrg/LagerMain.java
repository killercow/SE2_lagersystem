package LagerSysPrg;

import LagerSysGui.*;
import Simulation.*;

public class LagerMain {

	/**
	 * @param args
	 */
	//public Stapler S1= new Stapler();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Sim="sim";
		LagerSysFrame frame = new LagerSysFrame("LagerSYSGui");
		if (Sim.equals("sim")){
			Init start = new Init(Sim);
			//Stapler S1 =new Stapler();
		
		}else {
			//LagerSysPrg.Motor motor = new LagerSysPrg.Motor();
			//Stapler S1 = new Stapler (motor);
			
		}
	}

}

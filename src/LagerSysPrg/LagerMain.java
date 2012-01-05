package LagerSysPrg;

import LagerSysGui.*;
import Simulation.*;

public class LagerMain {
	public static Init init; 
	
	public static void main(String[] args) {
		init = new Init();
		init.ErstelleLagerRaum(); 
	}

}

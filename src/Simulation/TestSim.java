package Simulation;
import LagerSysPrg.*;
/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 01-Jul-2011 15:44:59
 */
public class TestSim{
	static Motor StMotorX = new Simulation.Motor("X1");
	public static simLagplatz LP1, LP2,LP3;
	
	public TestSim(){ 
		LP1 = new simLagplatz("taster1", "Taster2","LP1",5000,9000); 
		LP2 = new simLagplatz("taster3", "Taster4","LP2",10000,14000);
		LP3 = new simLagplatz("taster5", "Taster6","LP3",15000,19000);
	}
	public static void fahre(simLagplatz L1){
		//StMotorX.Ein('r');
		
		new Thread(StMotorX).start();	
		L1.T1.start();
		
		/*new Thread(L1.T1).start();
		Thread thread2 = new Thread(StMotorX);
		Thread thread = new Thread(L1.T1);
		thread.start();
		thread2.start();
		*/
		
		try
	    {		
			L1.T1.join();
			System.out.println("bin in try");
			//new Thread(L1.T1).join();
			//thread.join();
			//thread2.join();
			
			
	    }
	    catch(InterruptedException ie){}
		if (L1.T1.zustand == true){
			StMotorX.Aus();
			System.out.println("Lagerplatz "+L1.name+" erreicht");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		/*simLagplatz LP1 = new simLagplatz("taster1", "Taster2","LP1",5000,9000); 
		simLagplatz LP2 = new simLagplatz("taster3", "Taster4","LP2",10000,14000);
		simLagplatz LP3 = new simLagplatz("taster5", "Taster6","LP3",15000,19000);
		*/
		TestSim TS1 = new TestSim();
		
		fahre(LP1);

	}
}

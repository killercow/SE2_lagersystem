/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 01-Jul-2011 15:44:59
 */
package Simulation;

public class simLagplatz {
	public Taster T1;
	public Taster T2;
	protected String name;
	
	simLagplatz(String t1, String t2, String N, int Z1, int Z2){
		this.name=N;
		 T1 = new Simulation.Taster(t1,Z1); // Der Taster wird nach 5 Sec gedrückt
		 T2 = new Simulation.Taster(t2,Z2);
	}
	
}

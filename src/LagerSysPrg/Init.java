/**
 * @author Tanveer Ahmed s680338
 * @version 1.0
 * @created 01-Jun-2011 15:44:59
 */
package LagerSysPrg;

import Simulation.simLagplatz;

public class Init {
	public  Stapler S1;
	public  Lagerplatz LP1 ; 
	public  Lagerplatz LP2 ;
	public  Lagerplatz LP3 ;
	
	public EinAusgPlatz EAPlatz;
	public KlappenTür KT;
	
	public Init(String S){
		System.out.println("Starte Init als "+ S);
		S1 =new Stapler("Stapler","Stapler_Mx","Stapler_My","Laufband", "Laufband_M");
		
		// nur zum probieren 
		LP1 = new Lagerplatz("taster1", "Taster2","LP1",5000,9000); 
		LP2 = new Lagerplatz("taster3", "Taster4","LP2",10000,14000); 
		LP3 = new Lagerplatz("taster5", "Taster6","LP3",15000,19000); 
		
		EAPlatz = new EinAusgPlatz("EAPlatz","EABodenrampe", "EABR_Motor","EABR_TO","EABR_TU");
		// Tür noch nicht erstellt
	}
}

package LagerSysPrg;

import Simulation.*;

public class Init {
	public  Stapler S1;
	public  Lagerplatz LP1 ; 
	public  Lagerplatz LP2 ;
	public  Lagerplatz LP3 ;
	
	public EinAusgPlatz EAPlatz;
	public KlappenTuer KT;
	
	public Init(String S){
		System.out.println("Starte Init als "+ S);
		//S1 =new Stapler();
		
		// nur zum probieren 
		//LP1 = new Lagerplatz(); 
		//LP2 = new Lagerplatz(); 
		//LP3 = new Lagerplatz(); 
		
		EAPlatz = new EinAusgPlatz();
		// Tür noch nicht erstellt
	}
}

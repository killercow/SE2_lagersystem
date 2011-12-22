package Simulation;

public class aktiv implements ITasterZustand {

	private TasterZustand Zustand; 
	
	public aktiv(TasterZustand tasterzustand){
		Zustand = tasterzustand;  
	}

	public void aktiv() {
		System.out.println("Taster ist bereits aktiv!"); 
	}

	public void inaktiv() {
		System.out.println("Taster wird inaktiv gestellt!"); 
		Zustand.setzeAktuellenZustand(new aktiv(Zustand)); 
		Zustand.setStatus(0); 
		
	}
}

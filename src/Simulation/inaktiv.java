package Simulation;

public class inaktiv implements ITasterZustand {

private TasterZustand Zustand; 
	
	public inaktiv(TasterZustand tasterzustand){
		Zustand = tasterzustand;  
	}

	public void aktiv() {
		System.out.println("TasterZustand: TasterZustand: Taster wird aktiv gestellt!"); 
		Zustand.setzeAktuellenZustand(new aktiv(Zustand)); 
		Zustand.setStatus(1); 
	}

	public void inaktiv() {
		System.out.println("TasterZustand: TasterZustand: Taster ist bereits inaktiv!"); 		
	}
}

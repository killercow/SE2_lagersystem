package LagerSysPrg;

public class gerade implements IBodenRampeZustand {

	private ZustandRampe Zustand; 
	
	public gerade(ZustandRampe bodenRampenZustand){
		Zustand = bodenRampenZustand;  
	}

	public void gerade() {
		System.out.println("BodenRampe ist bereits gerade!"); 
	}

	public void schraeg() {
		System.out.println("BodenRampe kann nicht nach oben bewegt werden!"); 
		
	}

	public void stoppen() {
		System.out.println("BodenRampe wird gestoppt"); 
		Zustand.setzeAktuellenZustand(new steht(Zustand)); 
		Zustand.setStatus(0); 
	}

}
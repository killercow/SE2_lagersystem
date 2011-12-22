package LagerSysPrg;

public class schraeg extends ZustandRampe {

private ZustandRampe Zustand; 
	
	public schraeg(ZustandRampe bodenRampenZustand){
		Zustand = bodenRampenZustand;  
	}

	public void gerade() {
		System.out.println("BodenRampe kann nicht nach unten bewegt werden!"); 
	}

	public void schraeg() {
		System.out.println("BodenRampe ist bereits oben!"); 
		
	}

	public void stoppen() {
		System.out.println("BodenRampe wird gestoppt"); 
		Zustand.setzeAktuellenZustand(new steht(Zustand)); 
		Zustand.setStatus(0); 
	}

}
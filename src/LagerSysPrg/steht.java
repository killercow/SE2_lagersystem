package LagerSysPrg;

public class steht implements IBodenRampeZustand {

private ZustandRampe Zustand; 
	
	public steht(ZustandRampe bodenrampezustand){
		Zustand = bodenrampezustand;  
	}

	public void gerade() {
		System.out.println("BodenRampe ist bereits gerade!"); 
		Zustand.setzeAktuellenZustand(new gerade(Zustand));
		Zustand.setStatus(1); 
		
	}

	public void schraeg() {
		System.out.println("BodenRampe wird angehoben!"); 
		Zustand.setzeAktuellenZustand(new schraeg(Zustand));
		Zustand.setStatus(2); 
		
	}

	public void stoppen() {
		System.out.println("BodenRampe steht bereits!"); 		
	}
}

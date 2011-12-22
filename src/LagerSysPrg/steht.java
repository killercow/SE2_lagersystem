package LagerSysPrg;

public class steht implements IBodenRampeZustand {

	private ZustandRampe Zustand; 
	
	public steht(ZustandRampe bodenrampezustand){
		Zustand = bodenrampezustand;  
	}

	public void gerade() {
		System.out.println("ZustandRampe: BodenRampe wird nach unten gefahren!"); 
		Zustand.setIstinBewegung(true);
		Zustand.setzeAktuellenZustand(new gerade(Zustand));
		Zustand.setIstinBewegung(false); 
		Zustand.setStatus(1); 		
	}

	public void schraeg() {
		System.out.println("ZustandRampe: BodenRampe wird angehoben!"); 
		Zustand.setIstinBewegung(true); 
		Zustand.setzeAktuellenZustand(new schraeg(Zustand)); 
		Zustand.setIstinBewegung(false); 
		Zustand.setStatus(2); 
		
	}

	public void stoppen() {
		System.out.println("ZustandRampe: BodenRampe steht bereits!"); 	
	}
}

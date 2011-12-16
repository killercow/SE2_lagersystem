package LagerSysPrg;

public class Steht implements IMotorZustand{

	private MotorZustand Zustand; 
	
	public Steht(MotorZustand motorzustand){
		Zustand = motorzustand;  
	}

	public void rechts() {
		System.out.println("Motor wird rechts gedreht!"); 
		Zustand.setzeAktuellenZustand(new DrehtRechts(Zustand));
		Zustand.setStatus(1); 
		
	}

	public void links() {
		System.out.println("Motor wird links gedreht!"); 
		Zustand.setzeAktuellenZustand(new DrehtLinks(Zustand));
		Zustand.setStatus(2); 
		
	}

	public void stoppen() {
		System.out.println("Motor steht bereits!"); 		
	}
	
	
}

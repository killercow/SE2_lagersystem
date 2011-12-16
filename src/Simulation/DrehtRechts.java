package LagerSysPrg;

public class DrehtRechts implements IMotorZustand {
	
	private MotorZustand Zustand; 
	
	public DrehtRechts(MotorZustand motorzustand){
		Zustand = motorzustand;  
	}

	public void rechts() {
		System.out.println("Motor dreht bereits rechts!"); 
	}

	public void links() {
		System.out.println("Motor kann nicht links drehen!"); 
		
	}

	public void stoppen() {
		System.out.println("Motor wird gestoppt!"); 
		Zustand.setzeAktuellenZustand(new Steht(Zustand)); 
		Zustand.setStatus(0); 
	}



}

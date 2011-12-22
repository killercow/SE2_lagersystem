package Simulation;

public class DrehtRechts implements IMotorZustand {
	
	private MotorZustand Zustand; 
	
	public DrehtRechts(MotorZustand motorzustand){
		Zustand = motorzustand;  
	}

	public void rechts() {
		System.out.println("DrehtRechts: Motor dreht bereits rechts!"); 
	}

	public void links() {
		System.out.println("DrehtRechts: Motor kann nicht links drehen!"); 
		
	}

	public void stoppen() {
		System.out.println("DrehtRechts: Motor wird gestoppt!"); 
		Zustand.setzeAktuellenZustand(new Steht(Zustand)); 
		Zustand.setStatus(0); 
	}



}

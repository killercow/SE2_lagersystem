package LagerSysPrg;

public  class DrehtLinks implements IMotorZustand {

	private MotorZustand Zustand; 
	
	public DrehtLinks(MotorZustand motorzustand){
		Zustand = motorzustand;  
	}

	public void rechts() {
		System.out.println("Motor kann nicht rechts drehen"); 
	}

	public void links() {
		System.out.println("Motor dreht bereits links!"); 
		
	}

	public void stoppen() {
		System.out.println("Motor wird gestoppt!"); 
		Zustand.setzeAktuellenZustand(new Steht(Zustand)); 
		Zustand.setStatus(0); 
	}
}

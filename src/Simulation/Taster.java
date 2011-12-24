package Simulation;
import java.util.*; 


public class Taster {
 
	public int TasterAdresse;
	private TasterZustand tasterZustand = new TasterZustand(); 
	private Random generator = new Random(); 

	public Taster(){
	}

	public void ErstelleAdresse() {
		TasterAdresse = generator.nextInt(255); 
		System.out.println("Taster: Taster mit der Adresse " + TasterAdresse + " erstellt.");
	}
	
	public int GetTasterAdresse(){
		return TasterAdresse; 
	}
	
	public int GetTasterStatus(){
		return tasterZustand.getStatus(); 
	}
	
	public boolean WartenAufTaster(){
		try {
			Thread.sleep(3000);
			return true; 
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false; 
		}
	}
	
	public void Tasteraktivieren(){
		System.out.println("Taster: Der Taster wird aktiviert");
		int Status = GetTasterStatus(); 
		if(Status == 1){
			System.out.println("Taster: Der Taster ist bereits aktiviert");
		}
		tasterZustand.aktiv();
		
	}
	
	public void Tasterdeaktivieren(){
		System.out.println("Taster: Der Taster wird deaktiviert");
		int Status = GetTasterStatus(); 
		if(Status == 0){
			System.out.println("Taster: Der Taster ist bereits deaktiviert");
		}
		tasterZustand.inaktiv();
	}


}
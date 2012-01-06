package Simulation;
import java.util.*; 


public class Taster {
 
	public int TasterAdresse;
	public boolean istTasteraktiv = false; 
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
	
	public boolean GetTasterStatus(){
		return istTasteraktiv;  
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
		boolean Status = GetTasterStatus(); 
		if(Status == true){
			System.out.println("Taster: Der Taster ist bereits aktiviert");
		}
		istTasteraktiv = true;
		
	}
	
	public void Tasterdeaktivieren(){
		System.out.println("Taster: Der Taster wird deaktiviert");
		boolean Status = GetTasterStatus(); 
		if(Status == false){
			System.out.println("Taster: Der Taster ist bereits deaktiviert");
		}
		istTasteraktiv = false; 
	}


}
package Simulation;
import java.util.*; 


public class Taster {

	private int TasterAdresseDefault = 0; 
	public static int TasterAdresse;
	private TasterZustand tasterZustand = new TasterZustand(); 
	public boolean TasterIstAktiv = false; 

	public Taster(){
		this.TasterAdresse = ErstelleAdresse(); 
	}

	private int ErstelleAdresse() {
		Random generator = new Random(); 
		int xteTasterAdresse = TasterAdresseDefault + generator.nextInt(); 
		System.out.println("Taster: Taster mit der Adresse " + xteTasterAdresse + " erstellt.");
		return xteTasterAdresse;
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